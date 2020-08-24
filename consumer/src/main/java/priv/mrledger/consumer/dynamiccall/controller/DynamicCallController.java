package priv.mrledger.consumer.dynamiccall.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mrledger.consumer.dynamiccall.feign.DynamicCallFeign;

import java.util.List;
import java.util.Map;

@RequestMapping("/dynamicCall")
@RestController
public class DynamicCallController {

	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	DynamicCallFeign dynamicCallFeign;

	@GetMapping("/allServiceList")
	public Map<String, List<ServiceInstance>> allServiceList() {
		Map<String, List<ServiceInstance>> serviceMap = Maps.newHashMap();
		for (String serviceName : discoveryClient.getServices()) {
			serviceMap.put(serviceName, discoveryClient.getInstances(serviceName));
		}
		return serviceMap;
	}

	@GetMapping("/msg")
	public String msg() {
		return dynamicCallFeign.msg();
	}

}
