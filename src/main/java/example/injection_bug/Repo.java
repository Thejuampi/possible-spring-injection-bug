package example.injection_bug;

public interface Repo<MODEL> {

  MODEL findById(Long id);

  MODEL save(MODEL model);
}
