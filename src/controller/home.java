package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import classes.ChangeAccountDetails;
import classes.ChangeAccountPassword;
import classes.OrderDetails;
import dao.OrderDetailsDao;
import dao.UserDao;
import security.PasswordHashing;

@Controller
@RequestMapping("/home/")
public class Home {
	
	/*@RequestMapping(value="home", method=RequestMethod.GET)
	public String sign_up_success(HttpSession session){
		return "account";
	}*/
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderDetailsDao orderDao;
	
	@RequestMapping(value="details", method=RequestMethod.GET)
	public String homeDetails(HttpSession session){
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		return "acc_details";
	}
	
	@RequestMapping(value="details", method=RequestMethod.POST)
	public String homeDetailsPost(@Valid @ModelAttribute("acc") ChangeAccountDetails acc,BindingResult result,
			HttpSession session,Model model){
		if(result.hasErrors()){
			return "acc_details";
		}
		String phoneNo = (String)session.getAttribute("phoneNo");
		String newPhoneNo = acc.getPhoneNo();
		if(!phoneNo.equals(newPhoneNo)){
			int x = userDao.checkUserExists(newPhoneNo);
			if(x==0){
				userDao.changeDetails(acc, phoneNo);
				session.setAttribute("phoneNo",newPhoneNo);
			}
			else{
				model.addAttribute("Msg","User with that Phone Number already exists");
				return "acc_details";
			}
		}
		else{
			userDao.changeDetails(acc, phoneNo);
		}
		model.addAttribute("Msg_chng","Changes Saved");
		session.setAttribute("name",acc.getName());
		session.setAttribute("userAddress",acc.getAddress());
		return "acc_details";
	}
	
	@RequestMapping(value="password", method=RequestMethod.GET)
	public String homePassword(HttpSession session){
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		return "acc_change_pass";
	}
	
	@RequestMapping(value="password", method=RequestMethod.POST)
	public String homePasswordPost(@Valid @ModelAttribute("acc") ChangeAccountPassword acc,BindingResult result,
			HttpSession session,Model model){
		model.addAttribute("acc");
		if(result.hasErrors()){
			return "acc_change_pass";
		}
		try{
			acc.setCurrentPassword(PasswordHashing.hash(acc.getCurrentPassword()));
			acc.setNewPassword(PasswordHashing.hash(acc.getNewPassword()));
			acc.setNewPasswordConfirm(PasswordHashing.hash(acc.getNewPasswordConfirm()));
		}
		catch(Exception e){
			
		}
		if(acc.getNewPassword().equals(acc.getNewPasswordConfirm())){
			String password = userDao.getPassword((String)session.getAttribute("phoneNo"));
			if(password.equals(acc.getCurrentPassword())){
				userDao.changePassword(acc.getNewPassword(), (String)session.getAttribute("phoneNo"));
				model.addAttribute("Msg_chng","Changes Saved");
			}
			else{
				model.addAttribute("Msg_pwd","Entered Password is incorrect");
			}
		}
		else
			model.addAttribute("Msg_pwd_conf","Passwords do not match");
		
		return "acc_change_pass";
	}
	
	@RequestMapping(value = "place_order")
	public String placeOrder(HttpSession session,Model model) {
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		orderDao.createTableOrders();
		//ModelAndView model = new ModelAndView("place_order");
		String phone = (String)session.getAttribute("phoneNo");
		String address = userDao.getAddress(phone);
		model.addAttribute("userAddress", address);
		return "place_order";
		//return model;
	}
	
	@RequestMapping(value = "view_orders")
	public String viewOrders(HttpSession session,Model model){
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		orderDao.createTableOrders();
		String phone = (String)session.getAttribute("phoneNo");
		String userId = userDao.getUserId(phone);
		List<OrderDetails> orders = orderDao.showOrders(userId);
		if(orders.isEmpty()){
			model.addAttribute("Msg", "You haven't placed any order yet");
		}
		else{
			model.addAttribute("orderList", orders);
		}
		return "view_orders";
		//return model;
	}
	
	@RequestMapping(value = "order_placed", method = RequestMethod.POST)
	public ModelAndView orderPlacedPost(@Valid @ModelAttribute("order") OrderDetails order, BindingResult result,
			HttpSession session,HttpSession order_session) {
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("place_order");
			return model;
		}
		String userId = (String)session.getAttribute("userId");
		orderDao.takeOrder(order,userId);
		ModelAndView model = new ModelAndView("order_placed");
		if(orderDao.checkFirstOrder(userId)==1){
			model.addObject("Msg","Since this was your first order,it is absolutely free !");
		}
		model.addObject("order",order);
		order_session.setAttribute("order", order);
		return model;
	}

	@RequestMapping(value = "order_placed", method = RequestMethod.GET)
	public String orderPlaced(HttpSession session,HttpSession order_session) {
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		return "order_placed";
		//ModelAndView model = new ModelAndView("order_placed");
		//return model;
	}

}
