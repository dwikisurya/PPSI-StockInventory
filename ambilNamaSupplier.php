<?php
require_once('dbConnect.php');

$sql = "select * from supplier";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaSupplier= $row['namaSupplier'];
  $idSupplier= $row['idSupplier'];
        $data_array[]=array(
          'idSupplier'=>$idSupplier,
          'namaSupplier'=>$namaSupplier);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
