package inventory.springservice.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "Product", "sizeAndCounts" })
public class Product {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	private String brand;   // 品牌
	private String xinghao; // 型号
	private String isKid; 		//是否童鞋：1-成人鞋；2-童鞋；
	private String color;	//颜色
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY, mappedBy = "product")
	@OrderBy(clause = "size ASC")
	private Set<SizeAndCount> sizeAndCounts ; //尺寸和数量的键值对
	//private String holder;		//商品持有者;1-冯佳丹；2-高丹；
	private String sexy;		//性别属性， 1-男款；2-女款；3-中性
	//private String location;    //所在地
	
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public String getIsKid() {
		return isKid;
	}
	public void setIsKid(String isKid) {
		this.isKid = isKid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Set<SizeAndCount> getSizeAndCounts() {
		return sizeAndCounts;
	}
	public void setSizeAndCounts(Set<SizeAndCount> sizeAndCounts) {
		this.sizeAndCounts = sizeAndCounts;
	}
//	public String getHolder() {
//		return holder;
//	}
//	public void setHolder(String holder) {
//		this.holder = holder;
//	}
	public String getSexy() {
		return sexy;
	}
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	
	

	
}
