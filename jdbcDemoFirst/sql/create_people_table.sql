USE people;

DROP TABLE IF EXISTS `persons`;

CREATE TABLE persons 
(id int not null primary key AUTO_INCREMENT, name varchar(45) not null, birthday date not null)