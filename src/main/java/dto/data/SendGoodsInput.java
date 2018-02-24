package dto.data;
/**
 * 用于获取某件商品的月销售情况的输入对象
 * @author 学徒
 *
 */
public class SendGoodsInput
{
	private int userId;//用户Id
	private int goodsId;//商品的Id
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
}
