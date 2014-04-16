package com.tareitis.lista;

import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ListaApplication extends Application<ListaConfiguration> {
	private final HibernateBundle<ListaConfiguration> hibernateBundle = new ListaApplication();
	private final MiShiroBundle<ListaConfiguration> shiro = new ListaApplication(this);

	public static void main(String[] args) throws Exception {
		new ListaApplication().run(args);
	}

	public String getName() {
		return "lista";
	}

	public void initialize(Bootstrap<ListaConfiguration> bootstrap) {
		bootstrap.addBundle(this.hibernateBundle);
		bootstrap.addBundle(this.shiro);
	}

	public void run(ListaConfiguration configuration, Environment environment) {
		TareaDAO tareaDAO = new TareaDAO(this.hibernateBundle.getSessionFactory());
		ListaResource resource = new ListaResource(tareaDAO);
		environment.jersey().register(resource);
	}
}