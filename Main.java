import java.util.Date;
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Main.menu();

    }
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 1 if you like to <<<Load Swimmer>>>");
        System.out.println("Press 2 if you like to <<<Create Swimmer>>>");

        String input = scan.nextLine();

        switch(input){
            case "1":
                Swimmer swimmer = SwimmerData.loadFromFile();
                System.out.printf("Swimmer name: %s, age: %d\n", swimmer.getName(),swimmer.getAge());
                Main.menu();
                break;
            case"2":
                SwimmerData.createSwimmer();
                Main.menu();
                break;
        }
    }
}