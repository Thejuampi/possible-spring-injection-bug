package example.injection_bug.doesnt_work;

import example.injection_bug.Form;
import example.injection_bug.Pet;
import example.injection_bug.Presenter;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PetForm implements Form<Pet> {

  Pet model = new Pet(2L, "Hugo");

  private final Presenter<Pet> presenter;

  public PetForm(@Lazy Presenter<Pet> presenter) {
    this.presenter = presenter;
  }

  @Override
  public Pet model() {
    return model;
  }

  @Override
  public void setModel(Pet pet) {
    this.model = pet;
  }

}
