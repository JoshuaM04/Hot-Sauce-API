package com.HS.Hot_Sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

// Contains business logic & sits between the controller and repository
@Component
public class HotSauceService {
    private final HotSauceRepository hotSauceRepository;

    @Autowired
    public HotSauceService(HotSauceRepository hotSauceRepository) {
        this.hotSauceRepository = hotSauceRepository;
    }

    public List<HotSauce> getHotSauce() {
        return hotSauceRepository.findAll();
    }

    public Optional<HotSauce> getHotSauceById(String searchIndex) {
        return hotSauceRepository.findById(searchIndex);
    }

    public List<HotSauce> getHotSauceByName(String searchText) {
        return hotSauceRepository.findByName(searchText);
    }

    public List<HotSauce> getHotSauceByScovilleHeatUnits(String searchText) {
        return hotSauceRepository.findByScovilleHeatUnits(searchText);
    }

    public List<HotSauce> getHotSauceByScovilleLevel(String searchText) {
        return hotSauceRepository.findByScovilleLevel(searchText);
    }

    public List<HotSauce> getHotSauceByProducer(String searchText) {
        return hotSauceRepository.findByProducer(searchText);
    }

    public List<HotSauce> getHotSauceByNameAndProducer(String name, String producer) {
        return hotSauceRepository.findByNameAndProducer(name, producer);
    }

    public HotSauce addHotSauce(HotSauce hotSauce)
    {
        hotSauceRepository.save(hotSauce);
        return hotSauce;
    }
}
