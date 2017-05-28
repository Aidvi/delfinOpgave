import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Swimmer implements Serializable{
    private String name;
    private Date birthday;

    public Swimmer(String name, String birthday){
        this.name = name;
        this.setBirthday(birthday); 
    }

    private void setBirthday(String birthday){
        Date date = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(birthday);
        }catch(Exception e){
            System.out.println("Error setUnixBirthday");
        }
        this.birthday = date;
    }
    public String getName(){
        return this.name;
    }
    public Date getBirthday(){
        return this.birthday;
    }
    public int getAge(){
        Date now = new Date();
        double diff = now.getTime() - this.birthday.getTime();
        double d = (24 * 60 * 60 * 365);
        int age = (int)((diff / d) /1000);

        return age;
    }

}