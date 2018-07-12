<?php
require_once('dbConnect.php');

$sql = "select * from barangKeluar";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaBarang= $row['namaBarang'];
  $jumlahBarang=$row['jumlahBarang'];
  $tglBarang =$row['tglKeluar'];
        $data_array[]=array('namaBarang'=>$namaBarang,'jumlahBarang'=>$jumlahBarang,'tglKel'=>$tglBarang);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
?>
