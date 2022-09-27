package com.clevershuttle.carmanagement.api.dto;

import java.sql.Timestamp;
import java.util.Objects;

public class CarDetailsResponse extends CarDetailsRequest{

    private String carId;

    public CarDetailsResponse(String brand, String licensePlate,
                              String manufacturer, String operationCity,
                              String status, Timestamp createdAt, Timestamp lastUpdatedAt) {
        super(brand, licensePlate,
                manufacturer, operationCity,
                status, createdAt, lastUpdatedAt);
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarDetailsResponse that = (CarDetailsResponse) o;
        return Objects.equals(carId, that.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carId);
    }
}
