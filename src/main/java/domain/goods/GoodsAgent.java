package domain.goods;
/**
 * 用户商品代理的相关的映射对象
 * @author 学徒
 *
 */
public class GoodsAgent
{
	private int goodsId;//商品的Id
	private int userId;//用户的Id
	private int price;//商品的价格
	private int account;//商品的数目
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
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
