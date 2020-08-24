package priv.mrledger.consumer.dynamiccall.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class DynamicCallRule extends AbstractLoadBalancerRule {

	public String selectId = "192.168.199.227:5010";

	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {
	}

	@Override
	public Server choose(Object o) {
		ILoadBalancer loadBalancer = getLoadBalancer();
		List<Server> allServers = loadBalancer.getAllServers();
		for (Server server : allServers) {
			if (selectId.equals(server.getId())) {
				return server;
			}
		}
		return allServers.get(0);
	}

}
