package localhost.controllers.errorDispatcher;

import javax.servlet.*;
import java.io.IOException;

public class ExceptionFilter implements Filter {
  @Override
  public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    filterChain.doFilter(servletRequest, servletResponse);
    Exception exception = (Exception) servletRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    String request_uri = (String) servletRequest.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
    servletResponse.getWriter().printf("\nException: %s%n", exception);
    servletResponse.getWriter().printf("request uri: %s%n", request_uri);
  }
}
