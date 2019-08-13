package example.injection_bug;

public class Pet implements HasId {

  Long id;

  String name;

  public Pet(long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public Long getId() {
    return this.id;
  }

}
