LOAD DATA INFILE '/docker-entrypoint-initdb.d/yourfile.tsv'
INTO TABLE cities
FIELDS TERMINATED BY '\t'
ENCLOSED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 LINES;
