package example.injection_bug;

public interface Presenter<MODEL extends HasId> {

  void onSave();

  void init(MODEL model);

}
