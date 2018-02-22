package dao.user;

import domain.user.User;
import domain.user.UserRole;

/**
 * 用于新增现相应的用户代理的数据库操作类
 * @author 学徒
 *
 */
public interface AddUserProxy
{
	/**
	 * 用于新增代理用户的数据库插入情况
	 * @param input 新增的代理用户的输入情况
	 * @return 执行的结果
	 */
	public abstract void insertUserProxyMessage(User input);
	
	/**
	 * 用于新增代理用户的角色的情况
	 * @param input 用户的角色的相关信息
	 */
	public abstract void insertUserProxyRole(UserRole input);
	
	/**
	 * 用于获取新增的代理用户的Id
	 * @param input 新增代理用户的用户Id
	 * @return 新增的代理用户的Id
	 */
	public abstract int getInsertUserProxyId(int input);
	
	/**
	 * 用于获取对应的用户的用户角色的Id
	 * @param input 用户的Id
	 * @return 用户角色的Id
	 */
	public abstract int getUserRoleId(int input);
	
}
