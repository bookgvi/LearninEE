package EJB.LocalWithResource;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Local(LocalInterface.class)
@Stateful
@StatefulTimeout(value = 5)
public class StatefulBean implements LocalInterface {
  @Override
  public String getSomeText() {
    return null;
  }

  @Remove
  public void finish() {
    System.out.print("The end of session...");
  }
}
