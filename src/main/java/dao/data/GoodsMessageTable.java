package dao.data;

import java.util.List;

import dto.data.ShowGoodsMessageTableResult;
import dto.data.ShowGoodsOrderTableInput;

/**
 * 相应的报表相关的数据库操作对象
 * @author 学徒
 *
 */
public interface GoodsMessageTable
{
	/**
	 * 用于获取其相应的商品名
	 * @param goodsId 商品的Id
	 * @return 商品的名字
	 */
	public abstract String getGoodsName(int goodsId);
	
	/**
	 * 获取其相应的报表情况
	 * @param input 条件的输入对象
	 * @return 相应的结果
	 */
	public abstract List<ShowGoodsMessageTableResult> getGoodsMessageTable(ShowGoodsOrderTableInput input);
	
}
