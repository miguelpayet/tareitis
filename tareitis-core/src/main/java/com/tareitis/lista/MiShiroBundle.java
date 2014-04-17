package com.tareitis.lista;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.jetty.setup.ServletEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.eclipse.jetty.server.session.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MiShiroBundle<T extends Configuration> implements ConfiguredBundle<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaResource.class);

	public void initialize(Bootstrap<?> bootstrap) {
		System.out.println("MiShiroBundle.initialize");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = (SecurityManager) factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
	}

	public void run(ListaConfiguration configuration, Environment environment) throws Exception {
		LOGGER.info("MiShiroBundle.run");
		ServletEnvironment e = environment.servlets();
		e.addServletListeners(new EnvironmentLoaderListener());
		e.setSessionHandler(new SessionHandler());
		e.addFilter("shiro-filter", new ShiroFilter()).addMappingForUrlPatterns(
				EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, new String[] { "/*" });
	}
}