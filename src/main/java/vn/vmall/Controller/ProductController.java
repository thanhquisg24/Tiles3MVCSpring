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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Entity.ProductEntity;
import vn.vmall.Helper.Pagination;
import vn.vmall.Interface.CatgoryInterface;
import vn.vmall.Interface.ProductInterface;



@Controller
public class ProductController {

	final int limit=10;
	 @Autowired
	 @Qualifier("CatgoryImp")
	 private CatgoryInterface CatgoryImp;
	
	 @Autowired
	 @Qualifier("ProductImp")
	 private ProductInterface ProductImp;
	
	
	@RequestMapping(value="/xem-danh-muc/{catgoryid}", method=RequestMethod.GET)
	public ModelAndView viewProductbyCatgory( @PathVariable("catgoryid") String catgoryid,
			@RequestParam(value="page", required = false,defaultValue="1") int currentpage,Model model) {
		List<ProductEntity> listproduct=new ArrayList<ProductEntity> ();
		CatgoryEntity catgory=new CatgoryEntity();
		if(CatgoryImp.getCountCatgorybyID(catgoryid)>0){
			
			catgory =CatgoryImp.getCatgorybyID(catgoryid);
			
			String link_full="/xem-danh-muc/"+catgoryid+"?page=replace_numberpage";
			String link_first="/xem-danh-muc/"+catgoryid;
			int total_record=0;
			total_record=ProductImp.count_product_bycatgory(catgory);
			Pagination pagg=new Pagination(currentpage,total_record,limit,link_full,link_first);
			int start= pagg.getStart();
			listproduct=ProductImp.getListProductByCatgory(catgory,start,limit);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home.productlistbycatgory");
		mav.addObject("PathVariablecatgoryid", catgoryid);
		mav.addObject("Pagetitle","catgory  page...");
		mav.addObject("listproduct",listproduct);
		mav.addObject("catgoryoject",catgory);
	
		return mav;
	}
}
