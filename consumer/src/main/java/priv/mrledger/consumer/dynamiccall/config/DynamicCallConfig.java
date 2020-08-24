package priv.mrledger.consumer.dynamiccall.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RibbonClients
@Configuration
public class DynamicCallConfig {

	@ConditionalOnProperty(prefix = "s-spring-cloud.dynamic-call", value = "enabled", havingValue = "true")
	@Bean
	public IRule dynamicCall() {
		return new DynamicCallRule();
	}

}
