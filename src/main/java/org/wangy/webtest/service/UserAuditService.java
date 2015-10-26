package org.wangy.webtest.service;

import org.wangy.webtest.model.Audit.UserAudit;

/**
 * Created by Administrator on 2015/9/24.
 */
public interface UserAuditService {
    void saveUserAudit (UserAudit userAudit);
    UserAudit getUserAudit(String userName);
}
