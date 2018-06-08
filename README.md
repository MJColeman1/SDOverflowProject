### SDOverflowProject

### What we did:
1. Create a Database, in MySQL Workbench, with data inserted into each table for testing purposes.
2. Create a new Java project in Spring.
3. Java project has Gradle nature, and entities package, META-INF folder to house a persistense xml and a test package.
4. Annotate the entities classes based on the tables in the database.
5. Establish One to Many, Many to Many realtionships and annotate accordingly.
5. Create tests for the mapping routes.
6. Create a Spring REST project, with Gradle nature.
7. REST project will need packages for Tests, Repositiories, Controllers and Services.
8. Services is an interface, ServiceImpl is a class. These act as a DAO and DAOImpl.
9. Route the Controllers.
10. The repository extends the JPA Repository which does all the SQL statements for normal CRUD functionality for you.
11. Write SQL statements in each individual repository if you are creating methods that access the database.
12. Test all routes with Postman and make sure you are accessing the database.
13. Create a new Angular project using ng new in the command line.
14. Create components, services and classses using the ngCli.
15. Use ng serve -o in the command line to see the user interface.
16. Add templates or html to the html pages to support the various functionality and routing of the services and components.
17. Create an AuthService to restrict functionalty and protect user data.

## Setup/Installation requirements

* In order to edit this project and work with it on your own machine you will need a terminal application such as Terminal or Bash. Since this project has a Gradle nature, you will need to have the Spring Tool Suite installed. You will also need a database server program such as MAMP or LAMP.
* Start by opening the terminal application and typing the command
```
git clone https://github.com/MJColeman1/SDOverflowProject
```
after navigating with the `cd` command to the location you would like the project to be cloned into.
* Use the terminal application to navigate to the project directory you just cloned down off of GitHub using the "cd" command.
* If at any point during this next part of the set up process you get a popup system window to enter a password, it is asking for your computer user account password. Start by opening up your MAMP or LAMP. From the preferences menu of the application, select "Ports" and "Set Web and MySQL ports to 80 & 3306". Select to "Start Servers" from the main window of your application. Return to your terminal, you will need to set up the included games.sql database in order to correctly interact with this program. You will be typing a series of commands in the terminal.
```
mysql -u root -p < sdoverflowdb.sql
mysql -u root -p
```
You will then be prompted to enter a password in the terminal, type `root`.
```
mysql> CREATE USER sdoverflowuser@localhost IDENTIFIED BY 'skills';
mysql> exit;
mysql -u sdoverflowuser -p
```

## Technologies Used

_This program was made RESTfully, utilizing Java, MySql, Javascript, Angular, Gradle, Spring Tool Suite, Apache Tomcat, MAMP, Atom and the Eclipse Integrated Development Environment._

## Support and Contact Details

_Please contact [Rebecca Allen](RebeccaZarsky@gmail.com), [Richard Blankenhorn](), [Mark Coleman](), [Miranda Martin](), [Xian Zheng]() for technical questions or assistance running the program._

## License

_This program is licensed under the MIT license._

Copyright (c) 2018 **_Rebecca Allen, Richard Blankenhorn, Mark Coleman, Miranda Martin, Xian Zheng_**
