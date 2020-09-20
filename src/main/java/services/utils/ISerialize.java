package services.utils;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Map;

public interface ISerialize {
  JsonObject mapToJson(Map<String, ?> map, JsonObjectBuilder objectBuilder, int indexOfItemInMap);
  JsonObject mapToJson(Map<String, ?> map);
}
