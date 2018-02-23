package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AddGoodsAgentService;
import service.AddGoodsOrderService;
import service.AddProxyUserService;
import service.GoodsMessageService;
import service.SearchGoodsOrderService;
import service.ShowProxyUserMessageService;
import service.UpdateGoodsOrderService;
import service.UserLoginService;
import service.UserRegisterService;
import domain.goods.GoodsOrder;
import domain.user.User;
import dto.goods.AddGoodsAgentInput;
import dto.goods.GoodsMessage;
import dto.goods.GoodsMessageInput;
import dto.goods.SearchGoodsOrderInput;
import dto.goods.UpdateGoodsOrderInput;
import dto.user.AddProxyUserInput;
import dto.user.AddProxyUserResult;
import dto.user.ShowUserProxyMessageInput;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
import dto.user.UserMessage;
import dto.user.UserRegisterInput;
import dto.user.UserRegisterResult;

/**
 * 用户相关的控制器类
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserLoginService userLoginService;//用户登录相关的服务类
	@Autowired
	private UserRegisterService userRegisterService;//用户注册的相关的服务类
	@Autowired
	private AddProxyUserService addUserProxyService;//用于新增用户代理的相关服务类
	@Autowired
	private ShowProxyUserMessageService showProxyService; //用于显示用户新增代理列表的相关服务类
	@Autowired
	private AddGoodsOrderService goodsOrderService;//用于用户新增其订单
	@Autowired
	private SearchGoodsOrderService searchGoodsOrderService;//用于查找其对应的订单情况
	@Autowired
	private UpdateGoodsOrderService updateGoodsOrderService;//用于更新其相应的订单的服务类对象
	@Autowired
	private AddGoodsAgentService addGoodsAgentService;//用于添加相应的商品代理的服务类对象
	@Autowired
	private GoodsMessageService getGoodsMessageService;//用于获取其相应的商品信息的代理对象
	
	
	@RequestMapping("/login")
	@ResponseBody
	public UserLoginResult userLogin(@RequestBody UserLoginInput input,HttpSession session)
	{
		boolean exist=userLoginService.checkAccount(input.getAccount());
		UserLoginResult result =new UserLoginResult();
		if(exist)
		{
			result.setAccountResult(userLoginService.checkAccount(input.getAccount()));
			result.setAccountState(userLoginService.getAccountState(input.getAccount()));
			result.setPasswordResult(userLoginService.checkValidateCode(input.getAccount(), input.getPassword()));
			String validateCode =(String)session.getAttribute("validateCode");
			result.setValidateCodeResult(userLoginService.checkValidateCode(validateCode,input.getValidateCode()));
		}
		if(result.isPass())
		{
			userLoginService.saveUserMessageToSession(input.getAccount(), session);
		}
		return result;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public UserRegisterResult userRegister(@RequestBody UserRegisterInput input,HttpSession session)
	{
		UserRegisterResult result =new UserRegisterResult();
		String validateCode=(String)session.getAttribute("validateCode");
		boolean emailExist=userRegisterService.isEmailExist(input.getEmail());
		boolean passwordResult=userRegisterService.isPasswordRepeated(input.getPassword(),input.getRepeatedPassword());
		boolean validateCodeResult =userRegisterService.isValidateCodeResult(validateCode, input.getValidateCode());
		result.setEmailExist(emailExist);
		result.setPasswordResult(passwordResult);
		result.setValidateCodeResult(validateCodeResult);
		if(result.isPass())
		{
			userRegisterService.insertUser(input);
		}
		return result;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public AddProxyUserResult addProxyUser(@RequestBody AddProxyUserInput input)
	{
		AddProxyUserResult result=new AddProxyUserResult();
		result.setPassword(input.getPassword());
		result.setAddResult(addUserProxyService.insertUserProxy(input));
		result.setId(addUserProxyService.getNewUserProxyId(input.getUserId()));
		return result;
	}
	
	@RequestMapping("/getUserMessage")
	@ResponseBody
	public UserMessage getUserMessage(HttpSession session)
	{
		User user=(User)session.getAttribute("user");
		UserMessage result=new UserMessage();
		result.setName(user.getName());
		result.setPictureURL(user.getPictureURL());
		result.setQuote(user.getQuote());
		result.setUserId(user.getId());
		return result;
	}
	
	@RequestMapping("/proxyState")
	@ResponseBody
	public Map<String,Boolean> checkUserProxyState(@RequestBody Map<String,Object> input,HttpSession session)
	{
		User user=(User)session.getAttribute("user");
		boolean proxyState=false;
		if(user!=null)
			proxyState=user.isProxyState();
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("proxyState",proxyState);
		return result;
	}
	
	@RequestMapping("/showProxyUserMessage")
	@ResponseBody
	public Map<String,Object> showProxyUserList(@RequestBody ShowUserProxyMessageInput input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		input.setStart();
		input.setRoleId(showProxyService.getUserRoleId(input.getUserId()));
		result.put("pageNumber",showProxyService.getPageNumber(input));
		result.put("content",showProxyService.getContentByInput(input));
		return result;
	}
	
	@RequestMapping("/addGoodsOrder")
	@ResponseBody
	public Map<String,Boolean> addGoodsOrder(@RequestBody GoodsOrder input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("addGoodsOrderResult",goodsOrderService.addGoodsOrder(input));
		return result;
	}
	
	@RequestMapping("/searchGoodsOrder")
	@ResponseBody
	public Map<String,Object> searchGoodsOrder(@RequestBody SearchGoodsOrderInput input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		input.setStart();
		result.put("pageNumber", searchGoodsOrderService.getPageNumber(input));
		result.put("content", searchGoodsOrderService.getContent(input));
		return result;
	}
	
	@RequestMapping("/updateGoodsOrder")
	@ResponseBody
	public Map<String,Boolean> updateGoodsOrderInput(@RequestBody UpdateGoodsOrderInput input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("updateResult",updateGoodsOrderService.updateGoodsOrder(input));
		return result;
	}
	
	@RequestMapping("/addGoodsAgent")
	@ResponseBody
	public Map<String,Object> addGoodsAgent(@RequestBody AddGoodsAgentInput  input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("goodsAgentResult",addGoodsAgentService.addGoodsAgent(input));
		return result;
	}
	
	@RequestMapping("/getGoodsMessage")
	@ResponseBody
	public GoodsMessage getGoodsMessage(@RequestBody GoodsMessageInput input)
	{
		return getGoodsMessageService.getGoodsMessage(input);
	}
/*	
	@RequstMapping("/isAgentUser")
	@ResponseBody
	public 
	*/
}
