package org.wangy.webtest.service.impl;

import org.wangy.webtest.dao.UserAuditDao;
import org.wangy.webtest.model.Audit.UserAudit;
import org.wangy.webtest.service.UserAuditService;

/**
 * Created by Administrator on 2015/9/24.
 */
public class UserAuditServiceImpl implements UserAuditService {

    UserAuditDao userAuditDao;

    public void setUserAuditDao(UserAuditDao userAuditDao) {
        this.userAuditDao = userAuditDao;
    }

    @Override
    public void saveUserAudit(UserAudit userAudit) {
        userAuditDao.saveUserAudit(userAudit);
    }

    @Override
    public UserAudit getUserAudit(String userName) {
        return userAuditDao.getUserAudit(userName);
    }
}
