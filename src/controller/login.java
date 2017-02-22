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

import classes.ItempPrices;
import classes.UserLogin;
import classes.UserSignup;
import dao.OrderDetailsDao;
import dao.UserDao;
import security.PasswordHashing;

@Controller
// @SessionAttributes("user_session")
public class Login {

	@Autowired
	UserDao userDao;

	@Autowired
	OrderDetailsDao orderDao;
	
	@RequestMapping(value = "/")
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("main");
		return model;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String checkDetails(@Valid @ModelAttribute("user") UserLogin user,BindingResult result,HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "main";
		}
		userDao.createTableUsers();
		try{
			user.setPassword(PasswordHashing.hash(user.getPassword()));
		}
		catch(Exception e){
			
		}
		if (userDao.check(user) == 1) {
			String name = userDao.getUserName(user.getPhoneNo());
			String address = userDao.getAddress(user.getPhoneNo());
			String userId = userDao.getUserId(user.getPhoneNo());
			session.setAttribute("phoneNo", user.getPhoneNo());
			session.setAttribute("name",name);
			session.setAttribute("userAddress",address);
			session.setAttribute("userId",userId);
			return "redirect:home";
		} 
		else {
			model.addAttribute("user", user);
			model.addAttribute("Msg", "Wrong Mobile Number or Password");
			return "main";
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String redirect(){
		return "redirect:/";
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String signupSuccess(HttpSession session,Model model){
		if((String)session.getAttribute("phoneNo") == null)
			return "redirect:/";
		ItempPrices prices = new ItempPrices();
		model.addAttribute("prices",prices);
		return "account";
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("signup");
		return model;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String executeSignup(@Valid @ModelAttribute("user") UserSignup user, BindingResult result,
			HttpSession session,Model model) {
		if (result.hasErrors()) {
			return "signup";
		} 
		else {
			try{
				user.setPassword(PasswordHashing.hash(user.getPassword()));
			}
			catch(Exception e){
				
			}
			userDao.createTableUsers();
			if (userDao.checkUserExists(user.getPhoneNo()) == 0) {
				userDao.insert(user);
				String userId = userDao.getUserId(user.getPhoneNo());
				session.setAttribute("phoneNo", user.getPhoneNo());
				session.setAttribute("name", user.getName());
				session.setAttribute("userAddress",user.getAddress());
				session.setAttribute("userId",userId);
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

}
