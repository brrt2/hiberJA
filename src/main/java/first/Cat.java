package first;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Cat {

  @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @OneToOne(mappedBy = "cat")
  private Owner owner;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
