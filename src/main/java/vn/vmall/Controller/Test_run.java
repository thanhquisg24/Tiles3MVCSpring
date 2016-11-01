package vn.vmall.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Interface.CatgoryInterface;
import vn.vmall.Interface.ProductInterface;


@RestController
public class Test_run {
	 @Autowired
	 @Qualifier("CatgoryImp")
	 private CatgoryInterface CatgoryImp;
	
	 @Autowired
	 @Qualifier("ProductImp")
	 private ProductInterface ProductImp;
	 
	 @RequestMapping(value="/get_allcatgory.json",
				method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CatgoryEntity>  get_allcode_searchbox(){
		 return CatgoryImp.getALLCatgory();
		// return null;	 
	 }
	 @RequestMapping(value="/getCatgorybyIDbystore/{id}",
				method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public CatgoryEntity getCatgorybyIDbystore(@PathVariable(value="id") String id){
		 return CatgoryImp.getCatgorybyIDbystore(id);
		// return null;	 
	 }
	 @RequestMapping(value="/getCatgorybyID/{id}",
				method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public CatgoryEntity getCatgorybyID(@PathVariable(value="id") String id){
		 return CatgoryImp.getCatgorybyID(id);
		// return null;	 
	 }
	
	 @RequestMapping(value="/test_outparam/{in1}/{in2}",
				method=RequestMethod.GET)
		public String  test_outparam(@PathVariable(value="in1") String in1,@PathVariable(value="in2") String in2){
		 return CatgoryImp.test_outparam(in1,in2);
		// return null;	 
	 }
}
