package service;

import java.util.List;

import dto.goods.SearchGoodsOrderInput;
import dto.goods.SearchGoodsOrderResult;

/**
 * 用于查询其对应的订单情况的服务接口
 * @author 学徒
 *
 */
public interface SearchGoodsOrderService
{
	/**
	 * 获取其对应的可进行显示的分页数
	 * @param input 用户输入的查询情况的参数
	 * @return 其可进行分页的数目
	 */
	public abstract int getPageNumber(SearchGoodsOrderInput input);
	
	/**
	 * 获取其对应的订单的情况的列表
	 * @param input 用户输入的查询情况的参数
	 * @return 订单情况的列表
	 */
	public abstract List<SearchGoodsOrderResult> getContent(SearchGoodsOrderInput input);
}
