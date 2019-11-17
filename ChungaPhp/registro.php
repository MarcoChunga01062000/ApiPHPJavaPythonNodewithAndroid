<?php
include_once('conexion.php');
$nombre = $_REQUEST["name"];
$correo = $_REQUEST["correo"];
$pass = $_REQUEST["pass"];
$sql = "insert into usuario values(null,'$nombre','$correo', '$pass', 'API_PHP')";
$res = $con->query($sql);
echo $res;
