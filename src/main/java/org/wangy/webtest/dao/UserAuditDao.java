package org.wangy.webtest.dao;

import org.wangy.webtest.model.Audit.UserAudit;

/**
 * Created by Administrator on 2015/9/24.
 */
public interface UserAuditDao {
    void saveUserAudit(UserAudit userAudit);
    UserAudit getUserAudit(String userName);
}
