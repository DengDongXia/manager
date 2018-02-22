package domain.user;
/**
 * 用户和用户角色的Id的数据库映射表
 * @author 学徒
 *
 */
public class UserRole
{
	private int userID;//用户的Id
	private int roleID;//用户角色的Id
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public int getRoleID()
	{
		return roleID;
	}
	public void setRoleID(int roleID)
	{
		this.roleID = roleID;
	}
}
