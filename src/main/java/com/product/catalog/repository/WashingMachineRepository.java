package com.product.catalog.repository;

import com.product.catalog.entity.TelevisionData;
import com.product.catalog.entity.WashingMachineData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingMachineRepository extends JpaRepository<WashingMachineData, Integer> {
}
