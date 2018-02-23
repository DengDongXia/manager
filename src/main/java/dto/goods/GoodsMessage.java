package dto.goods;
/**
 * 获取其代理商品的相关信息
 * @author 学徒
 *
 */
public class GoodsMessage
{
	private int account;//商品的数量
	private int price;//商品的价格
	private String goodsName;//商品名
	public int getAccount()
	{
		return account;
	}
	public void setAccount(int account)
	{
		this.account = account;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
}
