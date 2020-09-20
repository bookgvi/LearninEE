package localhost.controllers;

import services.getMessage.IMessage;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/message/*")
public class MessageController extends HttpServlet {
  @Inject
  private IMessage message;

  @Override
  public void init() {
    System.out.println("Servlet init...");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String contextPath = request.getContextPath();
    String servletPath = request.getServletPath();
    String pathInfo = request.getPathInfo();
    String msg = "Hello, RESTfull";
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(String.valueOf(-2 >> 1) + "\n");
    response.getWriter().write(contextPath);
    response.getWriter().write(servletPath);
    response.getWriter().write(pathInfo + "\n");
  }

  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().write(req.getContextPath() + "\n");
    resp.getWriter().write(req.getServletPath() + "\n");
    resp.getWriter().write(req.getPathInfo() + "\n");
    resp.getWriter().write(req.getParameterMap() + "\n");
    resp.getWriter().write(req.getParameter("name") + "\n");
    resp.getWriter().write(req.getParameterNames() + "\n");
    resp.getWriter().write(Arrays.toString(req.getParameterValues("note")) + "\n");
    resp.getWriter().write(req.getAttributeNames() + "\n");
    resp.getWriter().write(req.getHeader("content-type") + "\n");
  }

  protected synchronized void enterringServiceMethod() {}
}
