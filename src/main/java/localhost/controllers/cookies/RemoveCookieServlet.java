package localhost.controllers.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "RemoveCookie", urlPatterns = "/remove-data")
public class RemoveCookieServlet extends HttpServlet {
  @Override
  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Optional<Cookie> opCookie = Arrays.stream(req.getCookies())
        .filter(item -> AddCookieServlet.dataTypeKey.equals(item.getName()))
        .findAny();
    if (opCookie.isPresent()) {
      opCookie.get().setMaxAge(0);
      resp.addCookie(opCookie.get());
      resp.sendRedirect("/index.jsp");
    }
  }
}
