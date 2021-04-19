package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping(value = "form",method = RequestMethod.GET)
	public ModelAndView getLoginForm(ModelAndView mv) {
		LoginBean lfb=new LoginBean();
		mv.setViewName("login");
		mv.addObject("lfb", lfb);
		return mv;
	}
	
	
	@RequestMapping(value = "submitform",method = RequestMethod.POST)
	public ModelAndView submitLoginForm(LoginBean lfb,ModelAndView mv) {
		System.out.println(lfb.getUsername());
		mv.setViewName("welcome");
		mv.addObject("lfb", lfb);
		return mv;
	}

}
