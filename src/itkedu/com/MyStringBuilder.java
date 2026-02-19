package itkedu.com;

import java.util.Stack;

public class MyStringBuilder {

    private StringBuilder builder;
    private Stack<String> history;

    public MyStringBuilder() {
        builder = new StringBuilder();
        history = new Stack<>();
    }

    // Save snapshot before modification
    private void saveState() {
        history.push(builder.toString());
    }

    public MyStringBuilder append(String str) {
        saveState();
        builder.append(str);
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        saveState();
        builder.delete(start, end);
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            String previousState = history.pop();
            builder = new StringBuilder(previousState);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    // main method entry point
    public static void main(String[] args) {

        MyStringBuilder sb = new MyStringBuilder();

        sb.append("Hello");
        sb.append(" World");

        System.out.println("Current: " + sb);

        sb.undo();
        System.out.println("After 1 undo: " + sb);

        sb.undo();
        System.out.println("After 2 undo: " + sb);

        sb.undo(); // Nothing to undo
    }
}


