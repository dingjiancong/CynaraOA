package cc.cynara.oa.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.domain.Topic;
import cc.cynara.oa.service.TopicService;
@Service
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

	@SuppressWarnings("unchecked")
	public List<Topic> findByForum(Forum forum) {
		return getSession().createQuery(//
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)
				.list();
	}

	@Override
	public void save(Topic topic) {
		topic.setLastReply(null);
		topic.setReplyCount(0);
		topic.setPostTime(new Date());
		topic.setLastUpdateTime(topic.getPostTime());
		topic.setType(Topic.TYPE_NORMAL);
		getSession().save(topic);
		//更新相关的信息
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setArticleCount(forum.getArticleCount()+1);
		forum.setLastTopic(topic);
		getSession().update(forum);
	}
	
	

	
}
