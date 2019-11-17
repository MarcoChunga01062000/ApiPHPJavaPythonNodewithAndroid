<?php
include_once('conexion.php');
$id = $_REQUEST["id"];
$sql = "delete from usuario where idusuario='$id'";
$datos = array();
$res = $con->query($sql);
echo $res;
