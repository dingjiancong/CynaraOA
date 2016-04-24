package cc.cynara.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Privilege;
import cc.cynara.oa.service.PrivilegeService;
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService{

	@SuppressWarnings("unchecked")
	public List<Privilege> findTopAll() {
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL").list();
	}

	@SuppressWarnings("unchecked")
	public List<String> allPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
	}

}
