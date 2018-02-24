package dto.user;
/**
 * 判断其是否为对应的代理用户的输入对象
 * @author 学徒
 *
 */
public class IsAgentInput
{
	private int userId;//用户的Id
	private int agentId;//代理用户的Id
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getAgentId()
	{
		return agentId;
	}
	public void setAgentId(int agentId)
	{
		this.agentId = agentId;
	}
}
