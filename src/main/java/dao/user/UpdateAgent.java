package dao.user;

import dto.user.UpdateAgentInput;

/**
 * 其对应的数据库操作类
 * @author 学徒
 *
 */
public interface UpdateAgent
{
	/**
	 * 更新其相应的用户的相应的情况
	 * @param input 用户的输入情况
	 * @return 其受影响的行数
	 */
	public abstract int updateUserAgentState(UpdateAgentInput input);
}
