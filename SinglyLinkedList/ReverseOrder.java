public class ReverseOrder {
  
  public static void main(String[] args) {
    
    ReverseList list = new ReverseList();
    list.add("a");
    list.add("b");
    list.add("c");
    
    System.out.println("Original list: " + list);
    list.doReverse();
    System.out.println("Reverse list: " + list);
  }
}  
class ReverseList {
  
  class Node {
    
    String data;
    Node next;
    
    public Node(String st) {
      data = st;
      next = null;
    }
    
    public String toString() {
      return data;
    }
  }
  
  // pointer to first element of the list
  Node first = null;
  
  public void add(String st) {
    Node newNode = new Node(st);
    newNode.next = first;
    first = newNode;
  }
  
  public void doReverse() {
    if (first == null || first.next == null) {return;}
    // at list two nodes are needed to reverse them
    Node previous = null;
    Node current = first;
    
    while (current != null) {
      // save next node to preserve pointer to that node
      Node nextNode = current.next;
      // moving current node pointer to point to previous node
      current.next = previous;
      
      // moving to next two nodes
      previous = current;
      current = nextNode;
    }
    first = previous;
  }
  
  public String toString() {
    String result = "[ ";
    Node current = first;
    while (current != null) {
      result += current.data;
      if (current.next != null) {
        result += ", ";
      }
      current = current.next;
    }
    result += " ]";
    return result;
  }
}  
  
  
  
  
  
  
  
