package com.clevershuttle.carmanagement.services;

import com.clevershuttle.carmanagement.api.dto.CarDetailsRequest;
import com.clevershuttle.carmanagement.api.dto.CarDetailsResponse;
import com.clevershuttle.carmanagement.exception.CarDetailsNotFoundException;
import com.clevershuttle.carmanagement.persistance.CarDetailsEntity;
import com.clevershuttle.carmanagement.persistance.CarDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCarManagementService implements CarManagementService{

    Logger logger = LoggerFactory.getLogger(DefaultCarManagementService.class);

    @Autowired
    CarDetailsRepository carDetailsRepository;


    @Override
    public CarDetailsEntity createCarDetails(String userId, CarDetailsRequest newRequest) {
        logger.debug("Creating a new car detail info with information: " + newRequest.toString());
        CarDetailsEntity carEntity = new CarDetailsEntity();
        carEntity.setUserId(userId);
        carEntity.setBrand(carEntity.getBrand());
        carEntity.setLicensePlate(carEntity.getLicensePlate());
        carEntity.setCreatedAt(carEntity.getCreatedAt());
        carEntity.setLastUpdatedAt(carEntity.getLastUpdatedAt());
        return carDetailsRepository.save(carEntity);
    }

    @Override
    public CarDetailsResponse getCarDetails(String userId) {
            CarDetailsEntity carDetailsEntity = carDetailsRepository.findByUserId(userId);
            if (carDetailsEntity == null) {
                logger.warn("Tried to find car entry which doesn't exist in DB. Nonexistent car uuid: [" + userId + "].");
                throw new CarDetailsNotFoundException("Cannot find customer for : [" + userId + "].");
            }
            logger.info("Successfully retrieved car details from: [brandName=" + carDetailsEntity.getBrand() + ", licenseplate=" + carDetailsEntity.getLicensePlate() + ", created at =" + carDetailsEntity.getCreatedAt() + "].");
            return toCarDetailsResponse(carDetailsEntity);
        }

        private CarDetailsResponse toCarDetailsResponse(CarDetailsEntity carDetailsEntity){
            CarDetailsResponse response = new CarDetailsResponse(carDetailsEntity.getBrand(), carDetailsEntity.getLicensePlate(),
                    carDetailsEntity.getManufacturer(),carDetailsEntity.getOperationCity(),
                    carDetailsEntity.getStatus(), carDetailsEntity.getCreatedAt(), carDetailsEntity.getLastUpdatedAt());
            return response;
        }

    @Override
    public CarDetailsResponse updateCarDetails(String userId, CarDetailsRequest newRequest) {
        return null;
    }

}


