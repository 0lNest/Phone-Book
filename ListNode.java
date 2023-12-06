
// Name: Oleksandr Nesterov
// Class: CS &145
// Date: 10/31/2023
// Sources: github
// Phone Book
import java.util.ArrayList;
import java.util.Scanner;
class ListNode {
private String[] info;
public ListNode(String firstName, String lastName, String address, String city,
String phoneNumber) {
String[] info = {firstName, lastName, address, city, phoneNumber};
this.info = info;
}
public String get(int i) {
return info[i];
}
public void set(int i, String value) {
info[i] = value;
}
public String toString() {
String total = "";
String[] descriptions = {"First Name", "Last Name", "Address", "City",
"Phone Number"};
int i = 0;
for (String s : info) {
total += descriptions[i] + ": " + s + "\n";
i++;
}
return total;
}
}
