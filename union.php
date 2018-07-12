<?php
require_once('dbConnect.php');

$sql = "select namaBarang, jumlahBarang, tglKeluar, '' as 'tglMasuk',tujuanBarang ,'' as 'supplier'from barangKeluar union select namaBarang, jumlahBarang, '' ,tglMasuk, '' ,supplier from barangMasuk";
$result = mysqli_query($con, $sql);
$data_array = array();

while ($row = mysqli_fetch_assoc($result)){
  $namaBarang= $row['namaBarang'];
  $jumlahBarang= $row['jumlahBarang'];
  $tglKeluar= $row['tglKeluar'];
  $tglMasuk= $row['tglMasuk'];
  $tujuanBarang= $row['tujuanBarang'];
  $supplier= $row['supplier'];
        $data_array[]=array(
          'namaBarang'=>$namaBarang,
          'jumlahBarang'=>$jumlahBarang,
	'tglKeluar'=>$tglKeluar,
	'tglMasuk'=>$tglMasuk,
	'tujuanBarang'=>$tujuanBarang,
	'supplier'=>$supplier);
    }

    echo $jsonformat=json_encode(array("result"=>$data_array));
     mysqli_close($con);
?>
