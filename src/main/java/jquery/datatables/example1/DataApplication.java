package jquery.datatables.example1;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import jquery.datatables.example1.contoller.DataTableServlet;
import jquery.datatables.example2.controller.AddData;
import jquery.datatables.example2.controller.CompanyDataTableAjaxDataSourceServlet;
import jquery.datatables.example2.controller.DeleteData;
import jquery.datatables.example2.controller.UpdateData;

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

        //jquery datatable
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/example1.jsp", "/example1.jsp", null, "example1"));
        //plugin Edittable
        bootstrap.addBundle(new AssetsBundle("/assets/media", "/media", null, "media"));
        bootstrap.addBundle(new AssetsBundle("/assets/scripts", "/scripts", null, "scripts"));
        bootstrap.addBundle(new AssetsBundle("/assets/example2.jsp", "/example2.jsp", null, "example2"));

    }

    @Override
    public void run(DataConfiguration dataConfiguration, Environment environment) throws Exception {

        //jquery datatable
        environment.servlets().addServlet("DataTableServlet", new DataTableServlet()).addMapping("/DataTableServlet");
        //plugin Edittable
        environment.servlets().addServlet("AddData", new AddData()).addMapping("/AddData");
        environment.servlets().addServlet("CompanyAjaxDataSource", new CompanyDataTableAjaxDataSourceServlet()).addMapping("/CompanyAjaxDataSource");
        environment.servlets().addServlet("DeleteData", new DeleteData()).addMapping("/DeleteData");
        environment.servlets().addServlet("UpdateData", new UpdateData()).addMapping("/UpdateData");

    }
}
