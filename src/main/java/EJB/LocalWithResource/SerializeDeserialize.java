package EJB.LocalWithResource;

import com.google.gson.Gson;

import javax.ejb.Stateless;
import java.util.Map;

@Stateless
public class SerializeDeserialize {
  public String jsonSerialize(Map<?, ?> map) {
    Gson gson = new Gson();
    String jsonObject = gson.toJson(map);
    return jsonObject;
  }
}
