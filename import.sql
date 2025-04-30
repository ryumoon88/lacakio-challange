LOAD DATA INFILE '/docker-entrypoint-initdb.d/yourfile.tsv'
INTO TABLE 'lacakio-challange'
FIELDS TERMINATED BY '\t'
ENCLOSED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 LINES;
