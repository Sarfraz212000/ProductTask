package in.sarfraz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarfraz.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
