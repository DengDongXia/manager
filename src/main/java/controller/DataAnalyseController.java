package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AgentGoodsService;
import service.GoodsOrderMessageService;
import service.SendGoodsService;
import service.ShowGoodsOrderMessageService;
import dto.data.AgentGoodsDataResult;
import dto.data.SendGoodsInput;
import dto.data.ShowGoodsOrderInput;
import dto.data.ShowGoodsOrderTableInput;

/**
 * 其相应的数据显示的控制器类
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/data")
public class DataAnalyseController
{
	@Autowired
	private AgentGoodsService agentGoodsService;//获取用户代理商品的服务类
	@Autowired
	private SendGoodsService sendGoodsService;//商品的月平均销售情况的服务类
	@Autowired
	private GoodsOrderMessageService goodsOrderService;//获取其商品的订单的情况的统计
	@Autowired
	private ShowGoodsOrderMessageService showGoodsOrderMessageService;//用于获取其对应的商品的报表情况的服务类
	
	@RequestMapping("/getAgentGoodsMessage")
	@ResponseBody
	public  Map<String,List<AgentGoodsDataResult>> getAgentGoodsMessage(@RequestBody Map<String,Object> Id)
	{
		int userId=(Integer)Id.get("userId");
		Map<String,List<AgentGoodsDataResult>> result=new HashMap<String,List<AgentGoodsDataResult>>();
		result.put("content",agentGoodsService.getAgentGoodsMessage(userId));
		return result;
	}
	
	@RequestMapping("/getSendMessage")
	@ResponseBody
	public Map<String,Integer> getSendMessage(@RequestBody SendGoodsInput input)
	{
		Map<String,Integer> result=new HashMap<String,Integer>();
		result.put("sendAccount",sendGoodsService.getSendAccountPerMonth(input));
		return result;
	}
	
	@RequestMapping("/goodsOrderMessage")
	@ResponseBody
	public Map<String,Object> getGoodsOrderMessage(@RequestBody ShowGoodsOrderInput input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		input.setStart();
		result.put("sendGoods",goodsOrderService.getSendGoodsContent(input));
		result.put("pageNumber",(input));
		return result;
	}
	
	@RequestMapping("/showGoodsOrderMessage")
	@ResponseBody
	public Map<String,Object> showGoodsOrderMessage(@RequestBody ShowGoodsOrderTableInput input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("content", showGoodsOrderMessageService.getContent(input));
		result.put("goodsName",showGoodsOrderMessageService.getGoodsNameByGoodsId(input.getGoodsId()));
		return result;
	}
	
}
