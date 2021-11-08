package org.sot.project.config;

import org.sot.project.common.FileConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/08
 **/
@Configuration
public class PicConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		if (!registry.hasMappingForPattern("/static/upload/**")) {
			registry.addResourceHandler("/images/**")
				.addResourceLocations("file:" + FileConst.allFile); /*绝对路径*/
		}
		super.addResourceHandlers(registry);
	}
}
