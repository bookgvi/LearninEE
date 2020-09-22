package localhost.controllers.miltiPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MultiPathController extends HttpServlet {
  @Override
  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().printf("Current path = %s%n", req.getServletPath());
    resp.getWriter().printf("Current RequestURI = %s%n", req.getRequestURI());
  }
}
