package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class DemoContoller {
	@Autowired
	private MyBusinessComponent business;
	
	@RequestMapping(value = "get1",method = RequestMethod.GET)
	public void helloTest() {
		System.out.println("Hello test 1 called...");

	}
	
	@RequestMapping(value = "get2",method = RequestMethod.GET)
	public void helloTest2() {
		System.out.println("Hello test 2 called...");

	}
	
	@RequestMapping(value="hello3", method = RequestMethod.GET)
	public String sayHello3() {
		System.out.println("Welcome to Spring MVC....");
		return "welcome";
	}
	
	@RequestMapping(value="hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		System.out.println("Welcome to Spring MVC....");
		Employee emp=business.doBusiness();
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("welcome");
		mandv.addObject("hello","hello world hello world...");
		mandv.addObject("emp",emp);
		return mandv;
	}

}
