package requestCounter;

import java.io.Serializable;

public interface ICounter extends Serializable {
  Integer getCount();
  void increaseCount();
}
