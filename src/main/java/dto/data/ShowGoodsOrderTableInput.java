package dto.data;
/**
 * 报表相关的输入类对象
 * @author 学徒
 *
 */
public class ShowGoodsOrderTableInput
{
	private int userId;//用户的Id
	private String year;//年份
	private int type;//数据的统计情况(按月为1，按季度为2，按年度为3)
	private int goodsId;//商品的Id
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getYear()
	{
		return year;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
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
