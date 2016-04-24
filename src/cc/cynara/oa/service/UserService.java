package cc.cynara.oa.service;

import cc.cynara.oa.base.DaoSupport;
import cc.cynara.oa.domain.User;

public interface UserService extends DaoSupport<User>{
	/**
	 * 根据用户名密码查询用户
	 * @param loginName
	 * @param password
	 * @return  如果正确就返回这个用户  如果不正确就返回null
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}
