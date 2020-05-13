# mysql_basic

<h2>Create MySql database</h2>
<code>create database user_db;</code><br>
<code>create user 'mysql_access'@'%' identified by 'mysql123';<br></code><br>
<code>grant all on db_example.* to 'mysql_access'@'%';<br></code><br>

<h2>Build</h2>
<code>cd mysql-basic-functionalities<br></code><br>
<code>mvnw spring-boot:run<br></code>
