package com.flipcard.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipcard.rest.AdminRestController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	@Override
	public void initialize(Bootstrap<Configuration> b) {
	}

	public static void main(String[] args) {
		try {
			new App().run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run(Configuration c, Environment e) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Registering REST resources");
		e.jersey().register(new AdminRestController());

	}
}
