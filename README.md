# mysql_basic

<h2>Create MySql database</h2>
<code>create database user_db;</code><br>
<code>create user 'mysql_access'@'%' identified by 'mysql123';<br></code><br>
<code>grant all on db_example.* to 'mysql_access'@'%';<br></code><br>

<h2>Build</h2>
<code>cd mysql-basic-functionalities<br></code><br>
<code>mvnw spring-boot:run<br></code>

<h2>Test cases</h2>
<h3>Create new user</h3>
<code>curl localhost:8080/access/newUser -d name=[name] -d email=[email] -d phone=[phone] -d DOB=[DOB] -d gender=[M/F]</code><br>
<br>
<h3>Get all users</h3>
<code>curl localhost:8080/access/getAll</code><br>
<br>
<h3>Update user</h3>
<code>curl localhost:8080/access/update/{id} -d {enter the parameters you want to update}</code><br>
<h6>Eg. curl localhost:8080/access/update/1 -d gender=M email=abc@email.com</h6>
<br>

<h3>Get random quote</h3>
<code>curl localhost:8080/access/randomQuote</code><br>
<br>
