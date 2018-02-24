package dto.data;
/**
 * 订单统计情况的相关结果对象
 * @author 学徒
 *
 */
public class SendGoodsMessageResult
{
	private String goodsName;//商品的名称
	private int goodsId;//商品的Id
	private int sendGoods;//商品的销量
	private int saveGoods;//商品的存货
	private int account;//利润情况
	private int cost;//成本
	public String getGoodsName()
	{
		return goodsName;
	}
	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public int getSendGoods()
	{
		return sendGoods;
	}
	public void setSendGoods(int sendGoods)
	{
		this.sendGoods = sendGoods;
	}
	public int getSaveGoods()
	{
		return saveGoods;
	}
	public void setSaveGoods(int saveGoods)
	{
		this.saveGoods = saveGoods;
	}
	public int getAccount()
	{
		return account;
	}
	public void setAccount(int account)
	{
		this.account = account;
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
}
