package localhost.controllers;

import requestCounter.ICounter;
import requestCounter.RequestCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/404")
public class NotFoundController extends HttpServlet {
  @Override
  public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    Integer requestCounter = 1;

//    getServletContext().getRequestDispatcher("/message").forward(request, response);
//    response.sendRedirect(request.getContextPath() + "/message");
    response.setStatus(418);

    ICounter counter = (ICounter) getServletContext().getAttribute("QQQ");
    if (counter == null) getServletContext().setAttribute("QQQ", new RequestCounter());
    else {
      counter.increaseCount();
      requestCounter = counter.getCount();
    }

    response.getWriter().write(
        requestCounter
            + ". "
            + request.getMethod()
            + ": "
            + "404 - Not Found"
    );
  }
}
