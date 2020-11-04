package EJB.LocalWithResource;

import javax.ejb.Local;
import javax.ejb.LocalBean;

@Local(LocalInterface.class)
@LocalBean
public class Bean implements LocalInterface {
  @Override
  public String getSomeText() {
    return null;
  }
}
