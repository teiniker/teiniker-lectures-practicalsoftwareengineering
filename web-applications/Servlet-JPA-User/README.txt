How to start and stop the MySQL server?
-------------------------------------------------------------------------------

$ su
root66

# systemctl start mariadb.service

# systemctl stop mariadb.service


How to deploy the application?
-------------------------------------------------------------------------------

Run Wildfly in the Servers tab.
And and Remove...
	=> Maven-JPA
	

How to test the JPA code inside the container?
-------------------------------------------------------------------------------

http://localhost:8080/Maven-JPA/test?action=insert&name=homer
http://localhost:8080/Maven-JPA/test?action=insert&name=marge

http://localhost:8080/Maven-JPA/test?action=findAll


How to review the created DB tables?
-------------------------------------------------------------------------------

$ mysql -u student -p
Enter password: student

MariaDB [(none)]> use testdb;

MariaDB [testdb]> show tables;
+--------------------+
| Tables_in_testdb   |
+--------------------+
| User               |
| hibernate_sequence |
+--------------------+




