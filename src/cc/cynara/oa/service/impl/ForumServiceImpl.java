package cc.cynara.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.cynara.oa.base.DaoSupportImpl;
import cc.cynara.oa.domain.Forum;
import cc.cynara.oa.service.ForumService;
@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService{

	
	/**
	 * 重写save方法  在里面十二中position的值
	 */
	public void save(Forum forum) {
		 //保存带到数据库
		getSession().save(forum);
		//设置position的值 为自己的id值
		forum.setPosition( forum.getId().intValue());
		
	}
	/**
	 * 安装position的值排序
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> findAll() {
		return getSession().createQuery(//
				"FROM Forum f ORDER BY f.position ").list();
	}
	public void moveDown(Long id) {
		//找到要交换的forum对象
		Forum forum = getById(id);
		Forum other = (Forum)getSession().createQuery(//
				"FROM Forum f WHERE f.position >? ORDER BY f.position ")
				.setParameter(0, forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		//最上面的不能上移
		if(other == null){
			return;
		}
		//交换position 的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		//操作持久化对象  可不写
//		getSession().update(forum);
//		getSession().update(other);
	}

	public void moveUp(Long id) {
		//找到要交换的forum对象
		Forum forum = getById(id);
		Forum other = (Forum)getSession().createQuery(//
				"FROM Forum f WHERE f.position <? ORDER BY f.position DESC")
				.setParameter(0, forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		//最上面的不能上移
		if(other == null){
			return;
		}
		//交换position 的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		//操作持久化对象 可以不写
//		getSession().update(forum);
//		getSession().update(other);
	}

}
