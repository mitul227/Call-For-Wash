package controller;

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

import classes.item_prices;
import classes.user_login;
import classes.user_signup;
import dao.order_detailsDao;
import dao.userDao;

@Controller
// @SessionAttributes("user_session")
public class login {

	@Autowired
	userDao userDao;

	@Autowired
	order_detailsDao orderDao;
	
//	@RequestMapping(value="/*")
//	public String not_found(){
//		return "not_found";
//	}
	
	@RequestMapping(value = "/")
	public ModelAndView login_page() {
		ModelAndView model = new ModelAndView("main");
		return model;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String check_details(@Valid @ModelAttribute("user") user_login user,BindingResult result,HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "main";
		}
		userDao.create_table_users();
		if (userDao.check(user) == 1) {
			//ModelAndView model = new ModelAndView("account");
			String name = userDao.getUserName(user.getPhone_no());
			String address = userDao.get_address(user.getPhone_no());
			String user_id = userDao.get_user_id(user.getPhone_no());
			session.setAttribute("phone_no", user.getPhone_no());
			session.setAttribute("name",name);
			session.setAttribute("user_address",address);
			session.setAttribute("user_id",user_id);
			return "redirect:home";
		} 
		else {
			//ModelAndView model = new ModelAndView("main");
			model.addAttribute("user", user);
			model.addAttribute("Msg", "Wrong Mobile Number or Password");
			return "main";
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String redirect(){
		return "redirect:/";
	}
	
//	@RequestMapping(value = "login", method = RequestMethod.GET)
//	public ModelAndView check_details_get(HttpSession session) {
//		ModelAndView model = new ModelAndView("account");
//		return model;
//	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String sign_up_success(HttpSession session,Model model){
		if((String)session.getAttribute("phone_no") == null)
			return "redirect:/";
		item_prices prices = new item_prices();
		model.addAttribute("prices",prices);
		return "account";
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView sign_up() {
		ModelAndView model = new ModelAndView("signup");
		return model;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String execute_sign_up(@Valid @ModelAttribute("user") user_signup user, BindingResult result,
			HttpSession session,Model model) {
		if (result.hasErrors()) {
			return "signup";
		} 
		else {
			userDao.create_table_users();
			if (userDao.check_user_exists(user.getPhone_no()) == 0) {
				userDao.insert(user);
				String user_id = userDao.get_user_id(user.getPhone_no());
				session.setAttribute("phone_no", user.getPhone_no());
				session.setAttribute("name", user.getName());
				session.setAttribute("user_address",user.getAddress());
				session.setAttribute("user_id",user_id);
				return "redirect:home";
			} 
			else {
				model.addAttribute("Msg", "User with that Number already exists");
				return "signup";
			}
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value="/show_details") public ModelAndView details(){
	 * List<user> list = userDao.show(); ModelAndView model = new
	 * ModelAndView("details"); model.addObject("list",list); return model; }
	 */
}
