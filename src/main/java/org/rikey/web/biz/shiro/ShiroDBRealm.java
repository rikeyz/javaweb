package org.rikey.web.biz.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.rikey.web.biz.shiro.result.UserLoginResult;
import org.rikey.web.dao.UserDao;
import org.rikey.web.domain.User;

import javax.annotation.Resource;

/**
 * @Description:
 * @Since 2016/4/16
 * @Author zhongrui8
 * @Changelist 1. 2016/4/16 create.
 * @Notice 如有改动，请在changelist中注明
 */
public class ShiroDBRealm extends AuthorizingRealm {

    @Resource(name = "userDao")
    private UserDao userDao;

    private static final String REALM_NAME = "shiroDbRealm";

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)super.getAvailablePrincipal(principals);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject currentUser = SecurityUtils.getSubject();

        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (session != null) {
                UserLoginResult user = (UserLoginResult)session.getAttribute("currentUser");
                authorizationInfo.addStringPermissions(user.getPermissions());
                return authorizationInfo;
            }
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String userName = usernamePasswordToken.getUsername();
        User user = userDao.queryUser(userName);

        if (user == null || user.getPassword() == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), REALM_NAME);

        return authenticationInfo;
    }
}
