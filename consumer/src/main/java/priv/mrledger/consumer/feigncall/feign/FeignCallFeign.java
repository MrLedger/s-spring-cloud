package priv.mrledger.consumer.feigncall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "app-provider", path = "/feignCall")
public interface FeignCallFeign {

	@PostMapping("/fun1")
	String fun1(String name);

}
