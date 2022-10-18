package com.example.junit.junit;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitApplicationTests {

    @Test
    public void testSearch() {
        MongoDB mongoDB = new MongoDB();
		mongoDB.runningtime();
        boolean ysn = mongoDB.search("Origin", "Ethopia");
        assertFalse("Found key", ysn);
    }

}
