package example.injection_bug.works;

import example.injection_bug.*;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Primary
public class PetPresenter implements Presenter<Pet> {

  private final Form<Pet> form;

  private final Repo<Pet> repo;

  public PetPresenter(Form<Pet> form,
                      Repo<Pet> repo) {
    this.form = form;
    this.repo = repo;
  }


  @Override
  public void onSave() {
    repo.save(form.model());
  }

  @Override
  public void init(Pet pet) {
    form.setModel(pet);
  }
}
