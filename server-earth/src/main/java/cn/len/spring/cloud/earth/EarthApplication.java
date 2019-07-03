package cn.len.spring.cloud.earth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author len
 * 2019-07-03
 */
@EnableFeignClients("cn.len.spring.cloud.earth.feign")
@EnableDiscoveryClient
@SpringCloudApplication
public class EarthApplication {
    public static void main(String[] args) {
        SpringApplication.run(EarthApplication.class, args);
    }
}
