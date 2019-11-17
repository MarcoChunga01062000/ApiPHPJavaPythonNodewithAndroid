<?php
include_once('conexion.php');
$id = $_REQUEST["id"];
$nombre = $_REQUEST["name"];
$correo = $_REQUEST["correo"];
$pass = $_REQUEST["pass"];
$sql = "update usuario set name='$nombre',correo='$correo', pass='$pass', origen='API_PHP' where idusuario='$id'";
$datos = array();
$res = $con->query($sql);
echo $res;
