package dbService.dataSet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by DNS on 29.03.2017.
 */
@Entity
@Table(name = "card")
public class CardDS implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "book", unique = false, updatable = true)
    private String  book;

    @Column(name = "name", unique = false, updatable = true)
    private String name;

    @Column(name = "exchange", unique = false, updatable = true)
    private int exchange;

    public CardDS() {
    }

    public CardDS(String name, String book){
        this.setId(-1);
        this.setBook(book);
        this.setName(name);
        this.setExchange(1);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        if (exchange == 1){
            return "Книга: " + book + " все ещё на руках у: " + name + "<br>";
        }
        else return "Книгу: " + book +  " " + " брал " + name + " но уже вернул обратно" + "<br>";
    }
}
