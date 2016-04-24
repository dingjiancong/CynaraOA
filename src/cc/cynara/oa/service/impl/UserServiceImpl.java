package cc.cynara.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.User;
import cc.cynara.oa.service.UserService;
import cc.cynara.oa.utils.MD5EncodingUtils;

//@Transactional    可以不写
@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{
	
	public User findByLoginNameAndPassword(String loginName, String password) {
		if(password==null||"".equals(password)){
			return null;
		}else{
			String md5Pwd = DigestUtils.md5Hex(password);
			return (User)getSession().createQuery("FROM User u WHERE u.loginName=? AND u.password=?")
				.setParameter(0, loginName).setParameter(1, md5Pwd).uniqueResult();
		}
	}

//	@Resource
//	UserDao dao = new UserDaoImpl();
//	@Transactional
//	public void saveUser(User entity){
//		dao.save(entity);
//	}
}
