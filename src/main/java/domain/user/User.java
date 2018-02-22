package domain.user;
/**
 * 用于用户信息相关的封装对象
 * @author 学徒
 *
 */
public class User
{
	private int id;//用户的Id
	private String email;//用户的email
	private String name;//用户的姓名
	private String quote;//用户的个性签名
	private String pictureURL;//用户的头像的URL
	private String timeStamp;//用户注册时候的时间戳
	private String password;//用户的密码
	private int belong;//用户所属的上级用户的Id
	private boolean locked;//用户的账号的锁定状态
	private boolean proxyState;//用户的代理允许情况
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getBelong()
	{
		return belong;
	}
	public void setBelong(int belong)
	{
		this.belong = belong;
	}
	public String getTimeStamp()
	{
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
	public boolean isLocked()
	{
		return locked;
	}
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	public boolean isProxyState()
	{
		return proxyState;
	}
	public void setProxyState(boolean proxyState)
	{
		this.proxyState = proxyState;
	}
	
	
}
