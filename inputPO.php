<?php
require_once('dbConnect.php');

 $idSupplier = $_POST['idSupplier'];
 $namaBarang = $_POST['namaBarang'];
 $tglPO	=$_POST['tglPO'];
 $jumlahBarang = $_POST['jumlahBarang'];
 $hargaBarang =$_POST['hargaBarang'];
 $discount = $_POST['discount'];


 $querry = "insert into purchaseOrder(idSupplier,namaBarang, tglPO, jumlahBarang, hargaBarang, discountBarang) values ('$idSupplier','$namaBarang',$tglPO,$jumlahBarang, $hargaBarang,$discount)";

if(mysqli_query($con,$querry)){
  echo 'Data Inserted Successfully';
}
else{
  echo 'Try Again';
}
mysqli_close($con);
?>
