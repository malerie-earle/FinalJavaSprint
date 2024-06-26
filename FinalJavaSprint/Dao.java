package FinalJavaSprint;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    
  Optional<T> getId(int id);
  
  List<T> getAll();
  
  void save(T t);
  
  void update(T t, String[] params);
  
  void delete(T t);
}
