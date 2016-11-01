package vn.vmall.DAL;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import vn.vmall.Entity.CatgoryEntity;


@Repository
public class CatgoryDAL {
	@Autowired
	@Qualifier("templatejdbc")
	private  JdbcTemplate jdbcTemplateObject;
	


	public List<CatgoryEntity> getALLCatgory() {
		String query ="SELECT id, name, img  "
				+ " FROM tb_catgory";
				//+ " WHERE isvisible= 1";
		//List<CatgoryEntity> list=new ArrayList<CatgoryEntity>();
		List<CatgoryEntity> list  = jdbcTemplateObject.query(query,
				new BeanPropertyRowMapper<CatgoryEntity>(CatgoryEntity.class));
		//List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(query);
		/*for (Map row : rows) {
			CatgoryEntity c = new CatgoryEntity();
			c.setId((String)row.get("id"));
			c.setImg((String)row.get("name"));
			c.setName((String)row.get("img"));
			list.add(c);
		}*/

		return list;
		
	}

/*	public List<CatgoryEntity> getALLCatgory() {
		List<CatgoryEntity> list=null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps = null;
		String query ="SELECT id, name, img  "
				+ " FROM tb_catgory";
				//+ " WHERE isvisible= 1";
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			ResultSetMapper<CatgoryEntity> resultSetMapper = new ResultSetMapper<CatgoryEntity>();
			list = resultSetMapper.mapRersultSetToObject(rs,CatgoryEntity.class);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
				Extra.do_close_connection(con,ps,rs);
			}
		if(list==null){
			list=new ArrayList<CatgoryEntity>();
		}
		return list;
	}
	

*/
	public int getCountCatgorybyID(String catgoryid) {//select count
		String sql = "SELECT COUNT(*) FROM tb_catgory WHERE id = ?";
		int total = jdbcTemplateObject.queryForObject(sql, new Object[] { catgoryid },  int.class);

		return total;
	}
	public CatgoryEntity getCatgorybyID(String catgoryid) {//single row
		String sql = "SELECT id, name, img FROM tb_catgory WHERE id = ?";
		CatgoryEntity a=jdbcTemplateObject.queryForObject(sql, new Object[] { catgoryid }, 
								BeanPropertyRowMapper.newInstance(CatgoryEntity.class));
		return a;
	}
	public String test_outparam(String in1,String in2){
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateObject)
		.withProcedureName("sp_test_outparam");
		SqlParameter[] parameters = {
	            new SqlParameter("p_in1",Types.VARCHAR),
	            new SqlParameter("p_in2",Types.VARCHAR),
	            new SqlOutParameter("out1", Types.VARCHAR),
	            new SqlOutParameter("out2", Types.VARCHAR)
	    };
		simpleJdbcCall.declareParameters(parameters);
		   SqlParameterSource in = new MapSqlParameterSource()
           .addValue("p_in1", in1)
           .addValue("p_in2", in2); 
		 Map<String, Object> mapout = simpleJdbcCall.execute(in);
		return mapout.toString();
	}
	public CatgoryEntity getCatgorybyIDbystore(String catgoryid) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateObject)
		.withProcedureName("sp_getcatgory").returningResultSet("rs", 
						BeanPropertyRowMapper.newInstance(CatgoryEntity.class));
		SqlParameter[] parameters = {
	            new SqlParameter("p_id",Types.VARCHAR)
	          
	    };
		simpleJdbcCall.declareParameters(parameters);
		   SqlParameterSource in = new MapSqlParameterSource()
           .addValue("p_id", catgoryid);
		      Map<String, Object> out = simpleJdbcCall.execute(in);
		      System.out.println(out.get("rs").toString());
		      List<CatgoryEntity> list=(List<CatgoryEntity>) out.get("rs");
		      return list.get(0);

	}
	
	
}
