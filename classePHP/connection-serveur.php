<?php
$servername = "mysql.hostinger.fr";
$username = "u804455768_admin";
$password = "jdes1704";
$dbname = "u804455768_perle";


$conn = mysqli_connect ($servername,$username,$password,$dbname);

if(!$conn){
	die ("erreur de connection ".mysqli_connect_error());
}

?>