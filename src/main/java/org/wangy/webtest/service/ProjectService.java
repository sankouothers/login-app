package org.wangy.webtest.service;

import org.wangy.webtest.model.Project;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface ProjectService {
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
   * @param   projectName  DOCUMENT ME!
   * @param   password  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Project findProject(String name);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Project get(Integer id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<Project> list();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   project  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Integer save(Project project);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  project  DOCUMENT ME!
   */
  void update(Project project);

  List<Project> findProjects(String query);

  List<Project> list(int startSize, int limitSize);

  int getCount();
} // end interface ProjectService
