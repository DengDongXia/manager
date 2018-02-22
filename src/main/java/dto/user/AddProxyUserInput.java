package dto.user;
/**
 * 新增代理的输入情况
 * @author 学徒
 *
 */
public class AddProxyUserInput
{
	private int userId;
	private String email;
	private String name;
	private String password;
	private String quote;
	private String pictureURL;
	private boolean proxyState;
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
}
