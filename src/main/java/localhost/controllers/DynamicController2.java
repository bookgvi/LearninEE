package localhost.controllers;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DynamicController2 extends HttpServlet {

  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("utf-8");

    JsonObject respBody = Json.createObjectBuilder()
        .add("ControllerName", getServletConfig().getServletName())
        .add("initParam1", getServletConfig().getInitParameter("initParam1"))
        .add("protocol", String.valueOf(req.getAttribute("protocol")))
        .add("schema", String.valueOf(req.getAttribute("schema")))
        .add("method", req.getMethod())
        .build();
    resp.getWriter().write(String.valueOf(respBody));
  }
}
