import React from "react";
import logo from "../html-css-template/img/logo-quadra.svg";
import logoResenha from "../html-css-template/img/logo-resenha2.svg";
import TituloFormulario from "../components/titulo-form/TituloFormulario";
import CampoFormulario from "../components/campo-form/CampoFormulario";
import CampoFormularioExtended from "../components/campo-form/CampoFormularioExtended";
import BotaoFormulario from "../components/botao-form/BotaoFormulario";
import { Link } from "react-router-dom";

function PaginaCadastro() {
  return (
    <>
      <html lang="en">
        <head>
          <meta charset="UTF-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0"
          />
          <title>Cadastre-se</title>
          <link href="../css/style-cadastro.css " rel="stylesheet" />
          <link rel="preconnect" href="https://fonts.googleapis.com" />
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
          <link
            href="https://fonts.googleapis.com/css2?family=Spartan&display=swap"
            rel="stylesheet"
          />
          <link
            href="https://fonts.googleapis.com/css2?family=Spartan:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet"
          />
        </head>
        <body class="imagem-cadastro">
          <div class="header-cadastro">
            <Link to={"/"}>
              <img id="logoResenhaCadastro" src={logo} alt="" />
            </ Link>
          </div>

          <div class="container-cadastro">
            <div class="corpo-cadastro">
              <div class="corpo-cadastro-container">
                <TituloFormulario img={logoResenha} titulo="Resenha" subtitulo="Faça seu cadastro agora" />
                <form class="campo-formulario-container">
                  <div class="campo-nome">
                    <CampoFormulario nomeCampo="Nome" type="text" id="nome" name="nome" />
                    <CampoFormulario nomeCampo="Sobrenome" type="text" id="sobrenome" name="sobrenome" />
                  </div>
                  <div class="campo-email">
                    <CampoFormularioExtended nomeCampo="E-mail" type="email" id="email" name="email" />
                  </div>
                  <div class="campo-senha">
                    <CampoFormulario nomeCampo="Senha" type="password" id="senha" name="senha" />
                    <CampoFormulario nomeCampo="Confirmar Senha" type="password" id="nova_senha" name="nova_senha" />
                  </div>
                  <div class="campo-cpf">
                    <CampoFormulario nomeCampo="CPF" type="number" id="cpf" name="cpf" />
                  </div>
                  <div class="campo-telefone">
                    <CampoFormulario nomeCampo="Telefone" type="number" id="telefone" name="telefone" />
                  </div>
                </form>
                <BotaoFormulario textoBotao="Criar Conta" textoFooter="Já possui login?" redirectFooter="ACESSE AGORA" destino="/login" />
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}
export default PaginaCadastro;
