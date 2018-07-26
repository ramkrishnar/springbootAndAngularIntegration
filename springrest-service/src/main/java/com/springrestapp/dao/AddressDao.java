package com.springrestapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.springrestapp.pojo.Address;



public interface AddressDao extends CrudRepository<Address, Integer>  {

@Query(nativeQuery=true ,value="select id,unit ,street_number,street_name,street_type,city from address_info where "+
"null = ?1")
//+ ""
//+ " and nvl(street_number,'javaaa')= nvl(?2,'javaaa') and nvl(street_name,'javaaa') = nvl(?3,'javaaa')"+
	//	"  and nvl(street_type,'javaaa')=nvl(?4,'javaaa') and nvl(city,'javaaa')=nvl(?5,'javaaa')")
List<Address> findAddress(String unit);
	
	
}
 