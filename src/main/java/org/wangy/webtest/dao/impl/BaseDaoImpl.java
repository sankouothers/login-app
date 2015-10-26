package org.wangy.webtest.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.wangy.webtest.dao.UserDao;
import org.wangy.webtest.model.User;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BaseDaoImpl {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private SessionFactory sessionFactory;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sessionFactory  DOCUMENT ME!
   */
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
} // end class UserDaoImpl
