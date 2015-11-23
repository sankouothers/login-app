package org.wangy.webtest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.wangy.webtest.dao.UserDao;
import org.wangy.webtest.model.User;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * @see org.wangy.webtest.dao.UserDao#delete(Integer)
     */
    @Override
    public void delete(Integer id) {
        getSession().delete(get(id));
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param username DOCUMENT ME!
     * @param password DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Override
    public User findUser(String username, String password) {
        return (User) getSession().createQuery("from User where username=? and password=?").setParameter(0, username)
                .setParameter(1, password).setMaxResults(1).uniqueResult();
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * @see org.wangy.webtest.dao.UserDao#get(Integer)
     */
    @Override
    public User get(Integer id) {
        return (User) getSession().get(User.class, id);
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public List<User> list() {
        return getSession().createQuery("from User").list();
    }

    @Override
    public List<User> list(int start, int pageSize) {
        return getSession().createQuery("from User").setFirstResult(start).setMaxResults(pageSize).list();
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * @see org.wangy.webtest.dao.UserDao#save(org.wangy.webtest.model.User)
     */
    @Override
    public Integer save(User user) {
        return (Integer) getSession().save(user);
    }

    @Override
    public int getCount() {
        Number number = (Number) getSession().createQuery("select count(id) from User").uniqueResult();
        return number.intValue();
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * @see org.wangy.webtest.dao.UserDao#update(org.wangy.webtest.model.User)
     */
    @Override
    public void update(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public List<User> findUsers(String query) {
        return getSession().createQuery("from User where (username like :q or  email like :q or phoneNumber like :q)").setParameter("q", "%" + query + "%").list();
    }

    @Override
    public List<User> findUsers(String query, int startSize, int limitSize) {
        return getSession().createQuery("from User where (username like :q )").setParameter("q","%" +query + "%").setFirstResult(startSize).setMaxResults(limitSize).list();
    }

    @Override
    public int getCount(String query) {
        Number number = (Number) getSession().createQuery("select count(username) from User where username like:query").setParameter("query","%" + query + "%").uniqueResult();
        return number.intValue();
    }
} // end class UserDaoImpl
