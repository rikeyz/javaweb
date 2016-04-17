package org.rikey.web.biz.shiro.result;

import java.util.List;

/**
 * @Description:
 * @Since 2016/4/16
 * @Author zhongrui8
 * @Changelist 1. 2016/4/16 create.
 * @Notice 如有改动，请在changelist中注明
 */
public class UserLoginResult {
    private Long id;

    private String name;

    private String password;

    private String salt;

    private Integer wrongCount;

    private List<String> permissions;

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getPermissions() {

        return permissions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setWrongCount(Integer wrongCount) {
        this.wrongCount = wrongCount;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public Integer getWrongCount() {
        return wrongCount;
    }
}
