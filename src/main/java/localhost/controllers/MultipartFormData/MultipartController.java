package localhost.controllers.MultipartFormData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(
    maxFileSize = 1024 * 1024 * 5,
    maxRequestSize = 1024 * 1024 * 5 * 5,
    fileSizeThreshold = 1024 * 1024,
    location = ""
)
@WebServlet(name = "multipartController", urlPatterns = "/upload")
public class MultipartController extends HttpServlet {
  @Override
  protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    for (Part part : req.getParts()) {
      part.write(part.getName());
      printPartHeader(part, resp.getWriter());
    }
  }

  private void printPartHeader(Part part, PrintWriter writer) {
    for (String headerName : part.getHeaderNames()) {
      writer.println(headerName + " " + part.getHeader(headerName));
    }
  }
}
