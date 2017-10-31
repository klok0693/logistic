CREATE DATABASE logistic;
use logistic;
alter database `logistic` character set utf8;
set names utf8;
set collation_connection = utf8_general_ci;

create table Organizations(
org_id int unsigned NOT NULL AUTO_INCREMENT,
name   varchar(70)  NOT NULL,
owner  varchar(70)  NOT NULL,

PRIMARY KEY(org_id)
);

create table Employees(
empl_id int unsigned NOT NULL AUTO_INCREMENT,
name          varchar(40)  NOT NULL,
surname       varchar(40)  NOT NULL,
position      varchar(40)  NOT NULL,
organization  int unsigned NOT NULL,

PRIMARY KEY(empl_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id) ON DELETE cascade ON UPDATE cascade
);

create table Trucks(
truck_id        int unsigned NOT NULL AUTO_INCREMENT,
model           varchar(100) NOT NULL,
registerNumber  int unsigned NOT NULL,
trailer         varchar(30)  NOT NULL,
organization    int unsigned NOT NULL,

PRIMARY KEY(truck_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id) ON DELETE cascade ON UPDATE cascade
);

create table Clients(
client_id     int unsigned NOT NULL AUTO_INCREMENT,
name          varchar(100) NOT NULL,
organization  int unsigned NOT NULL,

PRIMARY KEY(client_id),
FOREIGN KEY(organization) REFERENCES Organizations(org_id) ON DELETE cascade ON UPDATE cascade
);

create table CargoList(
cargo_id         int unsigned NOT NULL AUTO_INCREMENT,
name             varchar(70)  NOT NULL,
production_date  date         NOT NULL,
shelf_date       date         NOT NULL,
owner            int unsigned NOT NULL,
size             int unsigned NOT NULL,
format           varchar(30)  NOT NULL,

PRIMARY KEY(cargo_id),
FOREIGN KEY(owner) REFERENCES Clients(client_id) ON DELETE cascade ON UPDATE cascade
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
FOREIGN KEY(cargo)    REFERENCES CargoList(cargo_id) ON UPDATE cascade,
FOREIGN KEY(ttn)      REFERENCES TTN(ttn_id) ON DELETE cascade ON UPDATE cascade
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
FOREIGN KEY(ttn)    REFERENCES TTN(ttn_id) ON UPDATE cascade,
FOREIGN KEY(truck)  REFERENCES Trucks(truck_id) ON UPDATE cascade
);
