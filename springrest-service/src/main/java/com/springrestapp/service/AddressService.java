package com.springrestapp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import com.springrestapp.dao.AddressDao;
import com.springrestapp.pojo.Address;

@Service
public class AddressService {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AddressDao addressdao;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static String quote(String s) {
		return new StringBuilder().append('\'').append(s).append('\'').toString();
	}

	private static Logger logger = LogManager.getLogger(AddressService.class);

	public List<Address> getAddress(String unit, String street_number, String street_name, String street_type,
			String city) {
		logger.info("vvvvvvvvvvvvvvvvvvvvvvvvvvv" + unit + street_number + street_name + street_type + city);
		String street_numberquery = "  or nvl(street_number,'javaaa')= nvl(" + street_number + ",'javaaa')";
		String street_namequery = "  or nvl(street_name,'javaaa')= nvl(" + street_name + ",'javaaa')";
		String street_typequery = "  or nvl(street_type,'javaaa')= nvl(" + street_type + ",'javaaa')";
		String cityquery = "  or nvl(city,'javaaa')= nvl(" + city + ",'javaaa')";
		if (unit != null) {
			unit = quote(unit);

		}
		if (street_number != null) {
			street_number = quote(street_number);
			street_numberquery = "  and nvl(street_number,'javaaa')= nvl(" + street_number + ",'javaaa')";
		}
		if (street_name != null) {
			street_name = quote(street_name);
			street_namequery = "  and nvl(street_name,'javaaa')= nvl(" + street_name + ",'javaaa')";
		}
		if (street_type != null) {
			street_type = quote(street_type);
			street_typequery = "  and nvl(street_type,'javaaa')= nvl(" + street_type + ",'javaaa')";
		}
		if (city != null) {
			city = quote(city);
			cityquery = "  and  nvl(city,'javaaa')= nvl(" + city + ",'javaaa')";
		}

		logger.info("vvvvvvvvvvvvvvvvvvvvvvvvvvv" + unit + street_number + street_name + street_type + city);
		List<Address> list = new ArrayList<Address>();
		String sql = "select id,unit ,street_number,street_name,street_type,city from address_info where "
				+ "nvl(unit,'javaaa')= nvl(" + unit + ",'javaaa')" + street_numberquery + street_namequery
				+ street_typequery + cityquery;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {
			public List<Address> extractData(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Address address = new Address();
					address.setId(rs.getInt("id"));
					address.setUnit(rs.getString("unit"));
					address.setStreet_number(rs.getString("street_number"));
					address.setStreet_name(rs.getString("street_name"));
					address.setStreet_type(rs.getString("street_type"));
					address.setCity(rs.getString("city"));
					list.add(address);

				}
				return list;
			}

		});
		if (!list.isEmpty()) {
			for (Address ad : list) {
				logger.info("idddddddddddddddd's" + ad.getId());
			}
		} else {
			logger.info("address not found");
		}
		return list;

		/*
		 * public void save(Address address) { // TODO Auto-generated method
		 * stub addressDao.save(address); }
		 */

	}

	public void save(Address address) {
		addressdao.save(address);
		
	}
}
