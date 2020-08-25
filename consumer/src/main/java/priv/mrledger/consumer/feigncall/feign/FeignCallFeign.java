package priv.mrledger.consumer.feigncall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import priv.mrledger.starter.common.dto.Person;

@FeignClient(value = "app-provider", path = "/feignCall")
public interface FeignCallFeign {

	@PostMapping("/body")
	String fun1(String name);

	@PostMapping("/params")
	String fun2(@RequestParam String name, @RequestParam int age);

	@PostMapping("/body")
	String fun3(Person person);

}
