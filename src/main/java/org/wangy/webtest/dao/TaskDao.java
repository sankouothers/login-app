package org.wangy.webtest.dao;

import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.Task;

import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
public interface TaskDao {
    void delete(Integer id);
    Task findTask(String name);
    void update(Task task);
    Task get(Integer id);
    Integer save(Task task);
    List<Task> list();
    List<Task> findTasks(String query);

    List<Task> list(int start, int pageSize);

    int getCount();
}
