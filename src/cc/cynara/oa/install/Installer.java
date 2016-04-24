package cc.cynara.oa.install;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.domain.Privilege;
import cc.cynara.oa.domain.User;

@Component
public class Installer {
	@Resource
	private SessionFactory sessionFactory;
	@Transactional
	public void init(){
		Session session = sessionFactory.getCurrentSession();
		//超级管理员数据------
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin"));
		session.save(user);
		System.out.println("超级管理员设置成功,登录名admin,密码admin");
		//权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5;

		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/role_list", menu);
		menu2 = new Privilege("部门管理", "/department_list", menu);
		menu3 = new Privilege("用户管理", "/user_list", menu);

		session.save(menu);
		System.out.println("系统管理设置成功!");
		session.save(menu1);
		System.out.println("岗位管理设置成功!");
		session.save(menu2);
		System.out.println("部门管理设置成功!");
		session.save(menu3);
		System.out.println("用户管理设置成功!");

		session.save(new Privilege("岗位列表", "/role_list", menu1));
		System.out.println("岗位管理>岗位列表设置成功!");
		session.save(new Privilege("岗位删除", "/role_delete", menu1));
		System.out.println("岗位管理>岗位删除设置成功!");
		session.save(new Privilege("岗位添加", "/role_add", menu1));
		System.out.println("岗位管理>岗位添加设置成功!");
		session.save(new Privilege("岗位修改", "/role_edit", menu1));
		System.out.println("岗位管理>岗位修改设置成功!");

		session.save(new Privilege("部门列表", "/department_list", menu2));
		System.out.println("部门管理>部门列表设置成功!");
		session.save(new Privilege("部门删除", "/department_delete", menu2));
		System.out.println("部门管理>部门删除设置成功!");
		session.save(new Privilege("部门添加", "/department_add", menu2));
		System.out.println("部门管理>部门添加设置成功!");
		session.save(new Privilege("部门修改", "/department_edit", menu2));
		System.out.println("部门管理>部门修改设置成功!");

		session.save(new Privilege("用户列表", "/user_list", menu3));
		System.out.println("用户管理>用户列表设置成功!");
		session.save(new Privilege("用户删除", "/user_delete", menu3));
		System.out.println("用户管理>用户删除设置成功!");
		session.save(new Privilege("用户添加", "/user_add", menu3));
		System.out.println("用户管理>用户添加设置成功!");
		session.save(new Privilege("用户修改", "/user_edit", menu3));
		System.out.println("用户管理>用户修改设置成功!");
		session.save(new Privilege("用户初始化密码", "/user_initPwd", menu3));
		System.out.println("用户管理>户初始化密码设置成功!");

		// ------

		menu = new Privilege("网上交流", null, null);
		
		menu1 = new Privilege("论坛管理", "/forumManage_list", menu);
		menu2 = new Privilege("论坛", "/forum_list", menu);

		session.save(menu);
		System.out.println("网上交流设置成功!");
		session.save(menu1);
		System.out.println("网上交流>论坛管理设置成功!");
		session.save(menu2);
		System.out.println("网上交流>论坛设置成功!");

		// ------

		menu = new Privilege("审批流转", null, null);
		menu1 = new Privilege("审批流程管理", "/processDefinition_List", menu);
		menu2 = new Privilege("申请模板管理", "/template_List", menu);
		menu3 = new Privilege("起草申请", "/flow_templateList", menu);
		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);

		session.save(menu);
		System.out.println("审批流转设置成功!");
		session.save(menu1);
		System.out.println("审批流转>审批流程管理设置成功!");
		session.save(menu2);
		System.out.println("审批流转>申请模板管理设置成功!");
		session.save(menu3);
		System.out.println("审批流转>起草申请设置成功!");
		session.save(menu4);
		System.out.println("审批流转>待我审批设置成功!");
		session.save(menu5);
		System.out.println("审批流转>我的申请查询设置成功!");
		
	}
	public static void main(String[] args) {
		System.out.println("正在初始化数据...");
		//一定要从容器中获取
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Installer installer = (Installer)context.getBean("installer");
		//执行安装
//		installer.init();
		
		System.out.println("初始化数据完成...");
	}
}
