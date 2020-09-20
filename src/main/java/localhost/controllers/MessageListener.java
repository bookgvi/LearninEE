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
  public void contextInitialized(ServletContextEvent ctx) {
    log.log(Level.INFO, "QQQ", ctx.getServletContext());
    System.out.println("Context!!!!!!!!!!!!!!!!!");
  }

  @Override
  public void sessionCreated (HttpSessionEvent se) {

  }
}
