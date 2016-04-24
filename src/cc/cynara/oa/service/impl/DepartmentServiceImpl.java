package cc.cynara.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Department;
import cc.cynara.oa.service.DepartmentService;
@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService{

	
	public List<Department> findChilden(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

}
