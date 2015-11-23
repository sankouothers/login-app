package org.wangy.webtest.dao;

import org.wangy.webtest.model.Project;

import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
public interface ProjectDao {
    void delete(Integer id);
    Project findProject(String name);
    void update(Project project);
    Project get(Integer id);
    Integer save(Project project);
    List list();
    List<Project> findProjects(String query);

    List<Project> list(int start, int pageSize);

    int getCount();
}
