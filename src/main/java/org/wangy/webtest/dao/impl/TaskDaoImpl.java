package org.wangy.webtest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wangy.webtest.dao.TaskDao;
import org.wangy.webtest.dao.TaskDao;
import org.wangy.webtest.model.Task;
import org.wangy.webtest.model.Task;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class TaskDaoImpl extends BaseDaoImpl implements TaskDao {

    @Override
    public void delete(Integer id) {
        getSession().delete(get(id));
    }

    @Override
    public Task findTask(String name) {
        return (Task) getSession().createQuery("from Task where taskName = ?").setParameter(0, name).setMaxResults(1).uniqueResult();
    }

    @Override
    public void update(Task task) {
        getSession().saveOrUpdate(task);
    }

    @Override
    public Task get(Integer id) {
        return (Task)getSession().get(Task.class,id);
    }

    @Override
    public Integer save(Task task) {
        return (Integer)getSession().save(task);
    }

    @Override
    public List<Task> list() {
        return getSession().createQuery("from Task").list();
    }

    @Override
    public List<Task> findTasks(String query) {
        return getSession().createQuery("from Task where taskName like :q or taskDescription like :q").setParameter("q", ("%"+query+"%")).list();
    }

    @Override
    public List<Task> list(int start, int pageSize) {
        return getSession().createQuery("from Task").setFirstResult(start).setMaxResults(pageSize).list();
    }

    @Override
    public int getCount() {
        Number number = (Number) getSession().createQuery("select count(id) from Task").uniqueResult();
        return number.intValue();
    }
}
