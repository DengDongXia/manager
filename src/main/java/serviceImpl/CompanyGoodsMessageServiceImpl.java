package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CompanyGoodsMessageService;
import dao.goods.CompanyGoods;
import dto.goods.CompanyGoodsInput;
@Service
public class CompanyGoodsMessageServiceImpl implements CompanyGoodsMessageService
{
	@Autowired
	private CompanyGoods companyGoodsDao;//用于用户新增其商品的数据库操作类
	
	public boolean addGoodsMessage(CompanyGoodsInput input)
	{
		return companyGoodsDao.addGoodsMessage(input)==1;
	}
	
}
