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

import classes.acc_details;
import classes.acc_pass;
import classes.order_details;
import dao.order_detailsDao;
import dao.userDao;

@Controller
@RequestMapping("/home/")
public class home {
	
	/*@RequestMapping(value="home", method=RequestMethod.GET)
	public String sign_up_success(HttpSession session){
		return "account";
	}*/
	@Autowired
	userDao userDao;
	
	@Autowired
	order_detailsDao orderDao;
	
	@RequestMapping(value="details", method=RequestMethod.GET)
	public String home_details(HttpSession session){
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		return "acc_details";
	}
	
	@RequestMapping(value="details", method=RequestMethod.POST)
	public String home_details(@Valid @ModelAttribute("acc") acc_details acc,BindingResult result,
			HttpSession session,Model model){
		if(result.hasErrors()){
			return "acc_details";
		}
		String phone_no = (String)session.getAttribute("phone_no");
		String new_phone_no = acc.getPhone_no();
		if(!phone_no.equals(new_phone_no)){
			int x = userDao.check_user_exists(new_phone_no);
			if(x==0){
				userDao.change_details(acc, phone_no);
				session.setAttribute("phone_no",new_phone_no);
			}
			else{
				model.addAttribute("Msg","User with that Phone Number already exists");
				return "acc_details";
			}
		}
		else{
			userDao.change_details(acc, phone_no);
		}
		model.addAttribute("Msg_chng","Changes Saved");
		session.setAttribute("name",acc.getName());
		session.setAttribute("user_address",acc.getAddress());
		return "acc_details";
	}
	
	@RequestMapping(value="password", method=RequestMethod.GET)
	public String home_password(HttpSession session){
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		return "acc_change_pass";
	}
	
	@RequestMapping(value="password", method=RequestMethod.POST)
	public String home_password(@Valid @ModelAttribute("acc") acc_pass acc,BindingResult result,
			HttpSession session,Model model){
		model.addAttribute("acc");
		if(result.hasErrors()){
			return "acc_change_pass";
		}
		if(acc.getNew_pass().equals(acc.getNew_pass_confirm())){
			String password = userDao.get_password((String)session.getAttribute("phone_no"));
			if(password.equals(acc.getCurr_pass())){
				userDao.change_password(acc.getNew_pass(), (String)session.getAttribute("phone_no"));
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
	public String place_order(HttpSession session,Model model) {
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		orderDao.create_table_orders();
		//ModelAndView model = new ModelAndView("place_order");
		String phone = (String)session.getAttribute("phone_no");
		String address = userDao.get_address(phone);
		model.addAttribute("user_address", address);
		return "place_order";
		//return model;
	}
	
	@RequestMapping(value = "view_orders")
	public String view_orders(HttpSession session,Model model){
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		orderDao.create_table_orders();
		String phone = (String)session.getAttribute("phone_no");
		String user_id = userDao.get_user_id(phone);
		List<order_details> orders = orderDao.show_orders(user_id);
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
	public ModelAndView order_placed(@Valid @ModelAttribute("order") order_details order, BindingResult result,
			HttpSession session,HttpSession order_session) {
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("place_order");
			return model;
		}
		String user_id = (String)session.getAttribute("user_id");
		orderDao.take_order(order,user_id);
		ModelAndView model = new ModelAndView("order_placed");
		if(orderDao.check_first_order(user_id)==1){
			model.addObject("Msg","Since this was your first order,it is absolutely free !");
		}
		model.addObject("order",order);
		order_session.setAttribute("order", order);
		return model;
	}

	@RequestMapping(value = "order_placed", method = RequestMethod.GET)
	public String order_placed_get(HttpSession session,HttpSession order_session) {
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		return "order_placed";
		//ModelAndView model = new ModelAndView("order_placed");
		//return model;
	}

}
