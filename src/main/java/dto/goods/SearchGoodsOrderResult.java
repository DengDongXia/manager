package dto.goods;

import java.util.Date;

/**
 * 订单查询的相关的订单结果
 * @author 学徒
 *
 */
public class SearchGoodsOrderResult
{
	private int id;//订单的Id
	private String customerName;//订单的客户名
	private String customerPhone;//订单的客户的电话号码
	private String customerEmail;//订单的客户的邮箱
	private boolean state;//收货状态
	private String address;//发货地址
	private String dliveryCompany;//快递公司
	private String dliveryId;//快递单号
	private Date time;//订单编写时间
	private int price;//出售的商品的价格
	private String goodsName;//商品名
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public String getCustomerPhone()
	{
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone)
	{
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail()
	{
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getDliveryCompany()
	{
		return dliveryCompany;
	}
	public void setDliveryCompany(String dliveryCompany)
	{
		this.dliveryCompany = dliveryCompany;
	}
	public String getDliveryId()
	{
		return dliveryId;
	}
	public void setDliveryId(String dliveryId)
	{
		this.dliveryId = dliveryId;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
}
