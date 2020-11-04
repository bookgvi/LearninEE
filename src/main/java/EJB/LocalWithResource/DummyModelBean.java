package EJB.LocalWithResource;

import javax.ejb.EJB;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DummyModelBean {
  private static DummyModelBean instance;
  private Map<Integer, String> dummyMap = new ConcurrentHashMap<>();
  private AtomicInteger id = new AtomicInteger();

  @EJB
  SerializeDeserialize serializeDeserialize;

  private DummyModelBean() {
  }

  public static DummyModelBean getInstance() {
    if (DummyModelBean.instance == null)
      DummyModelBean.instance = new DummyModelBean();
    return DummyModelBean.instance;
  }

  public Map<Integer, String> setMsg(String msg) {
    int id = this.id.incrementAndGet();
    this.dummyMap.put(id, msg);
    Map<Integer, String> currentObj = new HashMap<>();
    currentObj.put(id, msg);
    return currentObj;
  }
  public String getByIdMsg(int id) {
    return this.dummyMap.get(id);
  }

  public ConcurrentHashMap<Integer, String> getDummyMap() {
    return (ConcurrentHashMap<Integer, String>) dummyMap;
  }

}
