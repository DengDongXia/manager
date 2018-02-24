package dao.user;
/**
 * 对应的获取用户的总利润情况的数据库操作类
 * @author 学徒
 *
 */
public interface UserProfit
{
	/**
	 * 获取用户直接销售的商品的金额
	 * @param userId 用户Id
	 * @return 其直接获取的商品的金额
	 */
	public abstract double getAllSendMoney(int userId);
	
	/**
	 * 获取其对应代理的商品的金额
	 * @param userId 用户Id
	 * @return 其相应的结果
	 */
	public abstract double getAllAgentGoodsMoney(int userId);
	
	/**
	 * 获取其对应的用户代理的商品的金额
	 * @param userId 用户的Id
	 * @return 其代理的用户的商品的金额
	 */
	public abstract double getAgentUserGoodsMoney(int userId);
	
}
