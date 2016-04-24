package cc.cynara.oa.service;

import java.util.List;

import cc.cynara.oa.base.DaoSupport;
import cc.cynara.oa.domain.Reply;
import cc.cynara.oa.domain.Topic;

public interface ReplyService extends DaoSupport<Reply>{
	/**
	 * 根据主题查询回复  最新的回复排在最后面
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);
	

}
