package dto.data;
/**
 * 获取其相应的报表情况的结果对象
 * @author 学徒
 *
 */
public class ShowGoodsMessageTableResult
{
	private String time;//时间
	private int number;//总销售
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
}
