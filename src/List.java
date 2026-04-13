import java.util.ArrayList;
import java.util.Scanner;

public class List {
    static ArrayList<String> myArrList = new ArrayList<>();
    public static void main() {

        boolean done = false;
        Scanner in = new Scanner(System.in);
        do {
            display();
            String choice = SafeInput.getRegExString(in,"What would you like to do with your list?\n[A=Add an item, D=Delete an item, I=Insert an item, P=Print list, Q=Quit program]","^([aAdDiIpPqQ])$");
            if(choice.equalsIgnoreCase("q")){
                done = SafeInput.getYNConfirm(in,"Are you sure?");
            } else if (choice.equalsIgnoreCase("a")) {
                add(in);
            } else if (choice.equalsIgnoreCase("D")) {
                delete(in);
            } else if (choice.equalsIgnoreCase("p")) {
            } else if (choice.equalsIgnoreCase("I")) {
                insert(in);
            }


        }while(!done);


    }
    public static void display(){
        for(int i=0;i<myArrList.size();i++){
            System.out.print((i+1) + ".) " + myArrList.get(i));
            System.out.println();
        }
    }
    public static void delete(Scanner pipe){
        if (myArrList.size() >0) {
            int m = SafeInput.getRangedInt(pipe, "Enter the location of the item you wish to delete in the list", 1, myArrList.size());
            m = m - 1;
            myArrList.remove(m);
        }
    }
    public static void add(Scanner pipe) {
        boolean loop = true;
        do {
            String item = SafeInput.getNonZeroLenString(pipe, "Enter an item to add to the list");
            myArrList.add(item);
            loop = SafeInput.getYNConfirm(pipe, "Would you like to continue adding items?");
        } while (loop);
    }
    public static void insert(Scanner pipe) {
        if(myArrList.size()>0) {
            int place = SafeInput.getRangedInt(pipe, "Enter the place where you would like to insert the new item", 1, myArrList.size());
            place= place-1;
            String newItem = SafeInput.getNonZeroLenString(pipe,"Enter the name of the new item");
            myArrList.set(place, newItem);
        }
    }
}
