package localhost.controllers.errorDispatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.EnumSet;

@WebListener
public class Listener implements ServletContextListener {
  @Override
  public void contextInitialized (ServletContextEvent sce) {
    ServletContext ctx = sce.getServletContext();
    try {
      ExceptionFilter ef = ctx.createFilter(ExceptionFilter.class);
      GenerateExcaptionServlet es = ctx.createServlet(GenerateExcaptionServlet.class);

      /*
      * Registration of filter for Errors
      * */
      FilterRegistration registration = ctx.addFilter("errorFilter", ef);
      EnumSet<DispatcherType> dts = EnumSet.of(DispatcherType.ERROR);
      registration.addMappingForUrlPatterns(dts, false, "/*");

      /*
      * Registration of servlet - error generator
      * */
      ServletRegistration sr = ctx.addServlet("errorServlet", es);
      sr.addMapping("/error");

    } catch (ServletException se) {
      throw new IllegalStateException(se);
    }
  }
}
