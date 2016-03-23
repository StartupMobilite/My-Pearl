<?php
include_once("connection-serveur.php");
if(isset($_POST['txtUsername']) && isset($_POST['txtPassword'])){

	$username = $_POST['txtUsername'];
	$password = $_POST['txtPassword'];
	$query = "SELECT * FROM professionnelInfos WHERE username='$username' AND password='$password';";


	$result = mysqli_query($conn, $query);
	if($result->num_rows > 0){
		echo "succes";
		exit;
	}
	
	else{
		echo "erreure username et password";
		exit;
	}
	
}
?>

<html>
<head> <title>Login Professionnelle</title> </head>
  <body>
  	<h1>Login | <a href="username">pro</a> </h1>
  	<form action="<?PHP $_PHP_SELF ?>" method="post">
  		Username <input type="text" name="txtUsername" value="" placeholder="username" />
  		Password <input type="password" name="txtPassword" value="" placeholder="password"/>
  		<input type="submit" name="btnsubmit" value="Login" />
  	</form>
  </body>
</html>