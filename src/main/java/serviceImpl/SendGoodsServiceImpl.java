package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.SendGoodsService;
import dao.data.SendGoods;
import dto.data.SendGoodsInput;
@Service
public class SendGoodsServiceImpl implements SendGoodsService
{
	@Autowired
	private SendGoods sendGoodsDao;//数据库对象
	
	public int getSendAccountPerMonth(SendGoodsInput input)
	{
		return sendGoodsDao.getSendGoodsAccount(input)/sendGoodsDao.getSendGoodsMonth(input);
	}

}
