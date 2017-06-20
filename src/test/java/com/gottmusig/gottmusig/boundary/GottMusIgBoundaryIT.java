package com.gottmusig.gottmusig.boundary;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import lombok.extern.slf4j.Slf4j;

@RunAsClient
@RunWith(Arquillian.class)
@Slf4j
public class GottMusIgBoundaryIT extends AbstractIT {
	
	@Test
	public void shouldGetStartPageTest(){
		String response = get("/");
		log.debug("Response for Hello WorldTest: "+response);
		approve(response, "htmlStartpage");
	}
	
	
	

}
