CREATE TABLE cities(id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100), population INT);

INSERT INTO cities(id, name, population) VALUES(1,'Bratislava', 432000);
INSERT INTO cities(id, name, population) VALUES(2,'Budapest', 1759000);
INSERT INTO cities(id, name, population) VALUES(3,'Prague', 1280000);
INSERT INTO cities(id, name, population) VALUES(4,'Warsaw', 1748000);
INSERT INTO cities(id, name, population) VALUES(5,'Los Angeles', 3971000);
INSERT INTO cities(id, name, population) VALUES(6,'New York', 8550000);
INSERT INTO cities(id, name, population) VALUES(7,'Edinburgh', 464000);
INSERT INTO cities(id, name, population) VALUES(8,'Suzhou', 4327066);
INSERT INTO cities(id, name, population) VALUES(9,'Zhengzhou', 4122087);
INSERT INTO cities(id, name, population) VALUES(10,'Berlin', 3671000);

INSERT INTO persona(id, nombre, city_id) VALUES(1,'Esteban', 1);
INSERT INTO persona(id, nombre, city_id) VALUES(2,'Andres', 2);
INSERT INTO persona(id, nombre, city_id) VALUES(3,'Juan', 3);