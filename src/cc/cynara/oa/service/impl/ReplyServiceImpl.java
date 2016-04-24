package cc.cynara.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.domain.Reply;
import cc.cynara.oa.domain.Topic;
import cc.cynara.oa.service.ReplyService;
@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService{

	@SuppressWarnings("unchecked")  
	public List<Reply> findByTopic(Topic topic) {
		return getSession().createQuery(//
				"FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)
				.list();
	}

	@Override
	public void save(Reply reply) {
		reply.setDeleted(false);
		reply.setPostTime(new Date());
		getSession().save(reply);
		//更新topic中的回复数和最后一个回复
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		getSession().update(forum);
		getSession().update(topic);
	}
}
