<?php
require_once('dbConnect.php');

 $idBarang = $_POST['idBarang'];
 $idMitra = $_POST['idMitra'];
 $pemintaMB = $_POST['pemintaMB'];
 $barangMB = $_POST['barangMB'];
 $jumlahMB = $_POST['jumlahMB'];
 $tglMB = $_POST['tglMB'];

 $querry = "insert into mintaBarang(idMitra, idBarang,pemintaMB,barangMB,jumlahMB, tglMB)
               values ('$idMitra','$idBarang','$pemintaMB','$barangMB',$jumlahMB, '$tglMB')";

if(mysqli_query($con,$querry)){
  echo 'Data Inserted Successfully';
}
else{
  echo 'Try Again';
}

?>
