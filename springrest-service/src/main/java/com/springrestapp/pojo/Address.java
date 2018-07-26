package com.springrestapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
/*@NamedQuery(name = "Address.findAddress", query = "select a.id,unit ,a.street_number,a.street_name,a.street_type,a.city from Address a"+
	" where nvl(a.unit,'java')= nvl(?1,'java') and nvl(a.street_number,'java')= nvl(?2,'java') "+
	"and nvl(a.street_name,'java')= nvl(?3,'java') and nvl(a.street_type,'hhhhh')= nvl(?4,'hhhhh') and"+
	" nvl(a.city,'java')= nvl(?5,'java')")*/
@Table(name="address_info")
public class Address {
	@Id
	private int id;
	private String unit;
    private String street_number;
    private String street_name;
	private String street_type;
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getStreet_type() {
		return street_type;
	}
	public void setStreet_type(String street_type) {
		this.street_type = street_type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
