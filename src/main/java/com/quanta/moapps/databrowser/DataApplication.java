package com.quanta.moapps.databrowser;

import com.quanta.moapps.databrowser.contoller.DataTableServlet;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by anderson on 2015/2/9.
 */
public class DataApplication extends Application<DataConfiguration> {

    public static void main(String[] args) throws Exception {
        new DataApplication().run(args);
    }

    @Override
    public String getName() {
        return "moapps-databrowser";
    }

    @Override
    public void initialize(Bootstrap<DataConfiguration> bootstrap) {

        bootstrap.addBundle(new AssetsBundle("/assets/index.html", "/index.html", null, "index"));
        bootstrap.addBundle(new AssetsBundle("/assets/images", "/images", null, "images"));
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/dataTableSample.jsp", "/dataTableSample.jsp",null,"dataTableSample"));

    }

    @Override
    public void run(DataConfiguration dataConfiguration, Environment environment) throws Exception {

        environment.servlets().addServlet("DataTableServlet", new DataTableServlet()).addMapping("/DataTableServlet");

    }
}
