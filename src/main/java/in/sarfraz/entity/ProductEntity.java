package in.sarfraz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "PRODUCT_TAB")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	@NotBlank(message = "Please enter proper product name")
	@Size(min=2, message = "Name should be atleast 2 characters")
	@Size(max = 15, message = "Name should not be greater than 15 characters")
	private String  productName;
	
	@NotNull(message = "Please enter a valid amount")
	@Min(value=200, message = "Product price must be greater or equal to 200")
	private Double  productPrice;
}
