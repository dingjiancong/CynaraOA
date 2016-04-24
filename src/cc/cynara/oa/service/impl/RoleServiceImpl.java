package cc.cynara.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Role;
import cc.cynara.oa.service.RoleService;
@Service
//@Transactional  //对父类中的方法无效
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService{
//	@Resource
//	private RoleDao roleDao;
//	
//	public void delete(Long id) {
//		roleDao.delete(id);
//	}
//
//	public List<Role> findAll() {
//		return roleDao.findAll();
//	}
//	public void add(Role role) {
//		roleDao.save(role);
//	}
//
//	public Role getById(Long id) {
//		return roleDao.getById(id);
//	}
//
//	public void update(Role model) {
//		roleDao.update(model);
//	}

}
