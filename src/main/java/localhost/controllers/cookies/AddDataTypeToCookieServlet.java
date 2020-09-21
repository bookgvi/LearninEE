package localhost.controllers.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DataTypeToCookie", urlPatterns = "/save-data")
public class AddDataTypeToCookieServlet extends HttpServlet {
  public static String dataTypeKey = "data-type";
  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String dataTypeValue = req.getParameter(dataTypeKey);
    if (dataTypeValue != null) {
      Cookie cookie = new Cookie(dataTypeKey, dataTypeValue);
      // 7 days
      cookie.setMaxAge(7 * 24 * 60 * 60);
      resp.addCookie(cookie);
    }
    resp.sendRedirect("/generate-data");
  }
}
