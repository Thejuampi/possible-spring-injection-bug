package example.injection_bug.doesnt_work;

import example.injection_bug.Pet;
import example.injection_bug.Presenter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("petPresenterNotWorking")
@Scope(SCOPE_PROTOTYPE)
public class PetPresenter
    implements Presenter<Pet> {

  private final DefaultPresenter<Pet> delegate;

  public PetPresenter(DefaultPresenter<Pet> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void onSave() {
    delegate.onSave();
  }

  @Override
  public void init(Pet pet) {

  }
}
