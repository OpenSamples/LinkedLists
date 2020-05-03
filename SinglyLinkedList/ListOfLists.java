public class ListOfLists {
  
  public static void main(String[] args) {
    
    
  }
}

class ListOfBoxes {
  
  class Box {
    String name;
    Box next;
    Item content;
    
    public Box(String name) {
      this.name = name;
      this.next = null;
    }
    
    public String toString() {
      String result = "[" + name + "]";
      Item current = content;
      if (current != null) {
        result += " " + current;
        current = current.next;
        while (current != null) {
          result += ", " + current;
          current = current.next;
        }
      }
      result += " }";
      return result;
    }
    
  }
  
  class Item {
    String name;
    Item next;
    
    public Item(String item) {
      name = item;
      next = null;
    }
    
    public String toString() {
      return name;
    }
  }
}

