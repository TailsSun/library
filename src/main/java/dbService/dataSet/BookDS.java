package dbService.dataSet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DNS on 29.03.2017.
 */

@Entity
@Table(name = "book")
public class BookDS implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "book", unique = true, updatable = false)
    private String  book;

    @Column(name = "existence", unique = false, updatable = true)
    private int existence;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public BookDS(){
    }

    public BookDS(String name){
        this.setId(-1);
        this.setBook(name);
        this.setExistence(1);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getExistence() {
        return existence;
    }

    public void setExistence(int existence) {
        this.existence = existence;
    }
        @Override
    public String toString() {
        String s;
        if (existence == 1) {
            s = "В наличии";
        }
        else {
            s = "Отсутствует";
        }
            return " Наименование Книги: '" + book + "'   :" + s + "<br>";
    }


}
