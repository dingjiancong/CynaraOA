package cc.cynara.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Department;
import cc.cynara.oa.domain.Role;
import cc.cynara.oa.domain.User;
import cc.cynara.oa.utils.DepartmentUtils;
import cc.cynara.oa.utils.MD5EncodingUtils;

@Scope("prototype")
@Controller
public class UserAction extends BaseAction<User>{
	
	private Long departmentId;
	private Long[] ids;
	//列表
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	//删除
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	//添加  成功转回列表
	public String add() throws Exception {
		//封装对象
		//处理关联关系的一个部门
		model.setDepartment(departmentService.getById(departmentId));
		//关联关系的多个岗位
		List<Role> roles = roleService.getByIds(ids);
		model.setRoles(new HashSet<Role>(roles));
		//保存到数据库
		userService.save(model);
		initPwd();
		return "toList";
	}
	//修改 成功转回列表
	public String edit() throws Exception {
		//从数据库中取出原对象
		User user = userService.getById(model.getId());
		//设置要修改的属性
		user.setDescription(model.getDescription());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPhone(model.getPhone());
		//处理关联关系的一个部门
		user.setDepartment(departmentService.getById(departmentId));
		//关联关系的多个岗位
		List<Role> roles = roleService.getByIds(ids);
		user.setRoles(new HashSet<Role>(roles));
		//更新到数据库
		userService.update(user);
		return "toList";
	}
	// 添加用户界面
	public String addUI() throws Exception {
		//准备数据岗位
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		// 准备数据部门
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}
	//修改用户界面
	public String editUI() throws Exception {
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if(user.getDepartment()!=null){
			departmentId = user.getDepartment().getId();
		}
		ids = new Long[user.getRoles().size()];
		int index = 0;
		for(Role role :user.getRoles()){
			ids[index++] = role.getId();
		}
		//准备数据岗位
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		// 准备数据部门
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}
	//初始化密码
	public String initPwd() throws Exception {
		User user = userService.getById(model.getId());
		user.setPassword(DigestUtils.md5Hex("1234"));
		userService.update(user);
		return "toList";
	}
	
	//-----
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
}
