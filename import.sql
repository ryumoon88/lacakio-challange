USE lacakio_challange;

CREATE TABLE `cities` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ascii` varchar(255) DEFAULT NULL,
  `alt_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `latitude` DECIMAL DEFAULT NULL,
  `longitude` DECIMAL DEFAULT NULL,
  `feat_class` char(1) DEFAULT NULL,
  `feat_code` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `cc2` char(10) DEFAULT NULL,
  `admin1` varchar(255) DEFAULT NULL,
  `admin2` char(10) DEFAULT NULL,
  `admin3` char(10) DEFAULT NULL,
  `admin4` char(10) DEFAULT NULL,
  `population` int DEFAULT NULL,
  `elevation` int DEFAULT NULL,
  `dem` int DEFAULT NULL,
  `tz` varchar(255) DEFAULT NULL,
  `modified_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOAD DATA INFILE '/docker-entrypoint-initdb.d/data.csv'
INTO TABLE cities
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(@id, @name, @ascii, @alt_name, @latitude, @longitude, @feat_class, @feat_code,
 @country, @cc2, @admin1, @admin2, @admin3, @admin4,
 @population, @elevation, @dem, @tz, @modified_at)
SET
    id = @id,
    name = @name,
    ascii = @ascii,
    alt_name = @alt_name,
    latitude = @latitude,
    longitude = @longitude,
    feat_class = @feat_class,
    feat_code = @feat_code,
    country = @country,
    cc2 = NULLIF(@cc2, ''),
    admin1 = NULLIF(@admin1, ''),
    admin2 = NULLIF(@admin2, ''),
    admin3 = NULLIF(@admin3, ''),
    admin4 = NULLIF(@admin4, ''),
    population = NULLIF(@population, ''),
    elevation = NULLIF(@elevation, ''),
    dem = NULLIF(@dem, ''),
    tz = @tz,
    modified_at = NULLIF(@modified_at, '');
