<?php
include_once("connection-serveur.php");

if(isset($_POST["submit"])){
$user = $_POST['txtUsername'];
$pass = $_POST['txtPassword'];
$newPass = $_POST['newPassword'];
$email = $_POST['mail'];

mysql_select_db('connection') or die ('connection impossible');

$query = mysql_query("SELECT * FROM connection WHERE username='".$user."'");
$numrows=mysql_num_rows($query);
if($numeros){
$sql = "INSERT INTO connection (username,password,newpassword,mail) VALUES ('$user','$pass','$newPass','$email')";

$resultat = mysql_query($sql);

if($resultat){
echo "succes creation";
}else {
echo "echec";
}
}else{
echo "username existe deja";
}
}
	
?>

<html>
<head> <title>Login Professionnelle</title> </head>
  <body>
  	<h1><a href="login.php">login</a> | <a href="identifiant.php">identifiant</a> </h1>
  	<form action="<?PHP $_PHP_SELF ?>" method="post">
  		Username <input type="text" name="txtUsername" value="" placeholder="username" />
  		Password <input type="password" name="txtPassword" value="" placeholder="enter password"/>
  		newPassword <input type="password" name="newPassword" value="" placeholder="enter new password"/>
  		Email <input type="text" name="mail" value="" placeholder="adresse mail"/>
  		<input type="submit" name="btnsubmit" value="login" />
  	</form>
  </body>
</html>