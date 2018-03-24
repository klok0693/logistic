insert into Roles values
('1','ROLE_CLIENT'),
('2','ROLE_MANAGER'),
('3','ROLE_OWNER'),
('4','ROLE_ADMIN');

insert into Users values
('1','manager1','pass1','0','0','0','1'),
('2','manager2','pass2','0','0','0','1'),
('3','client1','pass1','0','0','0','1'),
('4','client2','pass2','0','0','0','1');

insert into UsersRoles values
('1','2'),
('2','2'),
('3','1'),
('4','1');

insert into Organizations values ('1','Аврора-Транс','Скородумов','LogisticOrganization');

insert into Clients values
('1','Беззаботный','1','3','LogisticClient'),
('2','Беспокойный','1','4','LogisticClient');

insert into Employees values
('1','Иван','Трудгин','водитель', '1', 'TruckDriver'),
('2','Алексей','Сиделов','менеджер','1', 'LogisticManager'),
('3','Наум','Смотрелов','менеджер','1', 'LogisticManager');

insert into Drivers values ('1','вод. ндостоверение №3');

insert into Managers values
('1','1'),
('2','2');

insert into Trucks values
('1','Маз 21-107','53087','тентованый','1','TentedTruck'),
('2','Рено 307','44023','автоцистерна','1','OilTruck');

insert into StoreHouses values
('1','Гомель, Чонгарской дивизии 5','500','CargoStoreHouse'),
('2','Минск, Промышленная 19','500','CargoStoreHouse');

insert into CargoList values
('1','Пиво','30.09.17','12.01.18','1','1', '15','ящик','ProductCargo'),
('2','ps4','20.01.17','01.01.24','1', '2', '1','шт','BoxCargo');

