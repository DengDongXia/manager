package dto.user;
/**
 * 其对应的用户信息的显示列表的情况
 * @author 学徒
 *
 */
public class ShowUserProxyMessageResult
{
	private int userId;//用户的Id
	private String email;//用户的email
	private String name;//用户的姓名
	private String quote;//用户的个性签名
	private String pictureURL;//用户的照片的URL
	private boolean proxyState;//用户的可代理情况
	private boolean locked;//用户账号的锁定情况
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getQuote()
	{
		return quote;
	}
	public void setQuote(String quote)
	{
		this.quote = quote;
	}
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public boolean isProxyState()
	{
		return proxyState;
	}
	public void setProxyState(boolean proxyState)
	{
		this.proxyState = proxyState;
	}
	public boolean isLocked()
	{
		return locked;
	}
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
}
