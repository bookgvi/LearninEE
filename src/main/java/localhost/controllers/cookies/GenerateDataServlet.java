package localhost.controllers.cookies;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "GenerateDataServlet", urlPatterns = "/generate-data")
public class GenerateDataServlet extends HttpServlet {
  @Override
  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Optional<Cookie> cookies = Arrays.stream(req.getCookies())
        .filter(item -> AddDataTypeToCookieServlet.dataTypeKey.equals(item.getName()))
        .findAny();
    if (cookies.isPresent()) {
      resp.setContentType("text/html");
      resp.getWriter().printf("data-type: %s, value: %s_%s%n", cookies.get().getValue(), cookies.get().getValue(), Math.round((Math.random() + 1) * 100));
      resp.getWriter().println("<a href='/remove-data'>Remove cookie</a>");
    } else {
      RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
      rd.forward(req, resp);
    }
  }
}
