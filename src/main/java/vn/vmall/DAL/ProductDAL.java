package vn.vmall.DAL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Entity.ProductEntity;

@Component
public class ProductDAL {
	@Autowired
	@Qualifier("templatejdbc")
	private  JdbcTemplate jdbcTemplateObject;
	
	public List<ProductEntity> getListProductByCatgory(CatgoryEntity catgory) {
		String query ="SELECT * FROM tb_product where tbcatgory_id=?";
				//+ " WHERE isvisible= 1";
		//List<CatgoryEntity> list=new ArrayList<CatgoryEntity>();
		List<ProductEntity> list  = jdbcTemplateObject.query(query,
				new Object[] { catgory.getId() },
				new BeanPropertyRowMapper<ProductEntity>
				(ProductEntity.class));
		return list;
	}

	public int count_product_bycatgory(CatgoryEntity catgory) {
		String query ="SELECT COUNT(*) FROM tb_product where tbcatgory_id=? ";
		int total = jdbcTemplateObject.queryForObject(query, new Object[] { catgory.getId() },  int.class);

		return total;
	}
	public List<ProductEntity> getListProductByCatgory(CatgoryEntity catgory,int start,int limit) {
		String query ="SELECT * FROM tb_product where tbcatgory_id=? "
				+ "	order by id desc limit ?,?";
				//+ " WHERE isvisible= 1";
		//List<CatgoryEntity> list=new ArrayList<CatgoryEntity>();
		List<ProductEntity> list  = jdbcTemplateObject.query(query,
				new Object[] { catgory.getId(),start,limit  },
				new BeanPropertyRowMapper<ProductEntity>
				(ProductEntity.class));
		return list;
	}

}
