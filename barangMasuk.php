<?php
require_once('dbConnect.php');

$sql = "select concat(castBM,idBM) as 'idBM', idBarang,namaBarang,jumlahBarang,tglMasuk,supplier from barangMasuk";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaBarang= $row['namaBarang'];
  $jumlahBarang=$row['jumlahBarang'];
  $tglBarang =$row['tglMasuk'];
  $supplier = $row['supplier'];
  $idbm = $row['idBM'];
        $data_array[]=array(
          'idBM'=>$idbm,
          'namaBarang'=>$namaBarang,
          'jumlahBarang'=>$jumlahBarang,
          'tglMasuk'=>$tglBarang,
          'supplier'=>$supplier);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
