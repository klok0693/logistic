SET GLOBAL tx_isolation='READ-COMMITTED';
CREATE DATABASE IF NOT EXISTS logistic;
GRANT ALL PRIVILEGES ON logistic.* TO logistic_Manager@localhost identified BY 'l78';
GRANT FILE ON *.* TO 'logistic_Manager'@'localhost';