package org.wangy.webtest.dao.impl;

import org.wangy.webtest.dao.UserAuditDao;
import org.wangy.webtest.model.Audit.UserAudit;

/**
 * Created by Administrator on 2015/9/24.
 */
public class UserAuditDaoImpl extends BaseDaoImpl implements UserAuditDao {
    @Override
    public void saveUserAudit(UserAudit userAudit) {
        getSession().save(userAudit);
    }

    @Override
    public UserAudit getUserAudit(String userName) {
        return null;
    }
}
