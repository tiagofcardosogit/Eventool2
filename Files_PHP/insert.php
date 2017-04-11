<?php

include ("connect.php");

$nome = "Usuario";
$cidade = "Rio de Janeiro";
$ano = 2017;

$sql = "INSERT INTO usuario (id_usuario, nome, sobrenome, genero, email, telefone, senha)
VALUES ('$id_usuario, '$nome', '$sobrenome', '$genero', '$email', '$telefone', '$senha')";

if ($conn->query($sql) === TRUE) {
	$myObj = array('status' => '1', 'message' => 'Inserido com sucesso!');
    echo json_encode($myObj);
} else {
	$myObj = array('status' => '0', 'message' => 'Falha ao inserir...');
    echo json_encode($myObj);
}

$conn->close();

?>
