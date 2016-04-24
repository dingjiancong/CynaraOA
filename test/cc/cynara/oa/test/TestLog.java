package cc.cynara.oa.test;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLog {
	private static Logger log = LoggerFactory.getLogger(TestLog.class);
//	private static Log log = LogFactory.getLog(TestLog.class);
	
	@Test
	public void testname() throws Exception {
		log.debug("只是debug级别");//调试
		log.info("这是info级别");//信息
		log.warn("这是warn级别");//警告
		log.error("这个error级别");//错误
//		log.fatal("只是fatal级别"); //严重错误
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
}
