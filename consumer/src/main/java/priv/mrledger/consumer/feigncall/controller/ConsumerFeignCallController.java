package priv.mrledger.consumer.feigncall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mrledger.consumer.feigncall.feign.FeignCallFeign;

@RequestMapping("/feignCall")
@RestController
public class ConsumerFeignCallController {

	@Autowired
	FeignCallFeign feignCallFeign;

	@GetMapping("/fun1")
	public String fun1(String name) {
		System.out.println(name);
		return feignCallFeign.fun1(name);
	}

}
