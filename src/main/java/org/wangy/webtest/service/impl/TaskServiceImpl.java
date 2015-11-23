package org.wangy.webtest.service.impl;

import org.wangy.webtest.dao.TaskDao;
import org.wangy.webtest.model.Task;
import org.wangy.webtest.service.TaskService;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void delete(Integer id) {
        taskDao.delete(id);
    }

    @Override
    public Task findTask(String name) {
        return taskDao.findTask(name);
    }

    @Override
    public Task get(Integer id) {
        return taskDao.get(id);
    }

    @Override
    public List<Task> list() {
        return taskDao.list();
    }

    @Override
    public Integer save(Task task) {
        return taskDao.save(task);
    }

    @Override
    public void update(Task task) {
        taskDao.update(task);
    }

    @Override
    public List<Task> findTasks(String query) {
        return taskDao.findTasks(query);
    }

    @Override
    public List<Task> list(int start, int pageSize) {
        return taskDao.list(start, pageSize);
    }

    @Override
    public int getCount() {
        return taskDao.getCount();
    }
}
