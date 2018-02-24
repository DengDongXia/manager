package service;
/**
 * 用于获取其对应的中利润值的用户的服务类
 * @author 学徒
 *
 */
public interface UserProfitService
{
	/**
	 * 用于获取其对应的用户Id的总利润情况
	 * @param userId 用户的Id
	 * @return 其对应的用户的总利润情况
	 */
	public abstract double getUserAccountProfit(int userId);
}
