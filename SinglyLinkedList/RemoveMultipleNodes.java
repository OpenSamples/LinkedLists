public class RemoveMultipleNodes {
  
  public static void main(String[] args) {
    
    CharList list = new CharList();
    
    System.out.println("Enter how many chars you want in the list:");
    int n = Svetovid.in.readInt();
    
    System.out.println("Enter characters:");
    for (int i = 0; i < n; i++) {
      char ch = Svetovid.in.readChar();
      list.addAtBeginning(ch);
    }
    System.out.println("Complete list: " + list.toString());
    
    System.out.println("Number of lower case letters in list is: " 
                         + list.removeAllLowerCaseLetters()
                         + "\nList without lower case letters: " 
                         + list.toString());
    
    System.out.println("New list which contains only digits: " 
                         + list.separateDigitsOrderAsEntered(new CharList()).toString());
  }
}

class CharList {
  
  class Node {
    
    char data;
    Node next;
    
    public Node(char ch) {
      data = ch;
      next = null;
    }
    
    public String toString() {
      return data + "";
    }
  }
  // pointer to first node
  Node first;
  
  public CharList() {
    first = null;
  } 
  
  public void addAtBeginning(char ch) {
    Node newNode = new Node(ch);
    newNode.next = first;
    first = newNode;
  }
  
  public int removeAllLowerCaseLetters() {
    int counter = 0;
    // remove datas from beginning of the list
    while (first != null && first.data >= 'a' && first.data <= 'z') {
      first = first.next;
      counter++;
    }
    // looking for lower case letters in the rest to the list
    if (first != null) {
      Node current = first;
      while (current.next != null) {
        // moving step by step until last node
        Node previous = current;
        current = current.next;
        if (current.data >= 'a' && current.data <= 'z') {
          // moving pointers around the node
          previous.next = current.next;
          counter++;
          // moving one step back to check this node in the next cycle
          current = previous;
        }
      }
    }
    return counter;
  }
  
  public CharList separateDigitsOrderAsEntered(CharList digitsList) {
    // to be able to add digits at the end of list local variable is required
    Node digitsEnd = null;
    Node current, previous;
    while (first != null && first.data >= '0' && first.data <= '9') {
      current = first;
      first = first.next;
      if (digitsList.first == null) {
        digitsList.first = current;
        digitsEnd = current;
        current.next = null;
      } else {
        digitsEnd.next = current;
        current.next = null;
        digitsEnd = current;
      }
    }
    if (first != null) {
      current = first;
      while (current.next != null) {
        previous = current;
        current = current.next;
        if (current.data >= '0' && current.data <= '9') {
          previous.next = current.next;
          if (digitsList.first == null) {
            digitsList.first = current;
            current.next = null;
            digitsEnd = current;
          } else {
            digitsEnd.next = current;
            current.next = null;
            digitsEnd = current;
          }
          current = previous;
        }
      }
    }
    return digitsList;
  }
  
  public String toString() {
    String result = "[ ";
    Node current = first;
    while (current != null) {
      if (current.next != null) {
        result += current.data + ", ";
      }
      else {
        result += current.data + " ";
      }
      current = current.next;
    }
    result += "]";
    return result;
  }
}








