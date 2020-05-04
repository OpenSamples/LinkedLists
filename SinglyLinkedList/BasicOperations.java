public class BasicOperations {

  public static void main(String[] args) {
    ListOfNumbers list = new ListOfNumbers();
    System.out.println("How many numbers do you want in list?");
    int n = Svetovid.in.readInt();
    System.out.println("Input numbers.");
    for (int i = 0; i < n; i++) {
      double num = Svetovid.in.readDouble();
      list.addToBeginning(num);
    }
    System.out.println(list.toString());
  }
}

class ListOfNumbers {
  
  class Node {
  
    double number;
    Node next;
    
    public Node(double num) {
      number = num;
      Node next = null;
    }
    
    public String toString() {
      return number + "";
    }
  }
  // pointer to first node
  Node first;
  
  public ListOfNumbers() {
    first = null;
  }
  
  public void addToBeginning(double num) {
    Node newNode = new Node(num);
    newNode.next = first;
    first = newNode;
  }
  
  public void RemoveLastNode() {
  
    
  }
  
  public void ReverseList() {
  
    
  }
  
  public String toString() {
    String result = "List: [ ";
    Node current = first;
    while (current != null) {
      result += current.number + " ";
      current = current.next;
    }
    result += "]";
    return result;
  }
}