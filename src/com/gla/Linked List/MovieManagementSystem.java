public class MovieManagementSystem {
    static class Movie {
        String title, director;
        int year;
        double rating;
        Movie prev, next;

        Movie(String t, String d, int y, double r) {
            title = t; director = d; year = y; rating = r;
        }
    }

    Movie head = null, tail = null;

    void addBeginning(String t, String d, int y, double r) {
        Movie m = new Movie(t, d, y, r);
        if (head == null) head = tail = m;
        else {
            m.next = head;
            head.prev = m;
            head = m;
        }
    }

    void addEnd(String t, String d, int y, double r) {
        Movie m = new Movie(t, d, y, r);
        if (tail == null) head = tail = m;
        else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }
    }

    void addPosition(int pos, String t, String d, int y, double r) {
        if (pos == 1) { addBeginning(t, d, y, r); return; }
        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Invalid position"); return; }
        if (temp == tail) { addEnd(t, d, y, r); return; }
        Movie m = new Movie(t, d, y, r);
        m.next = temp.next;
        m.prev = temp;
        temp.next.prev = m;
        temp.next = m;
    }

    void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
        if (temp == null) { System.out.println("Movie not found"); return; }
        if (temp == head) head = temp.next;
        else temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;
        else temp.next.prev = temp.prev;
    }

    void searchDirector(String d) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(d)) show(temp);
            temp = temp.next;
        }
    }

    void searchRating(double r) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == r) show(temp);
            temp = temp.next;
        }
    }

    void updateRating(String t, double r) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(t)) { temp.rating = r; return; }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    void show(Movie m) {
        System.out.println(m.title + " | " + m.director + " | " + m.year + " | " + m.rating);
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) { show(temp); temp = temp.next; }
    }

    void displayReverse() {
        Movie temp = tail;
        while (temp != null) { show(temp); temp = temp.prev; }
    }

    public static void main(String[] args) {
        MovieManagementSystem list = new MovieManagementSystem();
        list.addEnd("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        list.addBeginning("Dangal", "Nitesh Tiwari", 2016, 8.3);
        list.addPosition(2, "Taare Zameen Par", "Aamir Khan", 2007, 8.3);
        System.out.println("Forward:");
        list.displayForward();
        System.out.println("Reverse:");
        list.displayReverse();
        list.updateRating("Dangal", 8.5);
        list.searchDirector("Aamir Khan");
        list.removeMovie("3 Idiots");
    }
}
