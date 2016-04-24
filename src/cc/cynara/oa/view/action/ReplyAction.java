package cc.cynara.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Reply;
import cc.cynara.oa.domain.Topic;
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{
	
	private Long topicId;
	
	/**发表回复功能页面*/
	public String addUI() throws Exception {
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}
	/**发表回复*/
	public String add() throws Exception {
		Topic topic = topicService.getById(topicId);
		Reply reply = new Reply();
		reply.setTopic(topic);
		reply.setContent(model.getContent());
		reply.setAuthor(getCurrentUser());
		reply.setIpAddr(getRequestIP());
		
		replyService.save(reply);
		ActionContext.getContext().put("topicId", topic.getId());
		return "toShow";
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
