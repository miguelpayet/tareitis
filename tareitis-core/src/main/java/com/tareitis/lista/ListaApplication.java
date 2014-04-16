package com.tareitis.lista;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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

	private final MiShiroBundle<ListaConfiguration> shiro = new MiShiroBundle<ListaConfiguration>() {};

	public String getName() {
		return "lista";
	}

	public void initialize(Bootstrap<ListaConfiguration> bootstrap) {
		bootstrap.addBundle(this.hibernate);
		bootstrap.addBundle(this.shiro);
	}

	public void run(ListaConfiguration configuration, Environment environment) {
		TareaDAO tareaDAO = new TareaDAO(this.hibernate.getSessionFactory());
		ListaResource resource = new ListaResource(tareaDAO);
		environment.jersey().register(resource);
	}
}