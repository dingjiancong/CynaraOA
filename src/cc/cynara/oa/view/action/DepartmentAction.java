package cc.cynara.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.cynara.oa.base.BaseAction;
import cc.cynara.oa.domain.Department;
import cc.cynara.oa.utils.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	private Long parentId;

	public String list() throws Exception {
		// departmentService.findAll();
		List<Department> departments = null;
		if (parentId == null) {
			departments = departmentService.findTopList();
		} else {
			departments = departmentService.findChilden(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}

		ActionContext.getContext().put("departments", departments);
		return "list";
	}

	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	public String addUI() throws Exception {
		// 原始準備數據
		// List<Department> departmentList = departmentService.findAll();
		// ActionContext.getContext().put("departmentList", departmentList);
		// 准备树状数据
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(
				topList, null);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	public String editUI() throws Exception {
		// List<Department> departmentList = departmentService.findAll();

		Department department = departmentService.getById(model.getId());
		// 页面显示部门树桩
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(
				topList, department);

		ActionContext.getContext().put("departmentList", departmentList);
		ActionContext.getContext().put("departmentList", departmentList);
		if (department.getParent() != null) {
			this.parentId = department.getParent().getId();
		}
		ActionContext.getContext().getValueStack().push(department);
		return "saveUI";
	}

	public String edit() throws Exception {
		// 从数据库中取出要修改的原始数据
		Department department = departmentService.getById(model.getId());
		// 设置修改过的值
		department.setDescription(model.getDescription());
		department.setName(model.getName());
		department.setParent(departmentService.getById(parentId));
		departmentService.update(department);
		return "toList";
	}

	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
