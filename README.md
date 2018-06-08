# SD Overflow

## A web discussion platform developed for students and alumni of Skill Distillery.

#### By _**Rebecca Allen, Richard Blankenhorn, Mark Coleman, Miranda Martin and Xian Zheng**_

## Live Web Interaction

* If you want to interact with the finished program, please visit: [SD Overflow](http://18.216.14.184:8080/OverflowRest/).
* See the program specifications below for routes to use.

## Setup/Installation Requirements

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

## Behavior/Usage
* People without an account will have a limited experience when interacting with the application. They will only be able to view the 'home', 'about', 'login', and 'register' pages.
* For the full user experience, you must sign up for an account or be a logged in user.
* Logged in users will be able to view posts and comments.
* Logged in users will be able to make posts and comments.
* Logged in users will be able to delete their own posts and comments.
* Logged in users will be able to vote on comments.
* Logged in users will be able to view their own profile and posts.
* Logged in users will be able to edit their own profile.
* Logged in users will be able to view the posts and a limited version of the profiles of other users.
* Logged in users will be able to view a list of employers and locations of employers.
* Logged in users will be able to log out.

## Project Setup
#### What we did:
* Create a Database in MySQL Workbench, with data inserted into each table for testing purposes.
* Create a new Java project in Spring.
* Java project has Gradle nature, and entities package, META-INF folder to house a persistense xml and a test package.
* Annotate the entities classes based on the tables in the database.
* Establish One to Many, Many to Many relationships and annotate accordingly.
* Create tests for the mapping routes.
* Create a Spring REST project, with Gradle nature.
* REST project will need packages for Tests, Repositiories, Controllers and Services.
* Service is an interface, ServiceImpl is a class. These act as a DAO and DAOImpl.
* Route the Controllers.
* The repository extends the JPA Repository which does all the SQL statements for normal CRUD functionality for you.
* Write SQL statements in each individual repository if you are creating methods that access the database.
* Test all routes with Postman and make sure you are accessing the database.
* Create a new Angular project using ng new in the command line.
* Create components, services and classes using the ngCli.
* Use ng serve -o in the command line to see the user interface.
* Add templates or html to the html pages to support the various functionality and routing of the services and components.
* Create an AuthService to restrict functionality and protect user data.

## Technologies Used

_This program was made RESTfully, utilizing Java, MySql, Javascript, Angular, Gradle, Spring Tool Suite, Apache Tomcat, MAMP, Atom and the Eclipse Integrated Development Environment._

## Support and Contact Details

_Please contact [Rebecca Allen](RebeccaZarsky@gmail.com), [Richard Blankenhorn](rsbnq6@yahoo.com), [Mark Coleman](setyourgoalsss@gmail.com), [Miranda Martin](chopsticksally@yahoo.com) or [Xian Zheng](zhengx2012@fau.edu) for technical questions or assistance running the program._

## License

_This program is licensed under the MIT license._

Copyright (c) 2018 **_Rebecca Allen, Richard Blankenhorn, Mark Coleman, Miranda Martin and Xian Zheng_**
