package org.wangy.webtest.dao.impl;

import org.wangy.webtest.dao.ProjectDao;
import org.wangy.webtest.dao.RoleDao;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.Role;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class ProjectDaoImpl extends BaseDaoImpl implements ProjectDao {

    @Override
    public void delete(Integer id) {
        getSession().delete(get(id));
    }

    @Override
    public Project findProject(String name) {
        return (Project) getSession().createQuery("from Project where projectName = ?").setParameter(0, name).setMaxResults(1).uniqueResult();
    }

    @Override
    public void update(Project project) {
        getSession().saveOrUpdate(project);
    }

    @Override
    public Project get(Integer id) {
        return (Project) getSession().get(Project.class, id);
    }

    @Override
    public Integer save(Project project) {
        return (Integer) getSession().save(project);
    }

    @Override
    public List<Project> list() {
        return getSession().createQuery("from Project").list();
    }

    @Override
    public List<Project> findProjects(String query) {
        return getSession().createQuery("from Project where projectName like :q or creator like :q").setParameter("q", ("%"+query+"%")).list();
    }

    @Override
    public List<Project> list(int start, int pageSize) {
        return getSession().createQuery("from Project").setFirstResult(start).setMaxResults(pageSize).list();
    }

    @Override
    public int getCount() {
        Number number = (Number) getSession().createQuery("select count(id) from Project").uniqueResult();
        return number.intValue();
    }
}
