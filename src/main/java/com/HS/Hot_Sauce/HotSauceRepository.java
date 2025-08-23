package com.HS.Hot_Sauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface HotSauceRepository extends JpaRepository<HotSauce,Integer>
{
    void deleteByIndex(int index);
    // Optional, as I expect at most 1 value to be returned.
    Optional<HotSauce> findByIndex(int index);
    List<HotSauce> findByName(String name);
    List<HotSauce> findBySHU(String shu);
    List<HotSauce> findBySL(String sl);
    List<HotSauce> findByProducer(String producer);
    List<HotSauce> findByNameAndProducer (String name, String producer);

}
