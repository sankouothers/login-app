package org.wangy.webtest.service;

import java.util.List;

import org.hibernate.Query;
import org.wangy.webtest.model.User;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface UserService {
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
   * @param   userName  DOCUMENT ME!
   * @param   password  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  User findUser(String userName, String password);

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

  int getCount();


  /**
   * DOCUMENT ME!
   *
   * @param   user  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Integer save(User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  void update(User user);

  List<User> findUsers(String query);

  List<User> findUsers(String query, int startSize, int limitSize);

  int getCount(String query);
} // end interface UserService
