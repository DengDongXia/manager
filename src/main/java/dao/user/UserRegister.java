package dao.user;

import domain.user.User;

/**
 * 用户注册相关的数据库操作接口
 * @author 学徒
 *
 */
public interface UserRegister
{
	/**
	 * 用于判断所在用户中，邮箱是否已经被使用过
	 * @param email 用户输入的邮箱号
	 * @return 当其值为1时，表示存在
	 */
	public abstract int isExistEmail(String email);
	
	/**
	 * 用于往数据库的用户表中插入相应的数据
	 * @param user 数据对象的相关信息
	 */
	public abstract void insertUser(User user);
	
	/**
	 * 用于往数据库的用户角色表中插入相应的数据
	 * @param user
	 */
	public abstract void insertUserRole(User user);
}
