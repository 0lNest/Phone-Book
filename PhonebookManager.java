
import java.util.ArrayList;
import java.util.Scanner;
class PhonebookManager {
private ArrayList<ListNode> collection;
public PhonebookManager() {
this.collection = new ArrayList<ListNode>();
}
public void add(ListNode node) {
collection.add(node);
}
public void set(int i, ListNode node) {
collection.set(i, node);
}
public void addFirst(ListNode node) {
ArrayList<ListNode> filler = new ArrayList<ListNode>();
filler.add(node);
filler.addAll(collection);
collection = filler;
}
public void addLast(ListNode node) {
collection.add(node);
}
public ListNode get(int i) {
return collection.get(i);
}
public ListNode getFirst() {
return collection.get(0);
}
public ListNode getLast() {
return collection.get(collection.size() - 1);
}
public void remove(int i) {
collection.remove(i);
}
public void removeFirst() {
collection.remove(0);
}
public void removeLast() {
collection.remove(collection.size() - 1);
}
public int size() {
return collection.size();
}
public boolean contains(Object o) {
if (o instanceof ListNode) {
return collection.contains(o);
} else if (o instanceof String) {
for (ListNode node : collection) {
for (int i = 0; i < 5; i++) {
if (node.get(i).equals(o)) {
return true;
}
}
}
return false;
} else {
return false;
}
}
public String toString() {
String total = "";
for (ListNode n : collection) {
total += n.toString() + "\n";
}
return total;
}
}
