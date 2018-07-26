package com.springrestapp.serviceapi;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
/*import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/*import org.springframework.web.bind.annotation.RequestMapping;*/
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springrestapp.customexceptionhandling.UserNotFoundException;
import com.springrestapp.pojo.Address;
import com.springrestapp.pojo.User;
import com.springrestapp.service.AddressService;
import com.springrestapp.service.SpringrestServiceImpl;

@RestController()
@CrossOrigin("http://localhost:4200")
public class ServiceApiImpl implements ServiceApi  {
	
	@Autowired
	private SpringrestServiceImpl springrestServiceImpl;
	
    @Autowired
	private AddressService addressService;
	private static Logger logger = LogManager.getLogger(ServiceApiImpl.class);
	
	@GetMapping(value="/home")
	public ModelAndView getHome(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		String msg="welcome to home page";
		mv.addObject("msg", msg);
		return mv;
	}
	
	public String getProduct(){
		System.out.println("helloworld");
		return springrestServiceImpl.getProduct();
	}
	
	public Iterable<User> gatAllUser(){
		return springrestServiceImpl.getUserDetails();
	}
	
	public User getUser(@PathVariable("id") int id){
		User u= springrestServiceImpl.getUser(id);
		if(u==null){
			throw new UserNotFoundException("User id :"+id);
		
		}
		logger.info("sssssssssssssssssssssssssssss"+u.getId()+" "+u.getName());
		return u;
	}
	
	@GetMapping(value="/getAdress", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public List<Address> getAddress(@RequestParam(name="unit",required=false) String unit,
			@RequestParam(name="street_number",required=false) String street_number,
			@RequestParam(name="street_name",required=false) String street_name,
			@RequestParam(name="street_type",required=false) String street_type,
			@RequestParam(name="city",required=false) String city){
	
		List<Address> list=new ArrayList<Address>();
		try{
		list=	addressService.getAddress(unit, street_number, street_name, street_type, city);
		}
		catch(Exception ex){
			logger.info("sssssssssssssssssssssssssssss"+ex.getMessage());
		}
		
		return list;
	}
@PostMapping(value="/saveAddress")
	public  void createAddress(@RequestBody Address address){
		addressService.save(address);
	}
	
}
