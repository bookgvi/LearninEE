package localhost.controllers.miltiPath;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;

@WebListener
public class Listener implements ServletContextListener {
  @Override
  public void contextInitialized (ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    ServletRegistration sr = sc.addServlet("MultiPartController", MultiPathController.class);
    Arrays.stream(new String[]{"/multipath1", "/multipath2"}).forEach(sr::addMapping);
    System.out.printf("contextInitialized: %s%n", sc);
  }
}
