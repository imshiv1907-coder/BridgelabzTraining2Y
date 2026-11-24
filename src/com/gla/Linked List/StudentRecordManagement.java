public class StudentRecordManagement {
    static class Student {
        int rollNo, age;
        String name, grade;
        Student next;

        Student(int r, String n, int a, String g) {
            rollNo = r;
            name = n;
            age = a;
            grade = g;
            next = null;
        }
    }

    Student head = null;

    void addBeginning(int r, String n, int a, String g) {
        Student s = new Student(r, n, a, g);
        s.next = head;
        head = s;
    }

    void addEnd(int r, String n, int a, String g) {
        Student s = new Student(r, n, a, g);
        if (head == null) {
            head = s;
            return;
        }
        Student temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = s;
    }

    void addPosition(int pos, int r, String n, int a, String g) {
        if (pos == 1) {
            addBeginning(r, n, a, g);
            return;
        }
        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        Student s = new Student(r, n, a, g);
        s.next = temp.next;
        temp.next = s;
    }

    void deleteStudent(int r) {
        if (head == null) return;
        if (head.rollNo == r) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != r) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void searchStudent(int r) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                System.out.println(temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int r, String g) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                temp.grade = g;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        list.addEnd(101, "Aman", 20, "A");
        list.addBeginning(100, "Riya", 19, "B");
        list.addPosition(2, 102, "Rahul", 21, "A+");
        System.out.println("Student Records:");
        list.display();
        list.updateGrade(100, "A+");
        list.searchStudent(100);
        list.deleteStudent(102);
        System.out.println("After deleting:");
        list.display();
    }
}
