package localhost.controllers.LearningSessionScope.Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    ServletRegistration sr = sc.addServlet("SessionServlet", SessionServlet.class);
    sr.addMapping("/session");
    System.out.printf("contextInitialized: %s%n", sc);
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    session.setMaxInactiveInterval(5);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.out.println("-- Session destroyed --");
  }
}
