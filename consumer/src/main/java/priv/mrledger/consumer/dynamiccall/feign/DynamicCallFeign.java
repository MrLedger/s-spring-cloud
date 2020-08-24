package priv.mrledger.consumer.dynamiccall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "app-provider", path = "/dynamicCall")
public interface DynamicCallFeign {

	@GetMapping("/msg")
	String msg();

}
