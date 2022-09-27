DROP TABLE IF EXISTS car_data;

CREATE TABLE car_data
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     UUID default random_uuid(),
    brand_name  VARCHAR(128) NOT NULL,
    licenseplate VARCHAR(128) NOT NULL,
    manufacturer       VARCHAR(128) ,
    operation_city       VARCHAR(128) ,
    status       VARCHAR(128) NOT NULL,
    createrAt timestamp,
    updatedAt timestamp
);