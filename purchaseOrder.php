<?php
require_once('dbConnect.php');

$sql = "select concat(castPO,idPO) as 'idPO', idSupplier, namaBarang, jumlahBarang,hargaBarang,discountBarang, grandTotal from purchaseOrder";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $idPO = $row['idPO'];
  $idSupplier =$row['idSupplier'];
  $namaBarang =$row['namaBarang'];
  $jumlahBarang = $row['jumlahBarang'];
  $hargaBarang = $row['hargaBarang'];
  $discountBarang = $row['discountBarang'];
  $grandTotal = $row['grandTotal'];
        $data_array[]=array(
          'idPO'=>$idPO,
          'idSupplier'=>$idSupplier,
          'namaBarang'=>$namaBarang,
          'jumlahBarang'=>$jumlahBarang,
          'hargaBarang'=>$hargaBarang,
          'discountBarang'=>$discountBarang,
          'grandTotal'=>$grandTotal );
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
