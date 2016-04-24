package cc.cynara.oa.utils;

import cc.cynara.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		//拦截所有的所有请求
		//准备数据 当前登录的用户
		User user = (User)ActionContext.getContext().getSession().get("user");
		//当前访问的URL
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		if(null==namespace|| "".equals(namespace)){
			namespace = "/";
		}
		if(!namespace.endsWith("/")){
			namespace+="/";
		}
		String url = namespace + actionName;
		//如果用户未登录
		if(user == null){
			//a 如果用户在去登录的路上  则放行 //loginOut_loginUI/loginOut_login
			if(url.startsWith("/loginOut_login")||url.startsWith("/loginOut_logOut")){
				return invocation.invoke();
			}else{
				//b 如果用户访问的其他页面  则转到登录页面
				return "loginUI";
			}
		}else{
			if(user.hasPrivilegeByUrl(url)){
				//用户已经登录 判断权限  如果有权限访问当前的url就放行
				return invocation.invoke();
			}else{
				//如没有权限 就转到提示消息的页面
				return "message";
			}
		}
	}
}
