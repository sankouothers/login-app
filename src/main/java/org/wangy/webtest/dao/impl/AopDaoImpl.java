package org.wangy.webtest.dao.impl;

import org.wangy.webtest.dao.AopDao;
import org.wangy.webtest.model.Aop;

import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class AopDaoImpl extends BaseDaoImpl implements AopDao {
    @Override
    public void save(Aop aop) {
        getSession().save(aop);
    }

    @Override
    public List<Aop> list() {
        return getSession().createQuery("from Aop").list();
    }

    @Override
    public List<Aop> findProjects(String query) {
        return getSession().createQuery("from Aop where name like :q or operation like :q").setParameter("q", ("%" + query + "%")).list();
    }

    @Override
    public Aop findProject(String name) {
        return (Aop) getSession().createQuery("from Aop where name = ?").setParameter(0, name).setMaxResults(1).uniqueResult();
    }
}
