package com.wbtang.service.member.config;

import com.wbtang.common.exception.BaseException;
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
@ComponentScan(basePackages = "com.wbtang.api")
@Import(BaseException.class)
public class BeanConfig {
}
