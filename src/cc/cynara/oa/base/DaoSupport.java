package cc.cynara.oa.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface DaoSupport<T> {
	/**
	 * 保存
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 根据id删除
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 更新
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 根据id查一个
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 根据id数组查多个
	 * @param id
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
}
