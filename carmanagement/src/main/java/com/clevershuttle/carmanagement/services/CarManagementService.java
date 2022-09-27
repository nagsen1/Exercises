package com.clevershuttle.carmanagement.services;

import com.clevershuttle.carmanagement.api.dto.CarDetailsRequest;
import com.clevershuttle.carmanagement.api.dto.CarDetailsResponse;
import com.clevershuttle.carmanagement.persistance.CarDetailsEntity;

public interface CarManagementService {

    CarDetailsEntity createCarDetails(String userId, CarDetailsRequest newRequest);

    CarDetailsResponse getCarDetails(String userId);

    CarDetailsResponse updateCarDetails(String userId, CarDetailsRequest newRequest);

}
