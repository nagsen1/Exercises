package com.clevershuttle.carmanagement.endpoint;

import com.clevershuttle.carmanagement.api.dto.CarDetailsRequest;
import com.clevershuttle.carmanagement.api.dto.CarDetailsResponse;
import com.clevershuttle.carmanagement.persistance.CarDetailsEntity;
import com.clevershuttle.carmanagement.services.CarManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carmanagement/{uuid}")
public class CarDetailsEndpoint {

    Logger logger = LoggerFactory.getLogger(CarDetailsEndpoint.class);

    @Autowired
    private CarManagementService carManagementService;

    @GetMapping()
    public CarDetailsResponse getCustomer( @PathVariable("uuid") String userId) {
        logger.info("Fetching a new car detail info with userId: " , userId);
        return carManagementService.getCarDetails(userId);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public CarDetailsResponse putCustomer (@PathVariable("uuid") String userId, @RequestBody final CarDetailsRequest carDetailsrRequestValue) {
        logger.info("UPdating a new car detail info with userId: " , userId);
        return carManagementService.updateCarDetails(userId, carDetailsrRequestValue);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CarDetailsEntity postCustomer ( @PathVariable("uuid") String userId, @RequestBody final CarDetailsRequest carDetailsRequestValue) {
        logger.info("Creating a new car detail info with userId: " , userId);
        return carManagementService.createCarDetails(userId, carDetailsRequestValue);
    }

}
