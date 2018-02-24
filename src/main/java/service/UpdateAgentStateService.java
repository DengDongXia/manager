package service;

import dto.user.UpdateAgentInput;


/**
 * 更新其相应的用户状态的相关的服务接口对象
 * @author 学徒
 *
 */
public interface UpdateAgentStateService
{
	/**
	 * 根据其相应的情况，修改其对应的信息
	 * @param input 用户的输入类对象
	 * @return 修改的结果
	 */
	public abstract boolean updateAgentState(UpdateAgentInput input);
}
