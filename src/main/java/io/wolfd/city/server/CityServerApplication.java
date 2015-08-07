package io.wolfd.city.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class CityServerApplication extends Application<CityServerConfiguration> {
  public static void main(String[] args) throws Exception {
    new CityServerApplication().run(args);
  }

  @Override
  public String getName() {
    return "city-server";
  }

  @Override
  public void initialize(Bootstrap<CityServerConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(CityServerConfiguration configuration,
                  Environment environment) {
    final CityResource resource = new CityResource();
    environment.jersey().register(resource);
  }
}
