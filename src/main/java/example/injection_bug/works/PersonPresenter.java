package example.injection_bug.works;

import example.injection_bug.Form;
import example.injection_bug.ModelRepo;
import example.injection_bug.Person;
import example.injection_bug.Presenter;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Primary
public class PersonPresenter implements Presenter<Person> {

  private final ModelRepo<Person> repo;

  private final Form<Person> form;

  public PersonPresenter(ModelRepo<Person> repo,
                         Form<Person> form) {
    this.repo = repo;
    this.form = form;
  }

  @Override
  public void onSave() {
    final var model = form.model();
    repo.save(model);
  }

  @Override
  public void init(Person person) {
    form.setModel(person);
  }
}
