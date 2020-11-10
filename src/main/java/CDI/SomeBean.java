package CDI;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SomeBean implements Bean {
  @Override
  public Class<?> getBeanClass() {
    List<Bean> beans = Collections.emptyList();
    return null;
  }

  @Override
  public Set<InjectionPoint> getInjectionPoints() {
    return null;
  }

  @Override
  public boolean isNullable() {
    return false;
  }

  @Override
  public Object create(CreationalContext creationalContext) {
    return null;
  }

  @Override
  public void destroy(Object o, CreationalContext creationalContext) {

  }

  @Override
  public Set<Type> getTypes() {
    return null;
  }

  @Override
  public Set<Annotation> getQualifiers() {
    return null;
  }

  @Override
  public Class<? extends Annotation> getScope() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Set<Class<? extends Annotation>> getStereotypes() {
    return null;
  }

  @Override
  public boolean isAlternative() {
    return false;
  }
}
