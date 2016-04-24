package cc.cynara.oa.view.action;

import java.util.HashSet;
import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Privilege;
import cc.cynara.oa.domain.Role;
import cc.cynara.oa.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>  {
	private Long[] privilegeIds;
	
	//列表
	public String list() throws Exception {
		//准备数据
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	//删除
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}
	//添加
	public String add() throws Exception {
		roleService.save(model);
		return "toList";
	}
	//修改
	public String edit() throws Exception {
		//从数据库中获取要修改的原始对象
		Role role = roleService.getById(model.getId());
		//设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		//更新到数据库
		roleService.update(role);
		return "toList";
	}
	
	//添加页面
	public String addUI() throws Exception {
		return "saveUI";
	}
	//修改页面
	public String editUI() throws Exception {
		//准备要回西显 的数据
		Role role = roleService.getById(model.getId());
//		model.setName(role.getName());
//		model.setDescription(role.getDescription());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	//添加权限页面
	public String setPrivilegeUI() throws Exception {
		//准备要回西显 的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for(Privilege privilege : role.getPrivileges()){
			privilegeIds[index++] = privilege.getId();
		}
		//准备所有的权限列表
		List<Privilege> topPrivilegeList = privilegeService.findTopAll();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		return "setPrivilegeUI";
	}
	//添加权限
	public String setPrivilege() throws Exception {
		Role role = roleService.getById(model.getId());
		//设置要修改的属性
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		roleService.update(role);
		return "toList";
	}
	
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
