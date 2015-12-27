package org.nuno.junit.profiles;

import org.junit.Test;
import org.nuno.utils.ResponseMessage;

import junit.framework.TestCase;


public class TestProfiles extends TestCase{
	
	@Test
	public void testUser(){
		 ResponseMessage resp = new ResponseMessage();

		 
		resp.setId(2);
		
	    // assert statements
	    assertEquals("Teste simples", 2, resp.getId());
	}
	
}
