package vn.vmall.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.vmall.DAL.CatgoryDAL;
import vn.vmall.Entity.CatgoryEntity;
import vn.vmall.Interface.CatgoryInterface;

@Component("CatgoryImp")
public class CatgoryImp implements CatgoryInterface{
	@Autowired
	private CatgoryDAL dal;

	@Override
	public List<CatgoryEntity> getALLCatgory() {
		// TODO Auto-generated method stub
		return dal.getALLCatgory();
	}

	@Override
	public int getCountCatgorybyID(String catgoryid) {
		// TODO Auto-generated method stub
		 return dal.getCountCatgorybyID(catgoryid);
	}

	@Override
	public CatgoryEntity getCatgorybyID(String catgoryid) {
		// TODO Auto-generated method stub
		 return dal.getCatgorybyID(catgoryid);
	}

	@Override
	public String test_outparam(String in1, String in2) {
		// TODO Auto-generated method stub
		return dal.test_outparam(in1,in2);
	}

	@Override
	public CatgoryEntity getCatgorybyIDbystore(String id) {
		// TODO Auto-generated method stub
		return dal.getCatgorybyIDbystore(id);
	}
}
