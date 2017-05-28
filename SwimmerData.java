import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
public class SwimmerData{

    @SuppressWarnings("unchecked")
    public static void saveToFile(Swimmer swimmer) {
        try {
            FileOutputStream fos = new FileOutputStream(SwimmerData.getFileName(swimmer.getName()));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(swimmer);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saveToFile");
            e.printStackTrace();
        }
    }
    public static String getFileName(String name) {
        return "data/Swimmers/" + name + ".txt";
    }

    public static Swimmer loadFromFile(){
        Scanner scan = new Scanner(System.in);
        String name = null;

        System.out.println("Enter Swimmers name");
        name = scan.nextLine();
        Swimmer swimmer;
        try {
            String path = SwimmerData.getFileName(name);
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            swimmer = (Swimmer)ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error loading, try again");
            return SwimmerData.loadFromFile();
        }   

        return swimmer;
    }
    public static void createSwimmer(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String inputName = scan.nextLine();

        System.out.print("Enter Birhday: ");
        String inputBirthday = scan.nextLine();

        Swimmer swimmer = new Swimmer(inputName, inputBirthday);

        SwimmerData.saveToFile(swimmer);
    }
}