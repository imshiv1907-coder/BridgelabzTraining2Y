public class InventoryManagementSystem {
    static class Item {
        String name, id;
        int quantity;
        double price;
        Item next;
        Item(String n, String i, int q, double p) {
            name = n; id = i; quantity = q; price = p;
        }
    }

    Item head = null;

    void addBeginning(String n, String id, int q, double p) {
        Item x = new Item(n, id, q, p);
        x.next = head;
        head = x;
    }

    void addEnd(String n, String id, int q, double p) {
        Item x = new Item(n, id, q, p);
        if (head == null) { head = x; return; }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = x;
    }

    void addPosition(int pos, String n, String id, int q, double p) {
        if (pos == 1) { addBeginning(n, id, q, p); return; }
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Invalid position"); return; }
        Item x = new Item(n, id, q, p);
        x.next = temp.next;
        temp.next = x;
    }

    void removeItem(String id) {
        if (head == null) return;
        if (head.id.equalsIgnoreCase(id)) { head = head.next; return; }
        Item temp = head;
        while (temp.next != null && !temp.next.id.equalsIgnoreCase(id)) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void updateQuantity(String id, int q) {
        Item temp = head;
        while (temp != null) {
            if (temp.id.equalsIgnoreCase(id)) { temp.quantity = q; return; }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void search(String key) {
        Item temp = head;
        while (temp != null) {
            if (temp.id.equalsIgnoreCase(key) || temp.name.equalsIgnoreCase(key))
                System.out.println(temp.name + " " + temp.id + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    double totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total = total + temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    void sortByName() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.name.compareToIgnoreCase(j.name) > 0) {
                    String n = i.name; i.name = j.name; j.name = n;
                    String id = i.id; i.id = j.id; j.id = id;
                    int q = i.quantity; i.quantity = j.quantity; j.quantity = q;
                    double p = i.price; i.price = j.price; j.price = p;
                }
            }
        }
    }

    void sortByPriceDescending() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.price < j.price) {
                    String n = i.name; i.name = j.name; j.name = n;
                    String id = i.id; i.id = j.id; j.id = id;
                    int q = i.quantity; i.quantity = j.quantity; j.quantity = q;
                    double p = i.price; i.price = j.price; j.price = p;
                }
            }
        }
    }

    void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " " + temp.id + " Qty:" + temp.quantity + " Price:" + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem list = new InventoryManagementSystem();
        list.addEnd("Keyboard", "I1", 5, 700);
        list.addBeginning("Mouse", "I2", 10, 300);
        list.addPosition(2, "Monitor", "I3", 2, 6000);
        list.display();
        System.out.println("Total value = " + list.totalValue());
        list.updateQuantity("I1", 8);
        list.sortByName();
        System.out.println("Sorted by name:");
        list.display();
        list.search("I3");
        list.removeItem("I2");
    }
}
