public class SocialMediaFriendConnections {
    static class User {
        int id, age;
        String name;
        int[] friends = new int[20];
        int friendCount = 0;
        User next;
        User(int i, String n, int a) { id = i; name = n; age = a; }
    }

    User head = null;

    void addUser(int id, String name, int age) {
        User u = new User(id, name, age);
        if (head == null) head = u;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = u;
        }
    }

    User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    void searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name) || String.valueOf(temp.id).equals(name))
                System.out.println(temp.id + " " + temp.name + " " + temp.age);
            temp = temp.next;
        }
    }

    void addFriend(int id1, int id2) {
        User u1 = findUser(id1), u2 = findUser(id2);
        if (u1 == null || u2 == null) { System.out.println("User not found"); return; }
        u1.friends[u1.friendCount++] = id2;
        u2.friends[u2.friendCount++] = id1;
    }

    void removeFriend(int id1, int id2) {
        User u1 = findUser(id1), u2 = findUser(id2);
        if (u1 != null) removeFromArray(u1, id2);
        if (u2 != null) removeFromArray(u2, id1);
    }

    void removeFromArray(User u, int id) {
        for (int i = 0; i < u.friendCount; i++) {
            if (u.friends[i] == id) {
                for (int j = i; j < u.friendCount - 1; j++)
                    u.friends[j] = u.friends[j + 1];
                u.friendCount--;
                return;
            }
        }
    }

    void displayFriends(int id) {
        User u = findUser(id);
        if (u == null) { System.out.println("User not found"); return; }
        System.out.println("Friends of " + u.name + ":");
        for (int i = 0; i < u.friendCount; i++) {
            User f = findUser(u.friends[i]);
            if (f != null) System.out.println(f.id + " " + f.name);
        }
    }

    void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1), u2 = findUser(id2);
        if (u1 == null || u2 == null) return;
        System.out.println("Mutual friends:");
        for (int i = 0; i < u1.friendCount; i++) {
            for (int j = 0; j < u2.friendCount; j++) {
                if (u1.friends[i] == u2.friends[j]) {
                    User f = findUser(u1.friends[i]);
                    if (f != null) System.out.println(f.name);
                }
            }
        }
    }

    void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendCount + " friends");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections s = new SocialMediaFriendConnections();
        s.addUser(1, "Aman", 20);
        s.addUser(2, "Riya", 19);
        s.addUser(3, "Rahul", 21);
        s.addUser(4, "Neha", 20);
        s.addFriend(1, 3);
        s.addFriend(2, 3);
        s.addFriend(1, 4);
        s.addFriend(2, 4);
        s.displayFriends(1);
        s.mutualFriends(1, 2);
        s.countFriends();
        s.removeFriend(1, 4);
        s.searchUser("Riya");
    }
}
