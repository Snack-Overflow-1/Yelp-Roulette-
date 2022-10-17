package com.help.demokelly;

import org.junit.jupiter.api.Test;
import org.junit.*; 
//import org.springframework.boot.test.context.SpringBootTest;

class DemokellyApplicationTests {

	@Test
	public void testConnect() {
		connectDB connect = new connectDB(); 
		assertTrue(connect.equals(connect)); 
	}

}
