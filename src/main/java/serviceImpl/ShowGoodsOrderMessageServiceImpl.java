package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.ShowGoodsOrderMessageService;
import dao.data.GoodsMessageTable;
import dto.data.ShowGoodsMessageTableResult;
import dto.data.ShowGoodsOrderTableInput;
@Service
public class ShowGoodsOrderMessageServiceImpl implements ShowGoodsOrderMessageService
{
	@Autowired
	private GoodsMessageTable goodsMessageTableDao;//获取其相应的报表情况的数据库操作对象
	
	public List<ShowGoodsMessageTableResult> getContent(ShowGoodsOrderTableInput input)
	{
		return goodsMessageTableDao.getGoodsMessageTable(input);
	}

	public String getGoodsNameByGoodsId(int goodsId)
	{
		return goodsMessageTableDao.getGoodsName(goodsId);
	}
	
}
