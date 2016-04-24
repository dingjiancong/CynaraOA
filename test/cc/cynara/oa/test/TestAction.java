package cc.cynara.oa.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class TestAction extends ActionSupport{
	@Resource
	private TestService testService;
	public String test() throws Exception {
		testService.saveUser();
		return SUCCESS;
	}
}
