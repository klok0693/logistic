insert into Users values
('1','manager1','pass1','0','0','0','1','ROLE_MANAGER'),
('2','manager2','pass2','0','0','0','1','ROLE_MANAGER'),
('3','client1','pass1','0','0','0','1','ROLE_CLIENT'),
('4','client2','pass2','0','0','0','1','ROLE_CLIENT');

insert into Organizations values ('1','Аврора-Транс','Скородумов');

insert into Clients values
('1','Беззаботный','1','LogisticClient'),
('2','Беспокойный','1','LogisticClient');

insert into Employees values
('1','Иван','Трудгин','водитель', '1'),
('2','Алексей','Сиделов','менеджер','1'),
('3','Наум','Смотрелов','менеджер','1');

insert into Drivers values ('1','вод. ндостоверение №3');

insert into Managers values
('1','1'),
('2','2');

insert into Trucks values
('1','Маз 21-107','53087','тентованый','1'),
('2','Рено 307','44023','автоцистерна','1');

insert into CargoList values
('0','Пиво','30.09.17','12.01.18','15','ящик','ProductCargo'),
('1','ps4','20.01.17','01.01.24','1','шт','BoxCargo');


