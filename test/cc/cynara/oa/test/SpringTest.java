package cc.cynara.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.oa.domain.User;
import cc.cynara.oa.service.impl.UserServiceImpl;

public class SpringTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	@Test  //测sessionFactory
	public void springTestSessionFactory(){
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	@Test 
	public void transactionTest(){
		TestService service = (TestService)context.getBean("testService");
		service.saveUser();
	}
	@Test
	public void testname() {
		UserServiceImpl service =  (UserServiceImpl)context.getBean("userServiceImpl");
		User entity = new User();
		entity.setId(50l);
		service.save(entity);
//		Role role = dao2.getById(1L);
	}
	@Test
	public void str(){
		String url = "user_editUI?id=10";
		if(url.indexOf('?')>=0){
			url = url.substring(0,url.indexOf('?'));
		}
		if(url.concat("UI") != null){
			url = url.substring(0,url.indexOf('U'));
		}
		System.out.println(url);
	}
}	
