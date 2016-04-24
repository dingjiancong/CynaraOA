package cc.cynara.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.User;
@Controller
@Scope("prototype")
public class LoginOutAction extends BaseAction<User>{
	public String loginUI() throws Exception {
		return "loginUI";
	}
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null){
			addFieldError("login", "用户名或者密码错误!");
			return "loginUI";
		}else{
			ActionContext.getContext().getSession().put("user", user);
			return "toHome";
		}
		
	}
	public String logOut() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logOut";
	}
}
