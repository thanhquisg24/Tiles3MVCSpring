package vn.vmall.Interface;

import java.util.List;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Entity.ProductEntity;

public interface ProductInterface {

	List<ProductEntity> getListProductByCatgory(CatgoryEntity catgory);

	int count_product_bycatgory(CatgoryEntity catgory);

	List<ProductEntity> getListProductByCatgory(CatgoryEntity catgory,
			int start, int limit);

}
