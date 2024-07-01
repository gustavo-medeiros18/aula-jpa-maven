package domain;

import java.io.Serial;
import java.io.Serializable;

public class Pessoa implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String name;
  private String email;

  public Pessoa() {

  }

  public Pessoa(Integer id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Pessoa{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
