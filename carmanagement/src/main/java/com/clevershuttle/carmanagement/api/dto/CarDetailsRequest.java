package com.clevershuttle.carmanagement.api.dto;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

public class CarDetailsRequest {

    @NotBlank
    private String brand;

    @NotBlank
    private String licensePlate;

    @NotBlank
    private String Manufacturer;

    @NotBlank
    private String operationCity;

    private String Status;

    private Timestamp createdAt;

    private Timestamp lastUpdatedAt;

    public CarDetailsRequest(String brand, String licensePlate,
                             String manufacturer, String operationCity,
                             String status, Timestamp createdAt, Timestamp lastUpdatedAt) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        Manufacturer = manufacturer;
        this.operationCity = operationCity;
        Status = status;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getOperationCity() {
        return operationCity;
    }

    public String getStatus() {
        return Status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDetailsRequest that = (CarDetailsRequest) o;
        return Objects.equals(brand, that.brand) && Objects.equals(licensePlate, that.licensePlate) && Objects.equals(Manufacturer, that.Manufacturer) && Objects.equals(operationCity, that.operationCity) && Objects.equals(Status, that.Status) && Objects.equals(createdAt, that.createdAt) && Objects.equals(lastUpdatedAt, that.lastUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, licensePlate, Manufacturer, operationCity, Status, createdAt, lastUpdatedAt);
    }
}
