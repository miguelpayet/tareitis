package com.tareitis.lista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiShiroFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaResource.class);

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {
		LOGGER.info("MiShiroFilter.doFilter");
		PrintWriter out = arg1.getWriter();
		out.println("<b>hola</b>");
	}

	public void destroy() {
	}
}