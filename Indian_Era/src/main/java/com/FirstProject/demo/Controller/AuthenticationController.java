package com.FirstProject.demo.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.FirstProject.demo.Model.User;
import com.FirstProject.demo.Services.UserService;


@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}
     
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); // resources/template/login.html
		return modelAndView;
	}
	
	@GetMapping ("/admin")
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "user already exists!");			
		}
		// we will save the user if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}


	@RequestMapping("blog")
	public String blog()
	{
		return "blog";
	}

	@RequestMapping("blog-details")
	public String blogdetails()
	{
		return "blog-details";
	}

	@RequestMapping("shopping-cart")
	public String shoppingcart()
	{
		return "shopping-cart";
	}
	
	@RequestMapping("product")
	public String product()
	{
		return "product";
	}
	
	@RequestMapping("check-out")
	public String checkout()
	{
		return "check-out";
	}
	
	@RequestMapping("shop")
	public String shop()
	{
		return "shop";
	}
	
	@RequestMapping("faq")
	public String faq()
	{
		return "faq";
	}

}










