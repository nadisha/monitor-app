package com.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebConfig.class, ServiceConfig.class, RepositoryConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?> [] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
