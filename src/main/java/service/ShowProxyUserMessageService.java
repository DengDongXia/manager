package service;

import java.util.List;

import dto.user.ShowUserProxyMessageInput;
import dto.user.ShowUserProxyMessageResult;

/**
 * 用于显示其对应的代理用户的信息列表的服务接口
 * @author 学徒
 *
 */
public interface ShowProxyUserMessageService
{
	/**
	 * 获取其对应的可显示的代理用户的页面数
	 * @param input 用户的输入对象
	 * @return 可进行显示的页面的数目
	 */
	public abstract int getPageNumber(ShowUserProxyMessageInput input);
	
	/**
	 * 通过输入的数据类对象，获取其对应的结果
	 * @param input 输入的数据对象
	 * @return 对应的结果列表
	 */
	public abstract List<ShowUserProxyMessageResult> getContentByInput(ShowUserProxyMessageInput input);
	
	/**
	 * 根据其用户Id获取其对应的用户角色的Id
	 * @param userId 用户的Id
	 * @return 用户角色的Id
	 */
	public abstract int getUserRoleId(int userId);
	
}
