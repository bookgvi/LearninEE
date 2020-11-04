package localhost.controllers.LearningSessionScope.Servlets;

import localhost.controllers.LearningSessionScope.Beans.SessionScopeBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class SessionServlet extends HttpServlet {
  @Inject
  SessionScopeBean sessionScopeBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Writer w = resp.getWriter();
    resp.setContentType("text/html");
    w.write("Hello!!!");
  }
}
