public class TaskScheduler {
    static class Task {
        int id, priority;
        String name, dueDate;
        Task next;
        Task(int i, String n, int p, String d) {
            id = i; name = n; priority = p; dueDate = d;
        }
    }

    Task tail = null, current = null;

    void addBeginning(int id, String name, int priority, String date) {
        Task t = new Task(id, name, priority, date);
        if (tail == null) {
            tail = t;
            t.next = t;
        } else {
            t.next = tail.next;
            tail.next = t;
        }
        if (current == null) current = t;
    }

    void addEnd(int id, String name, int priority, String date) {
        addBeginning(id, name, priority, date);
        tail = tail.next;
    }

    void addPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1 || tail == null) { addBeginning(id, name, priority, date); return; }
        Task temp = tail.next;
        for (int i = 1; i < pos - 1 && temp != tail; i++) temp = temp.next;
        Task t = new Task(id, name, priority, date);
        t.next = temp.next;
        temp.next = t;
        if (temp == tail) tail = t;
    }

    void removeTask(int id) {
        if (tail == null) return;
        Task prev = tail, temp = tail.next;
        do {
            if (temp.id == id) {
                if (temp == tail && temp == tail.next) tail = null;
                else {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                }
                if (temp == current) current = (tail == null) ? null : temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("Task not found");
    }

    void viewCurrentAndNext() {
        if (current == null) { System.out.println("No task"); return; }
        System.out.println("Current task: " + current.name);
        current = current.next;
    }

    void display() {
        if (tail == null) { System.out.println("No tasks"); return; }
        Task temp = tail.next;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != tail.next);
    }

    void searchPriority(int p) {
        if (tail == null) return;
        Task temp = tail.next;
        do {
            if (temp.priority == p) System.out.println(temp.name + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != tail.next);
    }

    public static void main(String[] args) {
        TaskScheduler list = new TaskScheduler();
        list.addEnd(1, "Assignment", 1, "26-11-2026");
        list.addBeginning(2, "Read book", 2, "27-11-2026");
        list.addPosition(2, 3, "Project", 1, "28-11-2026");
        list.display();
        list.viewCurrentAndNext();
        System.out.println("Priority 1 tasks:");
        list.searchPriority(1);
        list.removeTask(3);
    }
}
