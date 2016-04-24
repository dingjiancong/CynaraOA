package cc.cynara.oa.service;

import java.util.List;

import cc.cynara.oa.base.DaoSupport;
import cc.cynara.oa.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege>{
	//返回顶级
	List<Privilege> findTopAll();
	/**
	 * 返回所有的权限url地址
	 * @return  不包含重复和空值
	 */
	List<String> allPrivilegeUrls();

}
