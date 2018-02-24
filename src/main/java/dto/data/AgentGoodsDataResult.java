package dto.data;
/**
 * 其相应的商品销售的结果对象
 * @author 学徒
 *
 */
public class AgentGoodsDataResult
{
	private int agentUserId;//代理用户的用户Id
	private String agentUserName;//代理用户的昵称
	private String agentUserPictureURL;//代理用户的头像的URL
	private double account;//代理用户的利润总额
	private int goodsNumber;//代理用户销售的商品的总数
	public int getAgentUserId()
	{
		return agentUserId;
	}
	public void setAgentUserId(int agentUserId)
	{
		this.agentUserId = agentUserId;
	}
	public String getAgentUserName()
	{
		return agentUserName;
	}
	public void setAgentUserName(String agentUserName)
	{
		this.agentUserName = agentUserName;
	}
	public String getAgentUserPictureURL()
	{
		return agentUserPictureURL;
	}
	public void setAgentUserPictureURL(String agentUserPictureURL)
	{
		this.agentUserPictureURL = agentUserPictureURL;
	}
	public double getAccount()
	{
		return account;
	}
	public void setAccount(double account)
	{
		this.account = account;
	}
	public int getGoodsNumber()
	{
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber)
	{
		this.goodsNumber = goodsNumber;
	}
}
