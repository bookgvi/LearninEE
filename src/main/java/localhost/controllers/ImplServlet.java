package localhost.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/msg")
public class ImplServlet implements Servlet {
  Logger log = Logger.getLogger("msg.logger");
  @Override
  public void init (ServletConfig servletConfig) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig () {
    return null;
  }

  @Override
  public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    log.log(Level.INFO, "service", servletRequest.getServletContext());
  }

  @Override
  public String getServletInfo () {
    return null;
  }

  @Override
  public void destroy () {

  }
}
