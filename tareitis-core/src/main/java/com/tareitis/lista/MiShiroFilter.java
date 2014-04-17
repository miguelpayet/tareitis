package com.tareitis.lista;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiShiroFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaResource.class);

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		LOGGER.info("MiShiroFilter.doFilter");
		InputStreamReader isr = new InputStreamReader(request.getInputStream());
		String body = IOUtils.toString(isr);
		LOGGER.info(body.toString());
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}