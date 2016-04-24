package cc.cynara.oa.service;

import java.util.List;

import cc.cynara.oa.base.DaoSupport;
import cc.cynara.oa.domain.Department;

public interface DepartmentService extends DaoSupport<Department>{
//	//查询所有的部门
//	List<Department> findAll();
//	//删除一个部门
//	void delete(Long id);
//	//根据id查询一个部门
//	Department findById(Long id);
//	//修改部门参数
//	void update(Department department);
//	//添加一个部门
//	void add(Department department);
//	//根据ids查询
//	List<Department> findByIds(Long[] ids);
	
	//查询所有顶级部门列表
	List<Department> findTopList();
	//查询顶级列部门表下的子列表
	List<Department> findChilden(Long parentId);

}
