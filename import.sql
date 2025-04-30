USE lacakio_challange;

CREATE TABLE `cities` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ascii` varchar(255) DEFAULT NULL,
  `alt_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
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

LOAD DATA INFILE '/docker-entrypoint-initdb.d/yourfile.tsv'
INTO TABLE cities
FIELDS TERMINATED BY '\t'
ENCLOSED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 LINES;
