package vn.vmall.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.vmall.DAL.ProductDAL;
import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Entity.ProductEntity;
import vn.vmall.Interface.ProductInterface;

@Component("ProductImp")
public class ProductImp implements ProductInterface{

	@Autowired
	private ProductDAL dal;

	@Override
	public List<ProductEntity> getListProductByCatgory(CatgoryEntity catgory) {
		// TODO Auto-generated method stub
		return dal.getListProductByCatgory(catgory);
	}
	
}
