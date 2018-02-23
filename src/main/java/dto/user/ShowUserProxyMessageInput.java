package dto.user;
/**
 * 显示用户的所有代理的情况的用户输入对象
 * @author 学徒
 *
 */
public class ShowUserProxyMessageInput
{
	private int userId;//查找其对应下级代理的用户的Id
	private int roleId;//其对应的用户的角色的Id
	private int pageIndex;//当前页
	private int showLimit;//每页显示的数目
	private int start;//limit语句所对应的参数
	public int getRoleId()
	{
		return roleId;
	}
	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start =(this.pageIndex-1)*this.showLimit;
	}
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
	
}
