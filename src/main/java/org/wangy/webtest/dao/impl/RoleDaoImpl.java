package org.wangy.webtest.dao.impl;

import org.wangy.webtest.dao.RoleDao;
import org.wangy.webtest.model.Role;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
    @Override
    public void delete(Integer id) {
        getSession().delete(get(id));
    }


    @Override
    public Role findRole(String name) {
        return (Role) getSession().createQuery("from Role where name = ?").setParameter(0, name).setMaxResults(1).uniqueResult();
    }

    @Override
    public Role get(Integer id) {
        return (Role) getSession().get(Role.class, id);
    }

    @Override
    public List<Role> list() {
        return getSession().createQuery("from Role").list();
    }

    @Override
    public Integer save(Role role) {
        return (Integer) getSession().save(role);
    }

    @Override
    public void update(Role role) {
        getSession().saveOrUpdate(role);
    }

    @Override
    public List<Role> findRoles(String query) {
        return getSession().createQuery("from Role where name like :q or description like :q").setParameter("q", ("%"+query+"%")).list();
    }

    @Override
    public List<Role> list(int start, int pageSize) {
        return getSession().createQuery("from Role").setFirstResult(start).setMaxResults(pageSize).list();
    }

    @Override
    public int getCount() {
        Number number = (Number) getSession().createQuery("select count(id) from Role").uniqueResult();
        return number.intValue();
    }
}
