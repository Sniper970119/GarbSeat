/**
 * Created by admin on 2017/12/24.
 */
public class StudentNubmer {
    public String number = null;
    private static final StudentNubmer s = new StudentNubmer();
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public static StudentNubmer getInstance()
    {
        return s;
    }
}





