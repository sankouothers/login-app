package org.wangy.webtest.dao;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Query;
import org.wangy.webtest.model.User;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface UserDao {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  void delete(Integer id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   username  DOCUMENT ME!
   * @param   password  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  User findUser(String username, String password);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  User get(Integer id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<User> list();

  //~ ------------------------------------------------------------------------------------------------------------------

  List<User> list(int start, int pageSize);

  /**
   * DOCUMENT ME!
   *
   * @param   user  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Integer save(User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  int getCount();

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  void update(User user);

  List<User> findUsers(String query);

  List<User> findUsers(String query, int startSize, int limitSize);

  int getCount(String query);
} // end interface UserDao
