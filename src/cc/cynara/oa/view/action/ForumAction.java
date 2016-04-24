package cc.cynara.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.domain.Topic;
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{
	
	/**板块列表*/
	public String list() throws Exception {
		//准备数据
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	/**显示单个板块*/
	public String show() throws Exception {
		//准备数据 forum
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		//准备数据topList
		List<Topic> topicList = topicService.findByForum(forum);
		ActionContext.getContext().put("topicList", topicList);
		return "show";
	}
}
