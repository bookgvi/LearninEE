package services.utils;

import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Map;

@RequestScoped
public class Serialize implements ISerialize {
  @Override
  public JsonObject mapToJson (Map<String, ?> map, JsonObjectBuilder objectBuilder, int indexOfItemInMap) {
    if (indexOfItemInMap < map.size()) {
      String key = (String) map.keySet().toArray()[indexOfItemInMap];
      return mapToJson(map, objectBuilder.add(key, String.valueOf(map.get(key))), indexOfItemInMap + 1);
    }
    return objectBuilder.build();
  }
}
