/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Bootstrap.DataLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataLoaderTest {

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void testLoadPostData() {
        // Test the data loading process
    }
}
