<?php

 include_once("connection-serveur.php");

 
$sql = "select * from etudiantsInfos";
 
$res = mysqli_query($conn,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('id'=>$row[0],
'username'=>$row[1],
'email'=>$row[5],
'telephone'=>$row[6],
'etablissements'=>$row[7],
'fonction'=>$row[8],
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($conn);
 
?>