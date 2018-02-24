package dao.user;

import domain.user.User;
import dto.user.IsAgentInput;

/**
 * 判断其是否为对应的数据库用户的操作类对象
 * @author 学徒
 *
 */
public interface IsAgentUser
{
	/**
	 * 判断其否为对应的用户的代理用户情况
	 * @param input 用户的输入对象
	 * @return 为1时，表示其为对应的代理用户
	 */
	public abstract int isAgentUser(IsAgentInput input);
	
	/**
	 * 获取其对应的代理用户的相关信息
	 * @param input 用户的输入对象
	 * @return 对应的代理用户的相关信息
	 */
	public abstract User getAgentUserMessage(IsAgentInput input);
}
