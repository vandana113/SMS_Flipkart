package com.flipcard.rest;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipcard.bean.Customer;

@Path("/customer")
public class CustomerRestController {

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetails() {
		Customer customer = new Customer();
		customer.setId(101);
		customer.setName("Flipcard");
		customer.setAddress("Mumbai");
		return customer;
	}

}
