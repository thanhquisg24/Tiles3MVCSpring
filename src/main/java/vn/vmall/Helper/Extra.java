package vn.vmall.Helper;

import java.util.List;

import org.springframework.context.ApplicationContext;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Imp.CatgoryImp;
import vn.vmall.context.ApplicationContextProvider;


public class Extra {
	
	
	public static String h_getstatic_catgory(){
		ApplicationContext context=ApplicationContextProvider.getApplicationContext();
		CatgoryImp imp= context.getBean(CatgoryImp.class);
		
		
		return imp.getCatgorybyID("CA1").toString();
		
	}
	public static List<CatgoryEntity> extra_list_catgory(){
		ApplicationContext context=ApplicationContextProvider.getApplicationContext();
		CatgoryImp imp= context.getBean(CatgoryImp.class);
		return imp.getALLCatgory();
		
	}
}
