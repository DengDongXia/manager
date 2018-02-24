package dto.user;
/**
 * 下级代理的信息的输入对象
 * @author 学徒
 *
 */
public class UpdateAgentInput
{
	private int userId;//其用户的Id
	private int agentId;//其下级代理的Id
	private boolean proxyState;//其对应的代理情况
	private boolean locked;//其对应的账号情况
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
	public boolean isProxyState()
	{
		return proxyState;
	}
	public void setProxyState(boolean proxyState)
	{
		this.proxyState = proxyState;
	}
	public boolean isLocked()
	{
		return locked;
	}
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
}
