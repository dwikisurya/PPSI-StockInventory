<?php
require_once('dbConnect.php');

 $idBarang = $_POST['idBarang'];
 $namaBarang = $_POST['namaBarang'];
 $jumlahBarang = $_POST['jumlahBarang'];
 $tglKeluar = $_POST['tglKeluar'];
 $tujuanBarang = $_POST['tujuanBarang'];

 $querry = "insert into barangKeluar(idBarang, namaBarang,jumlahBarang,tglKeluar,tujuanBarang)
               values ('$idBarang','$namaBarang',$jumlahBarang,'$tglKeluar', '$tujuanBarang')";

if(mysqli_query($con,$querry)){
  echo 'Data Inserted Successfully';
}
else{
  echo 'Try Again';
}
mysqli_close($con);
?>
