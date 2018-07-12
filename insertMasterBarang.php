<?php
require_once('dbConnect.php');

 $idBarang = $_POST['idBarang'];
 $namaBarang = $_POST['namaBarang'];
 $stokBarang = $_POST['stokBarang'];

 $querry = "insert into masterBarang(idBarang, namaBarang,stokBarang)
               values ('$idBarang','$namaBarang',$stokBarang)";

if(mysqli_query($con,$querry)){
  echo 'Data Inserted Successfully';
}
else{
  echo 'Try Again';
}
mysqli_close($con);
?>
