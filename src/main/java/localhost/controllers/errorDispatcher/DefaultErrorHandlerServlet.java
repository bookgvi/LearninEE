package localhost.controllers.errorDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorHandler", urlPatterns = "/default-error-handler")
public class DefaultErrorHandlerServlet extends HttpServlet {
  @Override
  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().printf("%s%n", req.getDispatcherType());
  }
}
