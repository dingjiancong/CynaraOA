package cc.cynara.oa.service;

import java.util.List;

import cc.cynara.oa.base.DaoSupport;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic>{
	/**
	 * 查询指定板块中的主题列表
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

}
