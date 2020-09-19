package localhost.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener()
public class MessageListener implements ServletContextListener {

  private static final Logger log = Logger.getLogger("learningEE.web.messageServlet");

  @Override
  public void contextInitialized(ServletContextEvent ctx) {
    log.log(Level.INFO, "QQQ", ctx.getServletContext());
    System.out.println("Context!!!!!!!!!!!!!!!!!");
  }
}
