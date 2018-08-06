package ftc.shift.sample.repositories;

import ftc.shift.sample.entities.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food,Long> {
}
