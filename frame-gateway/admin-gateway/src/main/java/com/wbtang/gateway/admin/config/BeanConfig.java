package com.wbtang.gateway.admin.config;

import com.wbtang.common.exception.BaseException;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 公共配置加载类
 *
 * @author TangWenBo
 * @date 2019/12/23
 */
@Configuration
@Import(BaseException.class)
@ComponentScan(basePackages = "com.wbtang.api")
@EnableFeignClients("com.wbtang.api")
public class BeanConfig {
}
