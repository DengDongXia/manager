package dto.data;
/**
 * 用户订单情况统计的相关的输入对象
 * @author 学徒
 *
 */
public class ShowGoodsOrderInput
{
	private int userId;//用户的Id
	private int showLimit;//每页显示的数目
	private int pageIndex;//当前页数
	private int start;//limit语句的相关参数
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getShowLimit()
	{
		return showLimit;
	}
	public void setShowLimit(int showLimit)
	{
		this.showLimit = showLimit;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
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
