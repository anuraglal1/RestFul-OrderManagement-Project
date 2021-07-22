package com.infinity.GlobalSolutions;

public class CustomerNotFoundException extends  RuntimeException {
	
	CustomerNotFoundException(Integer id) {
	    super("Could not find employee " + id);
	  }

}
