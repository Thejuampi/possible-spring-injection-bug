package example.injection_bug;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ModelRepo<MODEL extends HasId>
    implements Repo<MODEL> {

  private final ConcurrentHashMap<Long, MODEL> storage = new ConcurrentHashMap<>();

  @Override
  public MODEL findById(Long id) {
    return storage.get(id);
  }

  @Override
  public MODEL save(MODEL model) {
    return this.storage.put(model.getId(), model);
  }

}
