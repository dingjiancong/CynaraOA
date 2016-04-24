package cc.cynara.oa.view.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.domain.Reply;
import cc.cynara.oa.domain.Topic;
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{
	
	private Long forumId;
	/***显示单个主体*/
	public String show() throws Exception {
		//准备数据
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
		//准备回复数据
		List<Reply> replyList = replyService.findByTopic(topic);
		ActionContext.getContext().put("replyList", replyList);
		return "show";
	}
	/**发新帖页面*/
	public String addUI() throws Exception {
		//准备数据
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	/**发新帖*/
	public String add() throws Exception {
		//封装对象 保存
		Topic topic = new Topic();
		//表单中传过来的数据
		topic.setContent(model.getContent());
		topic.setTitle(model.getTitle());
		topic.setForum(forumService.getById(forumId));
		//在显示层才能获取的数据
		topic.setAuthor(getCurrentUser());
		topic.setIpAddr(getRequestIP());
		topicService.save(topic);
		ActionContext.getContext().put("topicId", topic.getId());
		return "toShow";
	}
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
}
