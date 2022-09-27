package com.clevershuttle.carmanagement.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetailsEntity, Long> {

    public CarDetailsEntity findByUserId(String userId);

    public <S extends CarDetailsEntity>S save(S carDetails);


}
