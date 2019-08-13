package example.injection_bug;

public class Person implements HasId {

  public Person(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  Long id;

  String name;

  @Override
  public Long getId() {
    return this.id;
  }

}
