package org.rikey.web.utils;

import org.apache.shiro.SecurityUtils;
import org.rikey.web.domain.User;

/**
 * @Description:
 * @Since 2016/4/19
 * @Author zhongrui8
 * @Changelist 1. 2016/4/19 create.
 * @Notice 如有改动，请在changelist中注明
 */
public class LoginStatus {
    public boolean isLogin() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public User getUser() {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
