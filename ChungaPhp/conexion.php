<?php
$dbhost = 'localhost:3306';
$dbuser = 'root';
$dbpass = '';
$bd = 'apis';
$con = mysqli_connect($dbhost, $dbuser, $dbpass,$bd );

if(! $con ){
   die('Could not connect: ' . mysqli_error());
}
?>