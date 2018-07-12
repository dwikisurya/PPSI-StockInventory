<?php
require_once('dbConnect.php');

$sql = "select * from masterBarang";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaBarang= $row['namaBarang'];
  $idbarang= $row['idBarang'];
  $stokBarang= $row['stokBarang'];
        $data_array[]=array(
          'idBarang'=>$idbarang,
          'namaBarang'=>$namaBarang,
          'stokBarang'=>$stokBarang);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
