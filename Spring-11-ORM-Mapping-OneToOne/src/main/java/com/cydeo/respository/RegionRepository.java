package com.cydeo.respository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
