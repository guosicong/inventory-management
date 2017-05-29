package inventory.springservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "Product","sizeAndCounts" })
public class SizeAndCount {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@ManyToOne(cascade={CascadeType.MERGE},optional=false)
	@JoinColumn(name = "product_id")
	private Product product;
	@Column
	private float size;
	@Column
	private Integer count;
	
	@OneToOne(cascade={CascadeType.MERGE},optional=false)
	@JoinColumn(name = "sysUser_id")
	private SysUser sysUser;

	
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	
}
