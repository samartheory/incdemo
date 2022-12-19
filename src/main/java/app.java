
import java.sql.SQLException;
public class app {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        hibernateUtil.configure();
        hibernate api = new hibernate();
        for(int i=6;i<8;i++) {
            pojo p = new pojo();
            p.setAge(i+20);
            p.setId(i+87);
            p.setName("usrnm" + i);
            api.insert(p);
        }
        System.out.println("this");
        api.printAll();
    }
}
