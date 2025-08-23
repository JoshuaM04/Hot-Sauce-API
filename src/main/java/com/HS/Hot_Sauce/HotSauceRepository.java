package com.HS.Hot_Sauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface HotSauceRepository extends JpaRepository<HotSauce,String>
{
    // Optional, as I expect at most 1 value to be returned.
    // Optional<HotSauce> findById(String id);
    List<HotSauce> findByName(String name);
    List<HotSauce> findByScovilleHeatUnits(String shu);
    List<HotSauce> findByScovilleLevel(String sl);
    List<HotSauce> findByProducer(String producer);
    List<HotSauce> findByNameAndProducer (String name, String producer);
}
