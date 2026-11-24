public class LibraryManagementSystem {
    static class Book {
        String title, author, genre, id;
        boolean available;
        Book prev, next;
        Book(String t, String a, String g, String i, boolean v) {
            title = t; author = a; genre = g; id = i; available = v;
        }
    }

    Book head = null, tail = null;
    int count = 0;

    void addBeginning(String t, String a, String g, String id, boolean v) {
        Book b = new Book(t, a, g, id, v);
        if (head == null) head = tail = b;
        else { b.next = head; head.prev = b; head = b; }
        count++;
    }

    void addEnd(String t, String a, String g, String id, boolean v) {
        Book b = new Book(t, a, g, id, v);
        if (tail == null) head = tail = b;
        else { tail.next = b; b.prev = tail; tail = b; }
        count++;
    }

    void addPosition(int pos, String t, String a, String g, String id, boolean v) {
        if (pos == 1) { addBeginning(t, a, g, id, v); return; }
        if (pos == count + 1) { addEnd(t, a, g, id, v); return; }
        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Invalid position"); return; }
        Book b = new Book(t, a, g, id, v);
        b.next = temp.next; b.prev = temp;
        temp.next.prev = b; temp.next = b;
        count++;
    }

    void removeBook(String id) {
        Book temp = head;
        while (temp != null && !temp.id.equalsIgnoreCase(id)) temp = temp.next;
        if (temp == null) { System.out.println("Book not found"); return; }
        if (temp == head) head = temp.next;
        else temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;
        else temp.next.prev = temp.prev;
        count--;
    }

    void search(String key) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key))
                show(temp);
            temp = temp.next;
        }
    }

    void updateStatus(String id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id.equalsIgnoreCase(id)) { temp.available = status; return; }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    void show(Book b) {
        System.out.println(b.title + " | " + b.author + " | " + b.genre + " | " +
                b.id + " | " + (b.available ? "Available" : "Issued"));
    }

    void displayForward() {
        Book temp = head;
        while (temp != null) { show(temp); temp = temp.next; }
    }

    void displayReverse() {
        Book temp = tail;
        while (temp != null) { show(temp); temp = temp.prev; }
    }

    public static void main(String[] args) {
        LibraryManagementSystem list = new LibraryManagementSystem();
        list.addEnd("The Alchemist", "Paulo Coelho", "Fiction", "B1", true);
        list.addBeginning("Wings of Fire", "A.P.J. Abdul Kalam", "Biography", "B2", true);
        list.addPosition(2, "1984", "George Orwell", "Novel", "B3", false);
        System.out.println("Forward:");
        list.displayForward();
        System.out.println("Reverse:");
        list.displayReverse();
        list.updateStatus("B3", true);
        list.search("George Orwell");
        list.removeBook("B1");
        System.out.println("Total books: " + list.count);
    }
}
