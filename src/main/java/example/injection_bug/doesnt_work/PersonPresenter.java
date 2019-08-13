package example.injection_bug.doesnt_work;

import example.injection_bug.Person;
import example.injection_bug.Presenter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("personPresenterNotWorking")
@Scope(SCOPE_PROTOTYPE)
public class PersonPresenter
    implements Presenter<Person> {

  private final DefaultPresenter<Person> delegated;

  public PersonPresenter(DefaultPresenter<Person> delegated) {
    this.delegated = delegated;
  }

  @Override
  public void onSave() {
    delegated.onSave();
  }

  @Override
  public void init(Person person) {

  }
}
