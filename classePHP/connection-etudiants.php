<?php

include_once("connection-serveur.php");
if(isset($_POST['txtUsername']) && isset($_POST['txtPassword'])){

	$username = $_POST['txtUsername'];
	$password = $_POST['txtPassword'];
	$query = "SELECT * FROM etudiantsInfos WHERE username='$username' AND password='$password'";


	$result = mysqli_query($conn, $query);
	if($result->num_rows > 0){
		echo "succes";
		exit;
	}
	
}
?>

<html>
<head> <title>Login Etudiants</title> </head>
  <body>
  	<h1>Login | <a href="username">etudiants</a> </h1>
  	<form action="<?PHP $_PHP_SELF ?>" method="post">
  		Username <input type="text" name="txtUsername" value="" placeholder="username" />
  		Password <input type="password" name="txtPassword" value="" placeholder="password"/>
  		<input type="submit" name="btnsubmit" value="Login" />
  		<input type="submit" name="btnsubmit2" value="register" />
  	</form>
  </body>
</html>