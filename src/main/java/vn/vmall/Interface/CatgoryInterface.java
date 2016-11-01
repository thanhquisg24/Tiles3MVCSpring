package vn.vmall.Interface;

import java.util.List;

import vn.vmall.Entity.CatgoryEntity;

public interface CatgoryInterface {

	List<CatgoryEntity> getALLCatgory();

	int getCountCatgorybyID(String catgoryid);

	CatgoryEntity getCatgorybyID(String catgoryid);

	String test_outparam(String in1, String in2);

	CatgoryEntity getCatgorybyIDbystore(String id);

}
