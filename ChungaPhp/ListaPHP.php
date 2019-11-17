<?php
include_once('conexion.php');
         $sql = "select * from usuario where origen='API_PHP'";
         $datos = array();
         if ($resultado = $con->query($sql)) {
            while ($fila = $resultado->fetch_assoc()) {
                array_push($datos, $fila);
            }
        }else{
             echo "error";
         }
         echo json_encode($datos);
         mysqli_close($con);
      ?>
