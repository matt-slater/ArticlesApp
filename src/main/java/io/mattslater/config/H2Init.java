package io.mattslater.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Init {
	@Bean
	public ServletRegistrationBean h2Servlet() {
		ServletRegistrationBean servletBean = new ServletRegistrationBean();
		servletBean.addUrlMappings("/h2/*"); 
		servletBean.setServlet(new WebServlet());
		return servletBean;
	}

}
