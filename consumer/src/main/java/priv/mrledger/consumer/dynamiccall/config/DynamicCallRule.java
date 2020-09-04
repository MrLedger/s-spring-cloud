package priv.mrledger.consumer.dynamiccall.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class DynamicCallRule extends AbstractLoadBalancerRule {

    public String selectId = "192.168.199.227:5010";

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object o) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getCanonicalHostName());
            System.out.println(localHost.getHostName());
            System.out.println(getServerIp());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        for (Server server : allServers) {
            if (selectId.equals(server.getId())) {
                return server;
            }
        }
        return allServers.get(0);
    }

    public String getServerIp() {
        String serverIP = null;
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                ip = ni.getInetAddresses().nextElement();
                serverIP = ip.getHostAddress();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    serverIP = ip.getHostAddress();
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return serverIP;
    }

}
