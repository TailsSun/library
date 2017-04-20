package dao;

import dbService.dataSet.CardDS;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by DNS on 30.03.2017.
 */
public class CardDAO {
    private Session session;

    public CardDAO(Session session){this.session = session;}

    public CardDAO get (String name) throws HibernateException {
        return (CardDAO) session.get(CardDS.class, name);
    }

    public List getAll () throws HibernateException {
        return (List) session.createCriteria(CardDS.class).list();
    }

    public long insert (String name, String book) throws HibernateException {
        return (Long) session.save(new CardDS(name, book));
    }

    public int getExcengCard (String name, String book) throws HibernateException {
        return (int) session.save(new CardDS(name, book));
    }

    public boolean returnBookToLib (String book, String name) throws HibernateException {
        Criteria criteria = session.createCriteria(CardDS.class);
        criteria.add(Restrictions.eq("book", book));
        criteria.add(Restrictions.eq("name", name));
        ((CardDS) criteria.add(Restrictions.eq("exchange", 1)).uniqueResult()).setExchange(0);
        return true ;
    }
}

