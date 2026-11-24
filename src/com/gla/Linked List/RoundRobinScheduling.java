public class RoundRobinScheduling {
    static class Process {
        int id, burst, remaining;
        Process next;
        Process(int i, int b) { id = i; burst = b; remaining = b; }
    }

    Process tail = null;
    int size = 0;

    void addProcess(int id, int burst) {
        Process p = new Process(id, burst);
        if (tail == null) {
            tail = p;
            p.next = p;
        } else {
            p.next = tail.next;
            tail.next = p;
            tail = p;
        }
        size++;
    }

    void display() {
        if (tail == null) { System.out.println("Queue is empty"); return; }
        Process temp = tail.next;
        do {
            System.out.print("P" + temp.id + "(" + temp.remaining + ") ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println();
    }

    void schedule(int quantum) {
        int n = size;
        int[] burst = new int[n];
        int[] completion = new int[n];
        int[] ids = new int[n];
        Process temp = tail.next;
        for (int i = 0; i < n; i++) {
            ids[i] = temp.id;
            burst[i] = temp.burst;
            temp = temp.next;
        }

        int time = 0;
        Process prev = tail;
        Process current = tail.next;

        while (tail != null) {
            if (current.remaining > quantum) {
                current.remaining = current.remaining - quantum;
                time = time + quantum;
                prev = current;
                current = current.next;
            } else {
                time = time + current.remaining;
                current.remaining = 0;
                for (int i = 0; i < n; i++)
                    if (ids[i] == current.id) completion[i] = time;

                if (size == 1) {
                    tail = null;
                    current = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) tail = prev;
                    current = current.next;
                }
                size--;
            }
            System.out.println("Queue after one turn:");
            display();
        }

        double totalWaiting = 0, totalTurnaround = 0;
        for (int i = 0; i < n; i++) {
            totalTurnaround = totalTurnaround + completion[i];
            totalWaiting = totalWaiting + completion[i] - burst[i];
        }
        System.out.println("Average waiting time = " + totalWaiting / n);
        System.out.println("Average turnaround time = " + totalTurnaround / n);
    }

    public static void main(String[] args) {
        RoundRobinScheduling r = new RoundRobinScheduling();
        r.addProcess(1, 5);
        r.addProcess(2, 3);
        r.addProcess(3, 7);
        System.out.println("Initial Queue:");
        r.display();
        r.schedule(2);
    }
}
