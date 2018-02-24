package service;

import dto.user.AgentUserMessage;
import dto.user.IsAgentInput;

/**
 * 代理的判断情况
 * @author 学徒
 *
 */
public interface AgentUserJudgeService
{
	/**
	 * 判断其是否为对应的用户的情况
	 * @param input
	 * @return
	 */
	public abstract AgentUserMessage isAgentUser(IsAgentInput input);
}
