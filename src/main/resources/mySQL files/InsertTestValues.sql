insert into Roles values
('1','user'),
('2','admin');

insert into UsersRoles values
('1','1'),
('2','1'),
('3','1'),
('4','1');

insert into Users values
('1','manager1','pass1','0','0','0','1'),
('2','manager2','pass2','0','0','0','1'),
('3','client1','pass1','0','0','0','1'),
('4','client2','pass2','0','0','0','1');

insert into Organizations values ('1','Аврора-Транс','Скородумов');

insert into Clients values
('1','Беззаботный','1','3'),
('2','Беспокойный','1','4');

insert into Employees values
('1','Иван','Трудгин','водитель', '1'),
('2','Алексей','Сиделов','менеджер','1'),
('3','Наум','Смотрелов','менеджер','1');

insert into Drivers values ('1','вод. ндостоверение №3');

insert into Managers values
('2','1'),
('3','2');

insert into Trucks values
('1','Маз 21-107','53087','тентованый','1'),
('2','Рено 307','44023','автоцистерна','1');

insert into CargoList values
('1','Пиво','30.09.17','12.01.18','1','15','ящик'),
('2','ps4','20.01.17','01.01.24','1','1','шт');


