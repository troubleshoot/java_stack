import java.util.ArrayList;

public class ListOfExceptions {
  public static void main(String[] args) {
    ArrayList myList = new ArrayList<>();
    myList.add("13");
    myList.add("hello world");
    myList.add(48);
    myList.add("Goodbye World");
    for(int i=0;i<myList.size();i++){
      try{
        int castedValue = (Integer) myList.get(i);
        System.out.println("Casted: " + myList.get(i));
      }
      catch(ClassCastException e){
        System.out.println("Exception: " + myList.get(i));
      }
    }
  }
}