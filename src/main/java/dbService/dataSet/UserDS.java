package dbService.dataSet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DNS on 29.03.2017.
 */
@Entity
@Table(name = "users")
public class UserDS implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "existence", unique = false, updatable = false)
    private byte existence;

    public UserDS(){}

    public UserDS(String name){
        this.setId(-1);
        this.setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getExistence() {
        return existence;
    }

    public void setExistence(byte existence) {
        this.existence = existence;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", existence= " + existence + "<br>";
    }
}
