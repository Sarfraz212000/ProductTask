package in.sarfraz.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sarfraz.entity.ProductEntity;
import in.sarfraz.service.ProductService;

@RestController
public class ProductRestController {

	private Logger logger=LoggerFactory.getLogger(ProductRestController.class);
	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public ResponseEntity<String> SaveProduct(@Valid @RequestBody  ProductEntity product) {
		logger.debug("saving data process started....");
		Boolean status = service.saveProduct(product);
		logger.info("saving data process completed...");

		if (status) {
			logger.info("data saved successfully..");
			return new ResponseEntity<String>("Data insert successfully", HttpStatus.CREATED);

		} else {
			logger.info("data not saved succesfully");
			return new ResponseEntity<String>("Data not inserted successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		logger.debug("fetching all product ");
		List<ProductEntity> products = service.getAllProduct();
		logger.info("fetching data successfully");
		return new ResponseEntity<List<ProductEntity>>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{pId}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable Integer pId) {
		logger.debug("fetching one product ById ");
		ProductEntity product = service.getProductById(pId);
		logger.info("fetching one product ById successfully");
		return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);

	}

	@GetMapping("/delete/{pId}")
	public ResponseEntity<String> deleteProductById(@PathVariable @Valid Integer pId) {
		logger.debug("deleting process is started");
		Boolean product = service.deleteProductById(pId);
		if (product) {
			logger.debug("deleted successfully");
			return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
		} else {
			logger.debug("deleted not successfull ");
			return new ResponseEntity<String>("Deleted not successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
