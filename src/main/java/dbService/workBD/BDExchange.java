package dbService.workBD;

import dao.BookDAO;
import dao.CardDAO;
import dao.UserDAO;
import dbService.DBService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by DNS on 30.03.2017.
 */
public class BDExchange {



    public long addUser(String name)  {
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDAO dao = new UserDAO(session);
        long id = dao.insert(name);
        transaction.commit();
        session.close();
        return id;

    }
    public String getUser(String name)  {
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDAO dao = new UserDAO(session);
        String nameq = dao.got(name);
        transaction.commit();
        session.close();
        return nameq;

    }

    public List getAllUser()  {
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDAO dao = new UserDAO(session);
        List nameq = dao.getAll();
        transaction.commit();
        session.close();
        return nameq;

    }

    public long addBook(String name) {
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        long id = dao.insert(name);
        transaction.commit();
        session.close();
        return id;
    }

    public long takeBookHome (String name, String book){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CardDAO dao = new CardDAO(session);
        long id = dao.insert(name, book);
        transaction.commit();
        session.close();
        return id;
    }

    public String returnBookLib (String name, String book){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CardDAO daoCard = new CardDAO(session);
        BookDAO daoBook = new BookDAO(session);
        String result;
        if(daoBook.getExistence(book) == 0){
            if (daoCard.returnBookToLib(book, name)){
                if(daoBook.setExistence(book)){
                    result = "Усё нормально Шеф, книга сдана";
                }
                else result = "не смог исправить бд боокдс";

            }
            else  result = "не смог исправить бд карддс";

        }
        else result = "Книга уже лежит в библиотеке, нафига вы притащили мне дуплекат???";
        transaction.commit();
        session.close();
        return result;
    }

    public boolean changeBook(String book){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        boolean bookDS = dao.get(book);
        transaction.commit();
        session.close();
        return bookDS;
    }


    public String gotBook (String book){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        String results = dao.got(book);
        transaction.commit();
        session.close();
        return results;
    }

    public List getAllBook (){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        List results = dao.getAll();
        transaction.commit();
        session.close();
        return results;
    }

    public List getNalBook (){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        List results = dao.getNal();
        transaction.commit();
        session.close();
        return results;
    }

    public List getNulBook (){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BookDAO dao = new BookDAO(session);
        List results = dao.getNull();
        transaction.commit();
        session.close();
        return results;
    }

    public List getCart (){
        Session session = DBService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CardDAO dao = new CardDAO(session);
        List results = dao.getAll();
        transaction.commit();
        session.close();
        return results;
    }

}




