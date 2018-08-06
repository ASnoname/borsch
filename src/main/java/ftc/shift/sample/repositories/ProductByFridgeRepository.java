package ftc.shift.sample.repositories;

import ftc.shift.sample.entities.ProductByFridge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductByFridgeRepository extends CrudRepository<ProductByFridge,Long> {
}
