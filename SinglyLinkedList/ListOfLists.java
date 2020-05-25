public class ListOfLists {
  
  public static void main(String[] args) {
    
    
  }
}

class ListOfStorages {

  private Box firstBox;
  
  class Storage {
    String name;
    Storage next;
    Box content;
    
    public Storage(String name) {
      this.name = name;
      this.next = null;
    }
    
    public String toString() {
      String result = "[" + name + "]";
      Box current = content;
      if (current != null) {
        result += " " + current;
        current = current.next;
        while (current != null) {
          result += ", " + current;
          current = current.next;
        }
      }
      result += " ]";
      return result;
    }
  }
  
  class Box {
    String name;
    Box next;
    
    public Box(String name) {
      this.name = name;
      this.next = null;
    }
    
    public String toString() {
      return name;
    }
  }
}


