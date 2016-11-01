package vn.vmall.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Entity.ProductEntity;
import vn.vmall.Interface.CatgoryInterface;
import vn.vmall.Interface.ProductInterface;



@Controller
public class ProductController {

	 @Autowired
	 @Qualifier("CatgoryImp")
	 private CatgoryInterface CatgoryImp;
	
	 @Autowired
	 @Qualifier("ProductImp")
	 private ProductInterface ProductImp;
	
	List<CatgoryEntity> listcatgory_tiles3;
	
	private String url_href_view_productlistby_catgory="xem-danh-muc";
	
	@RequestMapping(value="/xem-danh-muc/{catgoryid}", method=RequestMethod.GET)
	public ModelAndView viewProductbyCatgory( @PathVariable("catgoryid") String catgoryid,Model model) {
		
		this.listcatgory_tiles3=CatgoryImp.getALLCatgory();
		List<ProductEntity> listproduct=new ArrayList<ProductEntity> ();
		CatgoryEntity catgory=new CatgoryEntity();
		if(CatgoryImp.getCountCatgorybyID(catgoryid)>0){
			catgory =CatgoryImp.getCatgorybyID(catgoryid);
			listproduct=ProductImp.getListProductByCatgory(catgory);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home.productlistbycatgory");
		mav.addObject("PathVariablecatgoryid", catgoryid);
		mav.addObject("Pagetitle","catgory  page...");
		mav.addObject("listcatgory",this.listcatgory_tiles3);
		mav.addObject("listproduct",listproduct);
		mav.addObject("catgoryoject",catgory);
		mav.addObject("url_href_view_productlistby_catgory",url_href_view_productlistby_catgory);
		return mav;
	}
}
