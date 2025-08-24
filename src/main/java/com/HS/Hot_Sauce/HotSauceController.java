package com.HS.Hot_Sauce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Combination of @Controller & @ResponseBody annotations
@RequestMapping (path = "api/v1/hot_sauce") // A general-purpose mapping annotation that can handle any HTTP method. Sets the base path for all methods in the controller.
public class HotSauceController
{
    private final HotSauceService hotSauceService;

    @Autowired
    public HotSauceController(HotSauceService hotSauceService) {this.hotSauceService = hotSauceService;}

    @GetMapping("/{id}")
    // ResponseEntity handles HTTP status codes
    public ResponseEntity<HotSauce> getHotSauceByID(@PathVariable Long id)
    {
        Optional<HotSauce> hotSauce = hotSauceService.getHotSauceById(id);

        return hotSauce.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<HotSauce> getHotSauce
            (
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String SHU,
                @RequestParam(required = false) String SL,
                @RequestParam(required = false) String producer
            )
            {
                if (name != null && producer != null)
                {
                    return hotSauceService.getHotSauceByNameAndProducer(name, producer);
                }
                else if (name != null)
                {
                    return hotSauceService.getHotSauceByName(name);
                }
                else if (SHU != null)
                {
                    return hotSauceService.getHotSauceByScovilleHeatUnits(SHU);
                }
                else if (SL != null)
                {
                    return hotSauceService.getHotSauceByScovilleLevel(SL);
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

    @PostMapping
    public ResponseEntity<HotSauce> addHotSauce(@RequestBody HotSauce hotSauce)
    {
        HotSauce createdHotSauce =  hotSauceService.addHotSauce(hotSauce);
        return new ResponseEntity<>(createdHotSauce, HttpStatus.CREATED);
    }
}
