import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class pojo {
    @Id
    private int id;
    private int age;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}
