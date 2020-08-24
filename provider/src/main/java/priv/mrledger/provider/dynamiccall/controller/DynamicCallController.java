package priv.mrledger.provider.dynamiccall.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dynamicCall")
@RestController
public class DynamicCallController {

	@Value("${s-spring-cloud.dynamic-call.msg}")
	String msg;

	@GetMapping("/msg")
	public String msg() {
		return msg;
	}

}
