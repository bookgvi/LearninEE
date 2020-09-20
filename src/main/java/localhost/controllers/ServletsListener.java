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
  }

  @Override
  public void contextInitialized(ServletContextEvent ctx) {
    ServletContext sc = ctx.getServletContext();
    ServletRegistration sr = sc.addServlet("DynamicServlet", "localhost.controllers.DynamicController");
    Map<String, ? extends ServletRegistration> servletRegistrations = sc.getServletRegistrations();
    sr.setInitParameter("initParam1", "initParam1Value");
    sr.setInitParameter("initParam2", String.valueOf(servletRegistrations));
    sr.addMapping("/dynamic");
  }

  @Override
  public void sessionCreated (HttpSessionEvent se) {

  }
}
