package dto.user;
/**
 * 新增代理的结果
 * @author 学徒
 *
 */
public class AddProxyUserResult
{
	private boolean addResult;
	private int id;
	private String password;
	public boolean isAddResult()
	{
		return addResult;
	}
	public void setAddResult(boolean addResult)
	{
		this.addResult = addResult;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
