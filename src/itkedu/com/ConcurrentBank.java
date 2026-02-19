package itkedu.com;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentBank {

 
    // 1️⃣ BankAccount Class
 
    static class BankAccount {

        private final int accountNumber;
        private double balance;

        public BankAccount(int accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public synchronized void deposit(double amount) {
            balance += amount;
        }

        public synchronized boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public synchronized double getBalance() {
            return balance;
        }
    }

  
    // ConcurrentBank Class
  
    private final Map<Integer, BankAccount> accounts = new ConcurrentHashMap<>();

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
    }

    public void transfer(int fromAcc, int toAcc, double amount) {

        BankAccount acc1 = accounts.get(fromAcc);
        BankAccount acc2 = accounts.get(toAcc);

        if (acc1 == null || acc2 == null) {
            throw new IllegalArgumentException("Account not found");
        }

        // Deadlock prevention: lock in consistent order
        BankAccount firstLock = acc1.getAccountNumber() < acc2.getAccountNumber() ? acc1 : acc2;
        BankAccount secondLock = acc1.getAccountNumber() < acc2.getAccountNumber() ? acc2 : acc1;

        synchronized (firstLock) {
            synchronized (secondLock) {

                if (acc1.withdraw(amount)) {
                    acc2.deposit(amount);
                    System.out.println("Transferred " + amount +
                            " from " + fromAcc + " to " + toAcc);
                } else {
                    System.out.println("Transfer failed: insufficient balance");
                }
            }
        }
    }

    public double getTotalBalance() {
        double total = 0;

        for (BankAccount acc : accounts.values()) {
            total += acc.getBalance();
        }

        return total;
    }

    
    // 3 MAIN METHOD

    public static void main(String[] args) throws InterruptedException {

        ConcurrentBank bank = new ConcurrentBank();

        bank.createAccount(1, 1000);
        bank.createAccount(2, 1000);
        bank.createAccount(3, 1000);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Multiple concurrent transfers
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> bank.transfer(1, 2, 100));
            executor.submit(() -> bank.transfer(2, 3, 50));
            executor.submit(() -> bank.transfer(3, 1, 70));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\nFinal Total Balance: " + bank.getTotalBalance());
    }
}

