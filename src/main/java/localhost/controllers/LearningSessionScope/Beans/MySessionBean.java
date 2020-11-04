package localhost.controllers.LearningSessionScope.Beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class MySessionBean implements SessionScopeBean, Serializable {
  private long serialVersionUID = 1L;

  public void preDestroyed() {
    System.out.println("QQQ");
  }
}
