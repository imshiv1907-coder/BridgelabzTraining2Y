public class TextEditorUndoRedo {
    static class State {
        String text;
        State prev, next;
        State(String t) { text = t; }
    }

    State head = null, tail = null, current = null;
    int count = 0;
    int limit = 10;

    void addState(String text) {
        State s = new State(text);
        if (current == null) {
            head = tail = current = s;
            count = 1;
            return;
        }

        current.next = null;
        tail = current;
        s.prev = current;
        current.next = s;
        current = s;
        tail = s;
        count++;

        while (count > limit) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) current = current.prev;
        else System.out.println("Nothing to undo");
    }

    void redo() {
        if (current != null && current.next != null) current = current.next;
        else System.out.println("Nothing to redo");
    }

    void showCurrent() {
        if (current == null) System.out.println("Text is empty");
        else System.out.println("Current text: " + current.text);
    }

    void showHistory() {
        State temp = head;
        while (temp != null) {
            if (temp == current) System.out.print("-> ");
            System.out.println(temp.text);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.addState("");
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.showCurrent();
        editor.undo();
        editor.showCurrent();
        editor.redo();
        editor.showCurrent();
        System.out.println("History:");
        editor.showHistory();
    }
}
