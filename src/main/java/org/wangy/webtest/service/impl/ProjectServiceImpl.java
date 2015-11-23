package org.wangy.webtest.service.impl;

import org.wangy.webtest.dao.ProjectDao;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.service.ProjectService;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class ProjectServiceImpl implements ProjectService {
    private ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void delete(Integer id) {
        projectDao.delete(id);
    }

    @Override
    public Project findProject(String name) {
        return projectDao.findProject(name);
    }

    @Override
    public Project get(Integer id) {
        return projectDao.get(id);
    }

    @Override
    public List<Project> list() {
        return projectDao.list();
    }

    @Override
    public Integer save(Project project) {
        return projectDao.save(project);
    }

    @Override
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public List<Project> findProjects(String query) {
        return projectDao.findProjects(query);
    }

    @Override
    public List<Project> list(int start, int pageSize) {
        return projectDao.list(start, pageSize);
    }

    @Override
    public int getCount() {
        return projectDao.getCount();
    }
}
