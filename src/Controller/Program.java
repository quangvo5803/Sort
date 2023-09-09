package Controller;
import Common.Validation;
import Model.Element;
import Common.Algorithm;
import View.Menu;

public class Program extends Menu<String> {
  static String[] mainChoice = {"Sorting","Exit"};
    protected Validation V;
    protected Algorithm a;
    protected int [] array;
    protected int size;

    public Program(Element e) {
        super("Sorting and Searching Program",mainChoice);
        v = new Validation();
        a = new Algorithm();
        size = e.getSize();
        array = e.getArray();
    }
    
    //---------------------------------------
    public void execute(int n){
        switch(n){
            case 1:{
                sort();
                break;
            }
            case 2:
                System.exit(0);
        }
    }
    
    //----------------------------------------
    public void sort(){
        final String[] sortChoice = {"Bubble sort","Quick sort","Exit"};
        class sortMenu extends Menu<String>{
            public sortMenu(){
                super("Sort option",sortChoice);
            }
            
            @Override
            public void execute(int n){
                switch(n){
                    case 1:{
                        v.display("Unsorted array: ", array);
                        a.bubbleSort(array);
                        v.display("Sortted array: ", array);
                        System.out.println("");
                        break;
                    }
                    case 2:{
                        v.display("Unsorted array: ", array);
                        a.quickSort(array, 0, size-1);
                        v.display("Sortted array: ", array);
                        System.out.println("");
                        break;
                    }
                    case 3:{
                        System.exit(0);
                    }
                }
            }
        }
        sortMenu sm = new sortMenu();
        sm.run();
    }
}
