package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author lizhe
 * @date 2021-04-14 21:33
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain9001.class,args);
    }
}
