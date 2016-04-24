package cc.cynara.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.domain.User;

@Service
public class TestService {
	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void saveUser() {
		Session session = sessionFactory.getCurrentSession();
		session.save(new User());
//		int i = 1 / 0;
		session.save(new User());
	}
}
