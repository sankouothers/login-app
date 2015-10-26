package org.wangy.webtest.dao;

import org.wangy.webtest.model.Aop;
import org.wangy.webtest.model.Project;

import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public interface AopDao {
    void save(Aop aop);
    List<Aop> list();
    List<Aop> findProjects(String query);
    Aop findProject(String name);
}
