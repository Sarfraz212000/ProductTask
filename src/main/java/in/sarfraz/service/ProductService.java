package in.sarfraz.service;

import java.util.List;

import in.sarfraz.entity.ProductEntity;

public interface ProductService {
	
	public Boolean saveProduct(ProductEntity product);
	
	public List<ProductEntity> getAllProduct();
	
	public ProductEntity getProductById(Integer pId);
	
	public Boolean deleteProductById(Integer PId);

}
