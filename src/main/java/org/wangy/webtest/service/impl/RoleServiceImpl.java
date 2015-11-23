package org.wangy.webtest.service.impl;

import org.wangy.webtest.dao.RoleDao;
import org.wangy.webtest.model.Role;
import org.wangy.webtest.service.RoleService;

import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public Role findRole(String name) {
        return roleDao.findRole(name);
    }

    @Override
    public Role get(Integer id) {
        return roleDao.get(id);
    }

    @Override
    public List<Role> list() {
        return roleDao.list();
    }

    @Override
    public Integer save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public List<Role> findRoles(String query) {
        return roleDao.findRoles(query);
    }

    @Override
    public List<Role> list(int start, int pageSize) {
        return roleDao.list(start, pageSize);
    }

    @Override
    public int getCount() {
        return roleDao.getCount();
    }
}
