<?php
require_once('dbConnect.php');

$sql = "select concat(castBK,idBK) as 'idBK', idBarang ,namaBarang,jumlahBarang,tglKeluar,tujuanBarang from barangKeluar";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaBarang= $row['namaBarang'];
  $jumlahBarang=$row['jumlahBarang'];
  $tglBarang =$row['tglKeluar'];
  $tujuanBarang = $row['tujuanBarang'];
  $idbk = $row['idBK'];
        $data_array[]=array(
          'idBK'=>$idbk,
          'namaBarang'=>$namaBarang,
          'jumlahBarang'=>$jumlahBarang,
          'tglKel'=>$tglBarang,
          'tujuanBarang'=>$tujuanBarang);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
