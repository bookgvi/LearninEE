package requestCounter;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestCounter implements ICounter {
  private Integer requestCounter = 1;

  public RequestCounter () {
  }

  public Integer getCount () {
    return requestCounter;
  }

  public void increaseCount () {
    ++requestCounter;
  }
}
