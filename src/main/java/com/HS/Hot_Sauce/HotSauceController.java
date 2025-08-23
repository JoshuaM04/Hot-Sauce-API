package com.HS.Hot_Sauce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Combination of @Controller & @ResponseBody annotations
@RequestMapping (path = "api/v1/hot_sauce") // A general-purpose mapping annotation that can handle any HTTP method. Sets the base path for all methods in the controller.
public class HotSauceController {
    private final HotSauceService hotSauceService;

    @Autowired
    public HotSauceController(HotSauceService hotSauceService) {this.hotSauceService = hotSauceService;}

    @GetMapping
    public List<HotSauce> getHotSauce
            (
                @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String SHU,
                @RequestParam(required = false) String SL,
                @RequestParam(required = false) String producer
            )
            {
                if (id != null)
                {
                    return hotSauceService.getHotSauceByID(id);
                }
                else if (name != null)
                {
                    return hotSauceService.getHotSauceByName(name);
                }
                else if (SHU != null)
                {
                    return hotSauceService.getHotSauceBySHU(SHU);
                }
                else if (SL != null)
                {
                    return hotSauceService.getHotSauceBySL(SL);
                }
                else if (producer != null)
                {
                    return hotSauceService.getHotSauceByProducer(producer);
                }
                else
                {
                    return hotSauceService.getHotSauce();
                }
            }
}
