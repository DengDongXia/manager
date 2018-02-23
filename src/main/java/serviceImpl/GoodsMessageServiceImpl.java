package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.GoodsMessageService;
import dao.goods.GetGoodsMessage;
import dto.goods.GoodsMessage;
import dto.goods.GoodsMessageInput;
@Service 
public class GoodsMessageServiceImpl implements GoodsMessageService
{
	@Autowired
	private GetGoodsMessage goodsMessageDao;//数据库的相关的操作类
	public GoodsMessage getGoodsMessage(GoodsMessageInput input)
	{
		return goodsMessageDao.getGoodsMessage(input);
	}
	
}
