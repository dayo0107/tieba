package com.wong.dao;

import com.wong.domain.Reply;
import com.wong.domain.Topic;

import java.util.List;

/**
 * @author DayoWong
 */
public interface TopicDao {
    //保存帖子
    void save(Topic topic);

    List<Topic> getAll(String key);

    Topic get(Integer tid);

    void save(Integer tid, Reply reply);
}
