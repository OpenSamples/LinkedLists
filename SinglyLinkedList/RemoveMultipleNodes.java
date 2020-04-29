public class RemoveMultipleNodes {
  
  public static void main(String[] args) {
    CharList list = new CharList();
    list.removeAllLowerCaseLetters();
  }
}

class CharList {
  
  class Node {
    
    char character;
    Node next;
    
    public Node(char ch) {
      character = ch;
      next = null;
    }
    
    public String toString() {
      return character + "";
    }
  }
  // pointer to first node
  Node first;
  
  public CharList() {
    first = null;
  } 
  
  public int removeAllLowerCaseLetters() {
    int counter = 0;
    // remove characters from beginning of the list
    while (first != null && first.character >= 'a' && first.character <= 'z') {
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
        if (current.character >= 'a' && current.character <= 'z') {
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
}








