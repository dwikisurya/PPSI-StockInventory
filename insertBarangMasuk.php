<?php
require_once('dbConnect.php');

 $idBarang = $_POST['idBarang'];
 $namaBarang = $_POST['namaBarang'];
 $jumlahBarang = $_POST['jumlahBarang'];
 $tglMasuk = $_POST['tglMasuk'];
 $supplier = $_POST['supplier'];

 $querry = "insert into barangMasuk(idBarang, namaBarang,jumlahBarang,tglMasuk,supplier)
               values ('$idBarang','$namaBarang',$jumlahBarang,'$tglMasuk', '$supplier')";

if(mysqli_query($con,$querry)){
  echo 'Data Inserted Successfully';
}
else{
  echo 'Try Again';
}
mysqli_close($con);
?>
