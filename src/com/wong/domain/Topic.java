package com.wong.domain;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Set;

/**
 * @author DayoWong
 */
public class Topic {
    private  Integer tid;
    private  String title;
    private  String topicContext;
    private  String ipAddr;
    private Date  lastReplyDate;
    private Date  createDate;
    //一帖子对多个回复
    private List<Reply> replySet = new ArrayList<Reply>();



    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicContext() {
        return topicContext;
    }

    public void setTopicContext(String topicContext) {
        this.topicContext = topicContext;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getLastReplyDate() {
        return lastReplyDate;
    }

    public void setLastReplyDate(Date lastReplyDate) {
        this.lastReplyDate = lastReplyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(List<Reply> replySet) {
        this.replySet = replySet;
    }
}
