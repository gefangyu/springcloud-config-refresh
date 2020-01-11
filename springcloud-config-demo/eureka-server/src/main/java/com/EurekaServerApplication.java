/**
 * Description: 
 * @package com
 * @classname ZbookEurekaServerApplication.java
 * @copyright 咪咕音乐有限公司
 * @date 2018年6月22日
 * @time 上午12:44:27
 * @author ge.fangyu
 * @version 1.0
 */ 

package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心服务.
 * Description: https://blog.csdn.net/wtdm_160604/article/details/83720391
 * @copyright
 * @date 2018年6月22日
 * @time 上午12:44:27
 * @author ge.fangyu
 * @version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
