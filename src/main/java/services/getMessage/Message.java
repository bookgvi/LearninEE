package services.getMessage;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Message implements IMessage {
  public Message () {
  }

  public String get (String msg) {
    return msg;
  }
  public String get () {
    return "This is get message service";
  }
}
