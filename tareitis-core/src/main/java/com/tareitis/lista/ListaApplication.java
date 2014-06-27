package com.tareitis.lista;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;

public class ListaApplication extends Application<ListaConfiguration> {

	public static void main(String[] args) throws Exception {
		new ListaApplication().run(args);
	}

	private final HibernateBundle<ListaConfiguration> hibernate = new HibernateBundle<ListaConfiguration>(Lista.class,
			Tarea.class) {
		public DataSourceFactory getDataSourceFactory(ListaConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	private final MiShiroBundle<ListaConfiguration> shiro = new MiShiroBundle<ListaConfiguration>() {
	};

	public String getName() {
		return "lista";
	}

	public void initialize(Bootstrap<ListaConfiguration> bootstrap) {
		bootstrap.addBundle(this.hibernate);
		bootstrap.addBundle(this.shiro);
	}

	public void addCORSFilter(Environment environment) {
		Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
		filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
		filter.setInitParameter("allowedOrigins", "*");
		filter.setInitParameter("allowedHeaders",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
		filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS");
		filter.setInitParameter("preflightMaxAge", "5184000");
		filter.setInitParameter("allowCredentials", "true");
	}

	public void run(ListaConfiguration configuration, Environment environment) {
		environment.servlets().addFilter("CrossDomainFilter", new MiCrossDomainFilter())
				.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
		TareaDAO tareaDAO = new TareaDAO(this.hibernate.getSessionFactory());
		ListaResource listaResource = new ListaResource(tareaDAO);
		environment.jersey().register(listaResource);
		LoginResource loginResource = new LoginResource();
		environment.jersey().register(loginResource);
	}
}