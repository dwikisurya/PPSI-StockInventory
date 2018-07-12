<?php
require_once('dbConnect.php');

$sql = "select concat(castMB,idMB) as 'idMB',pemintaMB,barangMB,jumlahMB,tglMB from mintaBarang";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $idMB= $row['idMB'];
  $pemintaMB=$row['pemintaMB'];
  $barangMB =$row['barangMB'];
  $jumlahMB = $row['jumlahMB'];
  $tglMB = $row['tglMB'];
        $data_array[]=array(
          'idMB'=> $idMB,
          'pemintaMB'=>$pemintaMB,
          'barangMB'=>$barangMB,
          'jumlahMB'=>$jumlahMB,
          'tglMB'=>$tglMB);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
