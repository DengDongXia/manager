package dao.user;

import java.util.List;

import dto.user.ShowUserProxyMessageInput;
import dto.user.ShowUserProxyMessageResult;

/**
 * 用于显示用户代理列表所对应的数据库操作类
 * @author 学徒
 *
 */
public interface ShowUserProxy
{
	/**
	 * 用于获取其对应的显示的数目
	 * @param input 用于用户显示相关的信息的输入对象
	 * @return 可进行显示的页面数
	 */
	public abstract int getPageNumber(ShowUserProxyMessageInput input);
	
	/**
	 * 用于获取其对应的用户显示的列表
	 * @param input 用户的输入对象
	 * @return 用户的代理信息的相关列表
	 */
	public abstract List<ShowUserProxyMessageResult> getProxyUserList(ShowUserProxyMessageInput input);
	
	/**
	 * 获取其对应的用户角色的Id
	 * @param userId 用户的Id
	 * @return 对应的用户角色的Id
	 */
	public abstract int getUserRoleId(int userId);
	
}
