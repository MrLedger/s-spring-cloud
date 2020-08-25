package priv.mrledger.consumer.feigncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mrledger.consumer.feigncall.feign.FeignCallFeign;
import priv.mrledger.starter.common.dto.Person;

@RequestMapping("/feignCall")
@RestController
public class ConsumerFeignCallController {

	@Autowired
	FeignCallFeign feignCallFeign;

	@GetMapping("/fun1")
	public String fun1(String name) {
		return feignCallFeign.fun1(name);
	}

	@GetMapping("/fun2")
	public String fun2(String name, Integer age) {
		return feignCallFeign.fun2(name, age);
	}

	@GetMapping("/fun3")
	public String fun3(String name, Integer age) {
		return feignCallFeign.fun3(new Person().setName(name).setAge(age));
	}

}
