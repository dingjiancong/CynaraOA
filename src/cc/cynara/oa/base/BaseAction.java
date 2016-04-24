package cc.cynara.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cc.cynara.oa.domain.User;
import cc.cynara.oa.service.DepartmentService;
import cc.cynara.oa.service.ForumService;
import cc.cynara.oa.service.ReplyService;
import cc.cynara.oa.service.RoleService;
import cc.cynara.oa.service.TopicService;
import cc.cynara.oa.service.UserService;
import cc.cynara.oa.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	//声明service
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	//对ModelDruven支持
	protected T model;
	
	public BaseAction(){
		try {
			//通过反射获取t的真实类型
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz= (Class<T>) type.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public T getModel() {
		return model;
	}
	/***工具方法***/
	//获取当前登录的用户
	public User getCurrentUser(){
		return (User)ActionContext.getContext().getSession().get("user");
	}
	//获取当前用户的ip
	public String getRequestIP(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
}
