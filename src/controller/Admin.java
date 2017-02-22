package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminLogin;
import admin.Info;
import admin.OrderInfo;
import admin.UserInfo;
import admin_dao.AdminDao;

@Controller
@RequestMapping("/admin")
public class Admin {
	
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String login(){
		return "admin_login";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession adminSession){
		adminSession.invalidate();
		return "redirect:/admin";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("admin") AdminLogin admin,Model model,HttpSession adminSession){
		if(adminDao.check(admin)==1){
			adminSession.setAttribute("username", admin.getUsername());
			return "redirect:/admin/home";
		}
		else{
			model.addAttribute("error","Username or Password is incorrect");
			return "admin_login";
		}
	}
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public ModelAndView home(HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		ModelAndView model = new ModelAndView("admin_account");
		List<Info> info = adminDao.showInfo();
		model.addObject("info",info);
		return model;
	}
	
	@RequestMapping(value="home/view_users",method=RequestMethod.GET)
	public ModelAndView viewUsers(HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		List<UserInfo> users = adminDao.showUsers();
		ModelAndView model = new ModelAndView("admin_view_users");
		model.addObject("userList", users);
		return model;
	}
	
	@RequestMapping(value="home/view_orders",method=RequestMethod.GET)
	public ModelAndView viewOrders(HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		List<OrderInfo> orders = adminDao.showOrders();
		ModelAndView model = new ModelAndView("admin_view_orders");
		model.addObject("orderList",orders);
		return model;
	}
	
	@RequestMapping(value="home/view_orders/search",method=RequestMethod.GET)
	public ModelAndView searchOrder(HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		ModelAndView model = new ModelAndView("admin_search_order");
		model.addObject("Msg","Search An Order");
		return model;
	}
	
	@RequestMapping(value="home/view_orders/search",method=RequestMethod.POST)
	public ModelAndView searchOrderPost(@RequestParam("orderId") String orderId,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		ModelAndView model = new ModelAndView("admin_search_order");
		List<OrderInfo> orderSearch = adminDao.searchOrder(orderId);
		if(orderSearch.isEmpty()){
			model.addObject("Msg","No Order Found");
		}
		else{
			model.addObject("order",orderSearch);
		}
		return model;
	}
	
	@RequestMapping(value="home/view_orders/{orderId}",method=RequestMethod.GET)
	public ModelAndView viewOrder(@PathVariable("orderId") String orderId,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		List<OrderInfo> orderList = adminDao.searchOrder(orderId);
		ModelAndView model = new ModelAndView("admin_view_order");
		model.addObject("orderList",orderList);
		return model;
	}
	
	@RequestMapping(value="home/view_orders/{orderId}",method=RequestMethod.POST)
	public ModelAndView viewOrderPost(@PathVariable("orderId") String orderId,@RequestParam("btn") String action,@RequestParam("bill") int bill,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		adminDao.changeStatus(action,orderId,bill);
		List<OrderInfo> orderList = adminDao.searchOrder(orderId);
		ModelAndView model = new ModelAndView("admin_view_order");
		model.addObject("orderList",orderList);
		return model;
	}
	
	@RequestMapping(value="home/view_users/search",method=RequestMethod.GET)
	public ModelAndView searchUser(HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		ModelAndView model = new ModelAndView("admin_search_user");
		model.addObject("Msg","Search for a User");
		return model;
	}
	
	@RequestMapping(value="home/view_users/search",method=RequestMethod.POST)
	public ModelAndView searchUserPost(@RequestParam("phoneNo") String phoneNo,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		ModelAndView model = new ModelAndView("admin_search_user");
		List<UserInfo> userSearch = adminDao.searchUser(phoneNo);
		if(userSearch.isEmpty()){
			model.addObject("Msg","User Not Found");
		}
		else{
			model.addObject("user",userSearch);
		}
		return model;
	}
	
	@RequestMapping(value="home/view_users/{phoneNo}",method=RequestMethod.GET)
	public ModelAndView viewUser(@PathVariable("phoneNo") String phoneNo,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		List<UserInfo> user = adminDao.showUser(phoneNo);
		ModelAndView model = new ModelAndView("admin_view_user");
		model.addObject("userList",user);
		return model;
	}
	
	@RequestMapping(value="home/view_users/{phoneNo}/orders",method=RequestMethod.GET)
	public ModelAndView viewUserOrder(@PathVariable("phoneNo") String phoneNo,HttpSession adminSession){
		if(adminSession.getAttribute("username") == null){
			ModelAndView model = new ModelAndView("redirect:/admin");
			return model;
		}
		List<OrderInfo> order = adminDao.showUserOrders(phoneNo);
		ModelAndView model = new ModelAndView("admin_view_userOrder");
		model.addObject("orderList",order);
		return model;
	}
}
