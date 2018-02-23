package dto.goods;
/**
 * 用于查找其对应的
 * @author 学徒
 *
 */
public class SearchGoodsOrderInput
{
	private int userId;//用户Id
	private int pageIndex;//当前页数
	private int showLimit;//每页显示的数目
	private int type;//查询的条件类型
	private String condition;//查询的条件的值
	private int start;//limit语句的相关参数
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getShowLimit()
	{
		return showLimit;
	}
	public void setShowLimit(int showLimit)
	{
		this.showLimit = showLimit;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public String getCondition()
	{
		return condition;
	}
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start =(this.pageIndex-1)*this.showLimit;
	}
}
