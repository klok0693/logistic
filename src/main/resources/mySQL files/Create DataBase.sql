DROP DATABASE logistic;
CREATE DATABASE logistic DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use logistic;
SET NAMES utf8 COLLATE utf8_general_ci;

create table Users(
user_id                  int unsigned NOT NULL AUTO_INCREMENT,
username                 varchar(100) NOT NULL,
password                 varchar(100) NOT NULL,
isAccountNonExpired      tinyint(1),
isAccountNonLocked       tinyint(1),
isCredentialsNonExpired  tinyint(1),
isEnabled                tinyint(1),
role                     varchar(100),

PRIMARY KEY(user_id)
);

create table Organizations(
org_id int unsigned NOT NULL AUTO_INCREMENT,
name   varchar(70)  NOT NULL,
owner  varchar(70)  NOT NULL,

PRIMARY KEY(org_id)
);

create table Employees(
empl_id       int unsigned NOT NULL AUTO_INCREMENT,
name          varchar(40)  NOT NULL,
surname       varchar(40)  NOT NULL,
position      varchar(40)  NOT NULL,
organization  int unsigned NOT NULL,

PRIMARY KEY(empl_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id)
);

create table Managers(
manager_id  int unsigned UNIQUE,
user        int unsigned UNIQUE NOT NULL,

PRIMARY KEY(manager_id),
FOREIGN KEY(manager_id) REFERENCES Employees(empl_id),
FOREIGN KEY(user)       REFERENCES Users(user_id)
);

create table Drivers(
driver_id int unsigned UNIQUE,
driveCard varchar(100) NOT NULL,

PRIMARY KEY(driver_id),
FOREIGN KEY(driver_id) REFERENCES Employees(empl_id)
);

create table Trucks(
truck_id        int unsigned NOT NULL AUTO_INCREMENT,
model           varchar(100) NOT NULL,
registerNumber  int unsigned NOT NULL,
trailer         varchar(30)  NOT NULL,
organization    int unsigned NOT NULL,

PRIMARY KEY(truck_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id)
);

create table Clients(
client_id     int unsigned NOT NULL AUTO_INCREMENT,
name          varchar(100) NOT NULL,
organization  int unsigned NOT NULL,
type          varchar(30),

PRIMARY KEY(client_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id)
);

create table CargoList(
cargo_id         int unsigned NOT NULL AUTO_INCREMENT,
name             varchar(70)  NOT NULL,
production_date  date         NOT NULL,
shelf_date       date         NOT NULL,
size             int unsigned NOT NULL,
format           varchar(30)  NOT NULL,
type             varchar(30),

PRIMARY KEY(cargo_id)
);

create table TTN(
ttn_id         int unsigned NOT NULL AUTO_INCREMENT,
creation_date  date         NOT NULL,
end_date       date         NOT NULL,

PRIMARY KEY(ttn_id)
);

create table CargoPart(
part_id  int  unsigned NOT NULL      AUTO_INCREMENT,
cargo    int  unsigned NOT NULL,
ttn      int  unsigned NOT NULL,

PRIMARY KEY(part_id),
FOREIGN KEY(cargo)    REFERENCES CargoList(cargo_id),
FOREIGN KEY(ttn)      REFERENCES TTN(ttn_id)
);

create table Routes(
route_id      int unsigned NOT NULL AUTO_INCREMENT,
ttn           int unsigned NOT NULL,
truck         int unsigned NOT NULL,
ride_from     varchar(100) NOT NULL,
ride_to       varchar(100) NOT NULL,
arrival_date  date         NOT NULL,
arrive_date   date         NOT NULL,

PRIMARY KEY(route_id),
FOREIGN KEY(ttn)    REFERENCES TTN(ttn_id),
FOREIGN KEY(truck)  REFERENCES Trucks(truck_id)
);
