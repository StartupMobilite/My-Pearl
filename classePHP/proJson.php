<?php
 include_once("connection-serveur.php");

 $query = " SELECT * FROM professionnelInfos ORDER BY id DESC ";

 $result = mysqli_query($conn, $query);

 while($row = mysqli_fetch_assoc($result)){
 	$data[] = $row;
 }

 echo json_encode($data);
?>