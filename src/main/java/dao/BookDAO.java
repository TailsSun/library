package dao;

import dbService.dataSet.BookDS;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


/**
 * Created by DNS on 29.03.2017.
 */
public class BookDAO {
    private Session session;

    public BookDAO(Session session){this.session = session;}

    public boolean get (String book) throws HibernateException{
        Criteria criteria = session.createCriteria(BookDS.class);
        ((BookDS) criteria.add(Restrictions.eq("book", book)).uniqueResult()).setExistence(0);
        return true;
    }

    public int getExistence (String book) throws HibernateException{
        Criteria criteria = session.createCriteria(BookDS.class);
        return ((BookDS) criteria.add(Restrictions.eq("book", book)).uniqueResult()).getExistence();
    }

    public boolean setExistence (String book) throws HibernateException{
        Criteria criteria = session.createCriteria(BookDS.class);
        ((BookDS) criteria.add(Restrictions.eq("book", book)).uniqueResult()).setExistence(1);
        return true;
    }

    public String got (String book) throws HibernateException{
        Criteria criteria = session.createCriteria(BookDS.class);
        return ((BookDS) criteria.add(Restrictions.eq("book", book)).uniqueResult()).getBook();
    }
    public long insert (String name) throws HibernateException {
        return (Long) session.save(new BookDS(name));
    }

    public List getAll () throws HibernateException{
        return (List) session.createCriteria(BookDS.class).list();
    }
    public List getNal () throws HibernateException{
        return (List)  session.createCriteria(BookDS.class).add(Restrictions.eq("existence", 1))
                .list();
    }

    public List getNull () throws HibernateException{
        return (List)  session.createCriteria(BookDS.class).add(Restrictions.eq("existence", 0))
                .list();
    }

}
