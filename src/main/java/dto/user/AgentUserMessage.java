package dto.user;
/**
 * 其对应的代理用户的情况封装对象
 * @author 学徒
 *
 */
public class AgentUserMessage
{
	private boolean agent;//代理的判断情况
	private String name;//姓名
	private String email;//邮箱
	private String quote;//个性签名
	private String pictureURL;//头像的URL
	private boolean locked;//账号的锁定情况
	public boolean isAgent()
	{
		return agent;
	}
	public void setAgent(boolean agent)
	{
		this.agent = agent;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
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
}
