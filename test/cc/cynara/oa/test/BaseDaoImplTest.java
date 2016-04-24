package cc.cynara.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.WeakReferenceMonitor.ReleaseListener;

import cc.cynara.oa.domain.User;
import cc.cynara.oa.service.RoleService;

public class BaseDaoImplTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	@Test
	public void testname() throws Exception {
		RoleService roleService = (RoleService)context.getBean("roleServiceImpl");
		roleService.delete(3l);
	}
}
