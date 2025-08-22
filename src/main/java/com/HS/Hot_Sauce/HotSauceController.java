package com.HS.Hot_Sauce;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combination of @Controller & @ResponseBody annotations
@RequestMapping (path = "api/v1/hot_sauce") // A general-purpose mapping annotation that can handle any HTTP method. Sets the base path for all methods in the controller.
public class HotSauceController {

}
