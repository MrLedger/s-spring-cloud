package priv.mrledger.provider.feigncall.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/feignCall")
@RestController
public class ProviderFeignCallController {

	@PostMapping("/fun1")
	public String fun1(@RequestBody String name) {
		System.out.println(name);
		return name;
	}

}
