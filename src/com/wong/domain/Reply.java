package com.wong.domain;

import java.util.Date;

/**
 * @author DayoWong
 */
public class Reply {
    private Integer rid;
    private String replyContext;
    private String ipAddr;
    private Date createDate;
    //多对一 多个回复属于一个主题
    private Topic topic;


    public Integer getRid() {
        return rid;    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getReplyContext() {
        return replyContext;
    }

    public void setReplyContext(String replyContext) {
        this.replyContext = replyContext;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
