package example.injection_bug.doesnt_work;

import example.injection_bug.Form;
import example.injection_bug.HasId;
import example.injection_bug.Presenter;
import example.injection_bug.Repo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class DefaultPresenter <MODEL extends HasId>
    implements Presenter<MODEL> {

  private final Repo<MODEL> repo;

  private final Form<MODEL> form;

  public DefaultPresenter(Repo<MODEL> repo,
                          Form<MODEL> form) {
    this.repo = repo;
    this.form = form;
  }

  @Override
  public void onSave() {
    repo.save(form.model());
  }

  @Override
  public void init(MODEL model) {
    this.form.setModel(model);
  }

}
