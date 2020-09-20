package localhost.controllers;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DynamicController extends HttpServlet {
  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("utf-8");

    JsonObject respBody = Json.createObjectBuilder()
        .add("initParam1", getServletConfig().getInitParameter("initParam1"))
        .add("ServletRegistrations", getServletConfig().getInitParameter("initParam2"))
        .add("servletPath", req.getServletPath())
        .add("reqAttrName", String.valueOf(req.getAttribute("reqAttrName")))
        .build();
    resp.getWriter().write(String.valueOf(respBody));
  }
}
