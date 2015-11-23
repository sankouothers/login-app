package org.wangy.webtest.service.impl;

import java.util.List;

import org.hibernate.Query;

import org.wangy.webtest.dao.UserDao;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.UserService;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
public class UserServiceImpl implements UserService {
    //~ Instance fields --------------------------------------------------------------------------------------------------

    private UserDao userDao;

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param id DOCUMENT ME!
     */
    @Override
    public void delete(Integer id) {
        userDao.delete(id);
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
        return userDao.findUser(username, password);
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param id DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public List<User> list(int start, int pageSize) {
        return userDao.list(start, pageSize);
    }



    @Override
    public int getCount() {
        return userDao.getCount();
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param user DOCUMENT ME!
     * @return DOCUMENT ME!
     */
    @Override
    public Integer save(User user) {
        return userDao.save(user);
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param userDao DOCUMENT ME!
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param user DOCUMENT ME!
     */
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findUsers(String query) {
        return userDao.findUsers(query);
    }

    @Override
    public List<User> findUsers(String query, int startSize, int limitSize) {
        return userDao.findUsers(query,startSize,limitSize);
    }

    @Override
    public int getCount(String query) {
        return userDao.getCount(query);
    }
} // end class UserServiceImpl
