public class OnlineTicketReservationSystem {
    static class Ticket {
        int id, seatNo;
        String customer, movie, bookingTime;
        Ticket next;
        Ticket(int i, String c, String m, int s, String b) {
            id = i; customer = c; movie = m; seatNo = s; bookingTime = b;
        }
    }

    Ticket tail = null;
    int count = 0;

    void bookTicket(int id, String customer, String movie, int seat, String time) {
        Ticket t = new Ticket(id, customer, movie, seat, time);
        if (tail == null) {
            tail = t;
            t.next = t;
        } else {
            t.next = tail.next;
            tail.next = t;
            tail = t;
        }
        count++;
    }

    void cancelTicket(int id) {
        if (tail == null) return;
        Ticket prev = tail, temp = tail.next;
        do {
            if (temp.id == id) {
                if (count == 1) tail = null;
                else {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                }
                count--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("Ticket not found");
    }

    void displayTickets() {
        if (tail == null) { System.out.println("No tickets booked"); return; }
        Ticket temp = tail.next;
        do {
            show(temp);
            temp = temp.next;
        } while (temp != tail.next);
    }

    void searchTicket(String key) {
        if (tail == null) return;
        Ticket temp = tail.next;
        do {
            if (temp.customer.equalsIgnoreCase(key) || temp.movie.equalsIgnoreCase(key))
                show(temp);
            temp = temp.next;
        } while (temp != tail.next);
    }

    void show(Ticket t) {
        System.out.println(t.id + " " + t.customer + " " + t.movie + " Seat:" +
                t.seatNo + " Time:" + t.bookingTime);
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem list = new OnlineTicketReservationSystem();
        list.bookTicket(101, "Aman", "Interstellar", 12, "6:30 PM");
        list.bookTicket(102, "Riya", "Inception", 8, "8:00 PM");
        list.bookTicket(103, "Rahul", "Interstellar", 13, "6:30 PM");
        System.out.println("All booked tickets:");
        list.displayTickets();
        System.out.println("Search by movie:");
        list.searchTicket("Interstellar");
        System.out.println("Total tickets: " + list.count);
        list.cancelTicket(102);
        System.out.println("After cancellation:");
        list.displayTickets();
    }
}
