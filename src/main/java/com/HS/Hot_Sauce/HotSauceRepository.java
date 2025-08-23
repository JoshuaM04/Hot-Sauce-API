package com.HS.Hot_Sauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotSauceRepository extends JpaRepository<HotSauce,Integer>
{
    void deleteByIndex(int index);
    Optional<HotSauce> findByIndex(int index);
}
