package org.rikey.web.dao;

import org.rikey.web.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Since 2016/4/18
 * @Author zhongrui8
 * @Changelist 1. 2016/4/18 create.
 * @Notice 如有改动，请在changelist中注明
 */
@Repository("userDao")
public interface UserDao {

    public Integer addUser(User user);

    public User queryUser(String userName);
}
