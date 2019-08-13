package example.injection_bug;

public interface Form<MODEL extends HasId> {

  MODEL model();

  void setModel(MODEL model);

}
