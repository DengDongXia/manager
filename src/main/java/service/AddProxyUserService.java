package service;

import dto.user.AddProxyUserInput;

/**
 * 用于添加用户代理相关的数据库的操作类
 * @author 学徒
 *
 */
public interface AddProxyUserService
{
	/**
	 * 用于新增用户代理
	 * @param input 用户代理的相关信息
	 * @return 用户代理的新增情况
	 */
	public abstract boolean insertUserProxy(AddProxyUserInput input);
	
	/**
	 * 用于获取其对应的新增的用户的Id
	 * @param userId 当前用户的Id
	 * @return 新增的用户的Id
	 */
	public abstract int getNewUserProxyId(int userId);
	
}
