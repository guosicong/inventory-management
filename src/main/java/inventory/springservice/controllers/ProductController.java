package inventory.springservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inventory.springservice.domain.Product;
import inventory.springservice.domain.SizeAndCount;
import inventory.springservice.domain.SysUser;
import inventory.springservice.services.ProductService;
import inventory.springservice.services.SizeAndCountService;
import inventory.springservice.services.SysUserService;

@Controller
public class ProductController {

	private ProductService productService;
	private SizeAndCountService sizeAndCountService;
	private SysUserService sysUserService;
	
	@Autowired
	public void setProductService(ProductService productService) {
        this.productService = productService;
    }

	@Autowired
	public void setSizeAndCountService(SizeAndCountService sizeAndCountService) {
        this.sizeAndCountService = sizeAndCountService;
    }
	
	@Autowired
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
    	System.out.println("**************进来了****product/{id}***********");
    	System.out.println("id = "+id);
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model) {
        Product p = new Product();
        model.addAttribute("product", p);
        return "productform";
    }
    

    @RequestMapping("product/sizeAndCount/new/{id}")
    public String newSizeAndCount(@PathVariable Integer id, Model model) {
        SizeAndCount s = new SizeAndCount();
        Product product = new Product();
        product.setID(id);
        s.setProduct(product);
        //System.out.println("SizeAndCount ******** productID = ");
        //System.out.println(s.getProduct().getID());
        model.addAttribute("sizeAndCount", s);
        return "sizeAndCountform";
    }

    @RequestMapping(value = "sizeAndCount", method = RequestMethod.POST)
    public String saveProductSizeAndCount(SizeAndCount sizeAndCount) {
    	//System.out.println("**************进来了****1***********");
    	//System.out.println(sizeAndCount.getCount());
    	//System.out.println(sizeAndCount.getSize());
    	//System.out.println(sizeAndCount.getProduct().getID());
        sizeAndCountService.saveSizeAndCount(sizeAndCount.getProduct().getID(),
        								     sizeAndCount.getSize(),
        								     sizeAndCount.getCount());
    	//System.out.println("**************进来了****2***********");
        return "redirect:/product/" + sizeAndCount.getProduct().getID();
    }
    

    @RequestMapping(value = "sizeAndCountAddCount/{Id}", method = RequestMethod.GET)
    public String saveSizeAndCountAddCount(@PathVariable Integer Id, Model model) {
        //sizeAndCountService.saveSizeAndCount(sizeAndCount.getProduct().getID(),sizeAndCount.getSize(),sizeAndCount.getCount());
    	//System.out.println("**************进来了***sizeAndCount***********");
    	//System.out.println(Id);
    	SizeAndCount sizeAndCount = sizeAndCountService.getSizeAndCountById(Id);
        model.addAttribute("sizeAndCount", sizeAndCount);
        return "sizeAndCountAddCount";
    }

    @RequestMapping(value = "sizeAndCountCutCount/{Id}", method = RequestMethod.GET)
    public String saveSizeAndCountCutCount(@PathVariable Integer Id, Model model) {
    	SizeAndCount sizeAndCount = sizeAndCountService.getSizeAndCountById(Id);
        model.addAttribute("sizeAndCount", sizeAndCount);
        return "sizeAndCountCutCount";
    }
    
    @ResponseBody
    @RequestMapping(value = "sizeAndCountAddCount/", method = RequestMethod.POST)
    public String updateSizeAndCountAddCount(Integer addCount, Integer Id) {
        //sizeAndCountService.saveSizeAndCount(sizeAndCount.getProduct().getID(),sizeAndCount.getSize(),sizeAndCount.getCount());
    	System.out.println("**************进来了****2***********");
    	System.out.println(addCount);
    	System.out.println(Id);
    	SizeAndCount sizeAndCount = sizeAndCountService.getSizeAndCountById(Id);
    	addCount = addCount + sizeAndCount.getCount();
    	sizeAndCountService.updateSizeAndCountCount(addCount, sizeAndCount);    	
        return "Success";
    }
    
    @ResponseBody
    @RequestMapping(value = "sizeAndCountCutCount/", method = RequestMethod.POST)
    public String updateSizeAndCountCutCount(Integer cutCount, Integer Id) {
    	SizeAndCount sizeAndCount = sizeAndCountService.getSizeAndCountById(Id);
    	cutCount = sizeAndCount.getCount() - cutCount;
    	sizeAndCountService.updateSizeAndCountCount(cutCount, sizeAndCount);    	
        return "Success";
    }
    
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
    	//System.out.println("**************进来了****3***********");
        productService.saveProduct(product);
        return "redirect:/product/" + product.getID();
    }

    @RequestMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Product product, Model model) {
        model.addAttribute("product", productService.deleteProductById(id, product));
        return "redirect:/products/";
    }
    
    @RequestMapping("/sizeAndCount/delete/{id}")
    public String deleteSizeAndCount(@PathVariable Integer id, Model model) {
    	System.out.println("**************进来了****deleteSizeAndCount***********");
    	SizeAndCount sizeAndCount = sizeAndCountService.getSizeAndCountById(id);
    	sizeAndCountService.deleteSizeAndCountById(id);
        model.addAttribute("product", sizeAndCount.getProduct());
    	System.out.println("sizeAndCount.getProduct()" +sizeAndCount.getProduct().getID());
        return "redirect:/product/"+sizeAndCount.getProduct().getID();
    }
    
    @RequestMapping("getSysUser")
    public Iterable<SysUser> getSysUsers() {
    	System.out.println("**************进来了****getSysUsers***********");
    	
    	return this.sysUserService.listAllSysUsers();
    }


}
