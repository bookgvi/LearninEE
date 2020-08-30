package localhost.controllers;

import services.getMessage.IMessage;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/message")
public class MessageController extends HttpServlet {
  @Inject private IMessage message;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String msg = "Hello, RESTfull";
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("message.get(msg)QQQ");
  }
}
