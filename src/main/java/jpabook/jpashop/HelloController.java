package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(ModelAndView mav){
		mav.addObject("data", "HELLO");
		return "hello";
	}
}
