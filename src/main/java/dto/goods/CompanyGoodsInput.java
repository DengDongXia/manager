package dto.goods;
/**
 * 厂商录入相应的商品信息
 * @author 学徒
 *
 */
public class CompanyGoodsInput
{
	private String name;//商品的名字
	private int price;//商品的价格
	private int account;//商品的数量
	private int userId;//厂商的用户Id
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
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
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
}
