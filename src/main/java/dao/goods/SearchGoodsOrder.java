package dao.goods;

import java.util.List;

import dto.goods.SearchGoodsOrderInput;
import dto.goods.SearchGoodsOrderResult;

/**
 * 用于获取其对应的订单的显示的数据库操作接口
 * @author 学徒
 *
 */
public interface SearchGoodsOrder
{
	/**
	 * 用于获取其对应的可进行显示的页面数
	 * @param input 参数条件
	 * @return 可进行显示的页面数
	 */
	public abstract int getPageNumber(SearchGoodsOrderInput input);
	
	/**
	 * 根据输入的情况，获取其对应的订单的结果
	 * @param input 用户输入的数据对象
	 * @return 其相应的结果
	 */
	public abstract List<SearchGoodsOrderResult> getContent(SearchGoodsOrderInput input);
	
}
