package in.sarfraz.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sarfraz.entity.ProductEntity;
import in.sarfraz.repo.ProductRepo;
import in.sarfraz.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo pRepo;

	@Override
	public Boolean saveProduct(ProductEntity product) {
		pRepo.save(product);
		return true;

	}

	@Override
	public List<ProductEntity> getAllProduct() {
		return  pRepo.findAll();

		
	}

	@Override
	public ProductEntity getProductById(Integer pId) {
		Optional<ProductEntity> findById = pRepo.findById(pId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Boolean deleteProductById(Integer PId) {
		pRepo.deleteById(PId);
		return true; 
	}

}
