package com.muyus.muyucloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * AccountController
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@SpringBootApplication
public class MuyuCloudApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MuyuCloudApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(MuyuCloudApplication.class, args);
	}
}
