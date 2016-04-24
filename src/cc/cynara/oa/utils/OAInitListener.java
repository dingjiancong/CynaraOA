package cc.cynara.oa.utils;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.domain.Privilege;
import cc.cynara.oa.service.PrivilegeService;
/**
 * 启动应用时加载
 * @author liutao-REMIX 
 *
 */
public class OAInitListener implements ServletContextListener {
	private Log log = LogFactory.getLog(OAInitListener.class);
	public void contextInitialized(ServletContextEvent sce) {
		//查詢所有頂級的權利列表
		ServletContext application = sce.getServletContext();
		//获取spring容器的监听器 要记住的
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService)context.getBean("privilegeServiceImpl");
		List<Privilege> topPrivilegeList = privilegeService.findTopAll();
		application.setAttribute("topPrivilegeList", topPrivilegeList);//放入application作用域中
		log.info("------顶级列表初始化完毕------");
		//查询出所有的权限url集合放入的到 application最用域中
		List<String> allPrivilegeUrls = privilegeService.allPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);//放入application作用域中
		log.info("------allPrivilegeUrls初始化完毕------");
	}
	public void contextDestroyed(ServletContextEvent sce) {

	}

	

}
