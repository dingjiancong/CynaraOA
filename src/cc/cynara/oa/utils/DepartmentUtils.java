package cc.cynara.oa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sun.misc.Perf;

import cc.cynara.oa.domain.Department;

public class DepartmentUtils {
	/**
	 * 遍历部门数  改掉名称放到同一个list中 通过名称空格表示层次
	 * @param topList
	 * removeDepartment  这个部门和这个部门的子孙部门都不要  如果为null则表示没有要移除的
	 * @return
	 */
	public static List<Department> getAllDepartmentList(List<Department> topList,Department removeDepartment) {
		List<Department> list = new ArrayList<Department>();
		walkTree(topList,"┣",list,removeDepartment);
		
		return list;
	}
	
	private static void walkTree(Collection<Department> topList,String prefix,List<Department> list,Department removeDepartment){
		for (Department top : topList) {
			if(removeDepartment!=null&& top.getId().equals(removeDepartment.getId())){
				continue;
			}
			//顶点   不要修改session缓存中的数据  使用副本
			Department copy = new Department();
			copy.setName((prefix+top.getName()));
			copy.setId(top.getId());
			list.add(copy);//添加的copy对象
			walkTree(top.getChilds(),"　"+prefix,list,removeDepartment);//要使用全角空格
			
		}
	}
}
