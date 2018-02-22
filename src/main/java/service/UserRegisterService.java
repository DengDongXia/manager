package service;

import dto.user.UserRegisterInput;

/**
 * 用户注册相关的服务类
 * @author 学徒
 *
 */
public interface UserRegisterService
{
	/**
	 * 用于判断用户的邮箱是否已经存在
	 * @param email 用户输入的邮箱
	 * @return 返回判断的结果
	 */
	public abstract boolean isEmailExist(String email);
	/**
	 * 判断两次输入的密码是否一致
	 * @Param password 输入的密码
	 * @Param repeated 输入的重复密码
	 * @return 判断的结果
	 */
	public abstract boolean isPasswordRepeated(String password,String repeatedPassword);
	/**
	 * 判断输入的验证码和正确的验证码的结果
	 * @Param validateCode 正确的验证码
	 * @Param input 输入的验证码
	 * @return 验证码的情况
	 */
	public abstract boolean isValidateCodeResult(String validateCode,String input);
	
	/**
	 * 用于新增用户，将相应的用户信息插入到数据库中
	 * @param input 用户的信息的输入对象
	 */
	public abstract void insertUser(UserRegisterInput input);
}
