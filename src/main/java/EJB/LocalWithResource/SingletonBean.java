package EJB.LocalWithResource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class SingletonBean {
  private SingletonBean instance;
  private ConcurrentHashMap<String, Map<String, Object>> cache = new ConcurrentHashMap<>();
  private final ThreadLocal<AtomicReference<String>> ACTIVE_SCOPE_THREAD_LOCAL = ThreadLocal.withInitial(AtomicReference::new);
  private SingletonBean() {
  }

  public SingletonBean getInstance() {
    if (this.instance == null)
      this.instance = new SingletonBean();
    return this.instance;
  }
}
