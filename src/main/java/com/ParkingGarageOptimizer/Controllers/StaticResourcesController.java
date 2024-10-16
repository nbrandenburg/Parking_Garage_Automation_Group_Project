/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticResourcesController {
    @RequestMapping("/homepage")
    public String getHomepage(){
        return "homepage";
    }

    @RequestMapping("/")
    public String getRoot(){
        return "homepage";
    }

}
