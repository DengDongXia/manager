package dao.user;

import domain.user.User;

/**
 * 用户登录相关的数据库操作接口
 * @author 学徒
 *
 */
public interface UserLogin
{
	/**
	 * 根据用户的输入，获取用户相应的信息
	 * @param input email或者是用户id
	 * @return 用户的信息对象
	 */
	public abstract User getUserByInput(String input);
	
	/**
	 * 根据用户的输入，判断用户是否存在
	 * @param input 用户的账号的输入情况
	 * @return 账号的存在情况，当其值等于1时候，表示账号存在
	 */
	public abstract int isUserExist(String input);
	
}
