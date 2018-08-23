package com.wong.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wong.dao.TopicDao;
import com.wong.dao.TopicDaoImpl;
import com.wong.domain.Reply;
import com.wong.domain.Topic;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * @author DayoWong
 */
public class TopicAction extends ActionSupport {

    private Topic topic;
    private Reply reply;
    private TopicDao topicDao = new TopicDaoImpl();
    private String key; //搜索键词

    /*****回帖*****/
    public String reply(){
        //ip 回帖时间
        reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        reply.setCreateDate(new Date());
        //保存
        topicDao.save(topic.getTid(),reply);

        return "toReplyList";

    }
    /*****帖子详细及回帖列表*****/
    public String replyList(){
        //1调用dao获得帖子
        topic = topicDao.get(topic.getTid());
        //2 将帖子及其回帖放入ActionContext中
        ActionContext.getContext().put("topic",topic);
        ActionContext.getContext().put("replyList",topic.getReplySet());
        return "replyList";
    }
    /*****发帖*****/
    public String add(){
        //ip
        topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        //发帖时间
        topic.setCreateDate(new Date());
        topic.setLastReplyDate(topic.getCreateDate());
        //保存
        topicDao.save(topic);
        return "toList";
    }

    /*****帖子列表*****/
    public String list(){
        //1调用dao获得帖子列表
        List<Topic> list = topicDao.getAll(key);
        //2 将帖子列表放入ActionContext中
        ActionContext.getContext().put("list", list);

        return "list";
    }


    /*************/

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
    public Reply getReply() {
        return reply;
    }
}
