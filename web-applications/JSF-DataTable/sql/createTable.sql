
CREATE TABLE article 
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description VARCHAR(255) NOT NULL,
	price INT
) ENGINE = INNODB;

INSERT INTO article (description, price) VALUES ('Design Patterns', 4295);
INSERT INTO article (description, price) VALUES ('Effective Java (2nd Edition)', 3336);
	