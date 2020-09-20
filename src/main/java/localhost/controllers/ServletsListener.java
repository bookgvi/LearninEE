package localhost.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.logging.Logger;

@WebListener()
public class ServletsListener implements ServletContextListener, ServletContextAttributeListener,
    HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

  private static final Logger log = Logger.getLogger("learningEE.web.messageServlet");

  @Override
  public void requestInitialized (ServletRequestEvent sre) {
    ServletRequest sreq = sre.getServletRequest();
    sreq.setAttribute("reqAttrName", "reqAttrValue");
    sreq.setAttribute("protocol", sreq.getProtocol());
    sreq.setAttribute("schema", sreq.getScheme());
  }

  @Override
  public void contextInitialized(ServletContextEvent ctx) {
    ServletContext sc = ctx.getServletContext();
    Map<String, ? extends ServletRegistration> servletRegistrations = sc.getServletRegistrations();

    // Creating DynamicController
    ServletRegistration sr = sc.addServlet("DynamicServlet", "localhost.controllers.DynamicController");
    sr.setInitParameter("initParam1", "initParam1Value");
    sr.setInitParameter("initParam2", String.valueOf(servletRegistrations));
    sr.addMapping("/dynamic");

    // Creating DynamicController #2
    try {
      DynamicController2 dc2 = sc.createServlet(DynamicController2.class); // try...catch because of this method - <T extends Servlet> T createServlet(Class<T> var1) throws ServletException;
      ServletRegistration sr2 = sc.addServlet("DynamicServlet2", dc2);
      sr2.setInitParameter("initParam1", "QQQ");
      sr2.addMapping("/dynamic2");
    } catch (ServletException se) {
      throw new IllegalStateException(se);
    }
  }

  @Override
  public void sessionCreated (HttpSessionEvent se) {

  }
}
