package EJB.Consumers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="consumer")
public class ConsumerXML {
  @XmlElement public int id;
  @XmlElement public String firstName;
  @XmlElement public String lastName;
  @XmlElement public String email;
}
