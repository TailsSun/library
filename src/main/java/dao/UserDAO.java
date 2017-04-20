package dao;

import dbService.dataSet.UserDS;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by DNS on 29.03.2017.
 */
public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public List getAll () throws HibernateException{
        return (List) session.createCriteria(UserDS.class).list();
    }

    public String got (String name) throws HibernateException{
        Criteria criteria = session.createCriteria(UserDS.class);
        return ((UserDS) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getName();
    }

    public long insert (String name) throws HibernateException{
        return (Long) session.save(new UserDS(name));
    }
}
