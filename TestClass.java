
import java.util.ArrayList;
import java.util.Scanner;
public class TestClass {
public static void intro() {
System.out.println("Welcome to Phonebook Manager");
System.out.println("This program is able to create, store, and delete
information from a notebook.");
System.out.println();
}
public static void options() {
System.out.println("Add a contact (a)");
System.out.println("Remove a contact (r)");
System.out.println("Edit the phonebook manager (e)");
System.out.println("View the entirety of the phonebook (p)");
System.out.println("Check if an entry is in the phonebook (c)");
System.out.println("Get a specific contact (g)");
System.out.println("Print the size of the phonebook (s)");
System.out.println("Quit the program (q)");
}
public static ListNode addNode(Scanner scan) {
String[] infoNames = {"First Name", "Last Name", "Address", "City", "Phone
Number"};
String[] info = new String[5];
for (int i = 0; i < 5; i++) {
System.out.print("Enter a " + infoNames[i] + ": ");
info[i] = scan.nextLine();
System.out.println();
}
System.out.println();
return new ListNode(info[0], info[1], info[2], info[3], info[4]);
}
public static boolean contains(PhonebookManager phonebook, Scanner scan) {
System.out.println("What entry would you like to check?");
String input = scan.nextLine();
return phonebook.contains(input);
}
public static void session() {
PhonebookManager phonebook = new PhonebookManager();
Scanner scan = new Scanner(System.in);
boolean active = true;
while (active) {
options();
String input = scan.nextLine();
input = input.toLowerCase();
System.out.println();
switch (input.charAt(0)) {
case 'a':
ListNode node = addNode(scan);
if (phonebook.size() == 0) {
System.out.println("What index would you like to add it to?
(0)");
} else {
System.out.println("What index would you like to add it to?
(0-" + (phonebook.size()) + ")");
}
try {
int pos = scan.nextInt();
scan.nextLine();
if (pos == 0) {
phonebook.addFirst(node);
System.out.println("Successfully added to first node");
} else if (pos == phonebook.size()) {
phonebook.addLast(node);
System.out.println("Successfully added to last node");
} else if (pos <= phonebook.size() && pos >= 0) {
phonebook.add(node);
System.out.println("Successfully added node");
} else {
System.out.println("Index out of bounds!");
}
} catch (Exception e) {
System.out.println("Not a valid integer!");
break;
}
break;
case 'r':
if (phonebook.size() == 0) {
System.out.println("No contacts exist!");
break;
} else if (phonebook.size() == 1) {
System.out.println("What index would you like to remove?
(0)");
} else {
System.out.println("What index would you like to remove?
(0-" + (phonebook.size() - 1) + ")");
}
try {
int pos = scan.nextInt();
scan.nextLine();
if (pos == 0) {
phonebook.removeFirst();
System.out.println("Successfully removed first node");
} else if (pos == phonebook.size() - 1) {
phonebook.removeLast();
System.out.println("Successfully removed last node");
} else if (pos < phonebook.size() && pos >= 0) {
phonebook.remove(pos);
System.out.println("Successfully removed node no." +
pos);
} else {
System.out.println("Index out of bounds!");
}
} catch (Exception e) {
System.out.println("Not a valid integer!");
break;
}
break;
case 'e':
if (phonebook.size() == 0) {
System.out.println("No contacts exist!");
break;
} else if (phonebook.size() == 1) {
System.out.println("What index would you like to edit?
(0)");
} else {
System.out.println("What index would you like to edit? (0-"
+ (phonebook.size() - 1) + ")");
}
try {
int index = scan.nextInt();
scan.nextLine();
if (index >= phonebook.size() || index < 0) {
System.out.println("Invalid index!");
break;
} else {
phonebook.set(index, addNode(scan));
System.out.println("Successfully edited node at index "
+ index);
}
} catch (Exception e) {
System.out.println("Not an integer!");
break;
}
break;
case 'c':
boolean existence = contains(phonebook, scan);
if (existence) {
System.out.println("The phonebook contains such entry");
} else {
System.out.println("The phonebook does not contain such
entry");
}
break;
case 'p':
System.out.println(phonebook.toString());
break;
case 'g':
if (phonebook.size() == 0) {
System.out.println("No contacts exist!");
break;
} else if (phonebook.size() == 1) {
System.out.println("What index would you like to get?
(0)");
} else {
System.out.println("What index would you like to get? (0-"
+ (phonebook.size() - 1) + ")");
}
try {
int pos = scan.nextInt();
scan.nextLine();
if (pos == 0) {
System.out.println(phonebook.getFirst().toString());
} else if (pos == phonebook.size() - 1) {
System.out.println(phonebook.getLast().toString());
} else if (pos < phonebook.size() && pos >= 0) {
System.out.println(phonebook.get(pos).toString());
} else {
System.out.println("Index out of bounds!");
}
} catch (Exception e) {
System.out.println("Not a valid integer!");
break;
}
break;
case 's':
System.out.println("The phonebook is of size " +
phonebook.size());
break;
case 'q':
System.out.println("Goodbye, thank you for using Phonebook
Manager");
active = false;
break;
default:
System.out.println("Invalid command!");
break;
}
System.out.println();
}
scan.close();
}
public static void main(String[] args) {
intro();
session();
}
}
