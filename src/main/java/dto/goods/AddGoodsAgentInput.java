package dto.goods;
/**
 * 添加下级代理的商品的相关信息
 * @author 学徒
 *
 */
public class AddGoodsAgentInput
{
	private int userId;//用户本身的Id
	private int agentUserId;//用户代理的Id
	private int goodsId;//用户代理的商品的Id
	private int price;//商品的定价
	private int account;//商品的数目
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getAgentUserId()
	{
		return agentUserId;
	}
	public void setAgentUserId(int agentUserId)
	{
		this.agentUserId = agentUserId;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getAccount()
	{
		return account;
	}
	public void setAccount(int account)
	{
		this.account = account;
	}
	
}
