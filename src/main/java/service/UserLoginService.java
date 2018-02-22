package service;

import javax.servlet.http.HttpSession;

/**
 * 用户登录相关的接口
 * @author 学徒
 *
 */
public interface UserLoginService
{
	/**
	 * 用于验证用户输入的验证码
	 * @param input 用户输入的验证码
	 * @param validateCode 正确的验证码
	 * @return 验证的结果
	 */
	public abstract boolean checkValidateCode(String input,String validateCode);
	
	/**
	 * 用于验证用户输入的密码
	 * @param input 用户输入的密码
	 * @param user 用户输入的id或者email
	 * @return 验证的结果
	 */
	public abstract boolean checkPassword(String user,String input);
	
	/**
	 * 用于验证账号是否存在的状态
	 * @param input 用户输入的账号
	 * @return 验证的结果
	 */
	public abstract boolean checkAccount(String input);
	
	/**
	 * 用于获取用户的账号的状态
	 * @Param input 用户输入的账号
	 * @return 账号的情况
	 */
	public abstract boolean getAccountState(String input);
	
	/**
	 * 用于将用户相关的信息保存在session对象中
	 * @param input  用户输入的账号
	 * @Param session 用户的session对象
	 * 
	 */
	public abstract void saveUserMessageToSession(String input,HttpSession session);
	
}
