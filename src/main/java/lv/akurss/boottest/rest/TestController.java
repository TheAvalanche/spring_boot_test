package lv.akurss.boottest.rest;

import lv.akurss.boottest.domain.UserBean;
import lv.akurss.boottest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Value("${akurss.test}")
	String test1;
	@Value("${akurss.test2:testtest}")
	String test2;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return "I am working!";
	}
	
	@RequestMapping(path = "/test/{a}/{b}", method = RequestMethod.GET)
	public Long sum(@PathVariable("a") Long one, @PathVariable("b") Long two) {
		return one + two;
	}

	@RequestMapping(path = "/test", params = {"a", "b"}, method = RequestMethod.GET)
	public Long sum2(@RequestParam("a") Long one, @RequestParam("b") Long two) {
		return one + two;
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public String save(@RequestBody UserBean user) {
		System.out.println(user.getName());
		System.out.println(user.getSurname());
		
		testService.test();

		System.out.println(test1);
		System.out.println(test2);
		
		return "OK";
	}
	
}
