package com.wong.dao;

import com.wong.domain.Reply;
import com.wong.domain.Topic;
import com.wong.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author DayoWong
 */
public class TopicDaoImpl implements TopicDao {
    @Override
    public void save(Topic topic) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(topic);

    }

    @Override
    public void save(Integer tid, Reply reply) {
        Session session = HibernateUtils.getCurrentSession();
        //获得所属主题
        Topic topic = (Topic) session.get(Topic.class,tid);
        //关联
        topic.getReplySet().add(reply);
        reply.setTopic(topic);
        //保存
        session.save(reply);

    }

    @Override
    public List<Topic> getAll(String key) {
        //1 获得session
        Session session = HibernateUtils.getCurrentSession();
        //2 创建query对象
        Query query = session.createQuery("from Topic where title like :key ");
        //3 设置参数
        if(key!=null && !"".equals(key.trim())){//页面传条件了
            query.setString("key", "%"+key+"%");
        }else{//页面没传条件=>查询所有
            query.setString("key", "%");
        }
        //4 查询 list
        return query.list();

    }

    @Override
    public Topic get(Integer tid) {
        Session session = HibernateUtils.getCurrentSession();
        Topic topic = (Topic) session.get(Topic.class,tid);
        return topic;
    }


}
