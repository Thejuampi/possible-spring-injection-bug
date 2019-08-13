package example.injection_bug.doesnt_work;

import example.injection_bug.Form;
import example.injection_bug.Person;
import example.injection_bug.Presenter;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PersonForm implements Form<Person> {

  Person model = new Person(1L, "pepe");

  private final Presenter<Person> presenter;

  public PersonForm(@Lazy Presenter<Person> presenter) {
    this.presenter = presenter;
  }

  @Override
  public Person model() {
    return model;
  }

  @Override
  public void setModel(Person person) {
    this.model = person;
  }

}
