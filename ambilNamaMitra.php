<?php
require_once('dbConnect.php');

$sql = "select * from mitra";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaMitra = $row['namaMitra'];
  $idMitra = $row['idMitra'];
        $data_array[]=array(
          'idMitra'=>$idMitra,
          'namaMitra'=>$namaMitra);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
