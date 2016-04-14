package org.rikey.web.domain;

import java.util.Date;

/**
 * @Description:
 * @Since 2016/4/14
 * @Author zhongrui8
 * @Changelist 1. 2016/4/14 create.
 * @Notice 如有改动，请在changelist中注明
 */
public class Message {
    private String from;

    private String sendTime;

    private String message;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {

        return from;
    }

    public String getSendTime() {
        return sendTime;
    }

    public String getMessage() {
        return message;
    }
}
