package localhost.controllers;

import services.getMessage.IMessage;
import services.utils.ISerialize;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(urlPatterns = "/message/*", name = "MessageServlet")
public class MessageController extends HttpServlet {
  @Inject
  private IMessage message;
  @Inject
  ISerialize serialize;

  @Override
  public void init () {
    System.out.println("Servlet init...");
  }

  @Override
  public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
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
    resp.setContentType("application/json");
    resp.setCharacterEncoding("utf-8");

    JsonObjectBuilder paramsBuilder = Json.createBuilderFactory(req.getParameterMap()).createObjectBuilder();
    JsonObject params = serialize.mapToJson(req.getParameterMap(), paramsBuilder, 0);
    JsonObject respBody = Json.createObjectBuilder()
        .add("contextPath", req.getContextPath())
        .add("servletPath", req.getServletPath())
        .add("pathInfo", req.getPathInfo())
        .add("parameterMap", params)
        .add("name", req.getParameter("name"))
        .add("parmeterNames", String.valueOf(req.getParameterNames()))
        .add("note", Json.createArrayBuilder(Arrays.asList(req.getParameterValues("note"))))
        .add("reqAttrName", String.valueOf(req.getAttribute("reqAttrName")))
        .add("content-type", req.getHeader("content-type"))
        .build();
    resp.getWriter().write(String.valueOf(respBody));
  }
}
