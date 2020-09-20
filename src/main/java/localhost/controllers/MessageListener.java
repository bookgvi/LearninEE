package localhost.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener()
public class MessageListener implements ServletContextListener, ServletContextAttributeListener,
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
  }

  @Override
  public void sessionCreated (HttpSessionEvent se) {

  }
}
