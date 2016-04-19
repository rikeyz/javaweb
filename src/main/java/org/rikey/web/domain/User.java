package org.rikey.web.domain;

/**
 * @Description:
 * @Since 2016/4/18
 * @Author zhongrui8
 * @Changelist 1. 2016/4/18 create.
 * @Notice 如有改动，请在changelist中注明
 */
public class User {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    private String userName;

    private String password;

    private String salt;

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {

        return salt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }
}
