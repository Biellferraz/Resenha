import React from "react";
import logo from "../html-css-template/img/logo-resenha2.svg";
import logoQuadra from "../html-css-template/img/logo-quadra.svg";
import TituloFormulario from "../components/titulo-form/TituloFormulario";
import CampoFormularioExtended from "../components/campo-form/CampoFormularioExtended";
import BotaoFormulario from "../components/botao-form/BotaoFormulario";


function PaginaLogin() {
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
          <link href="../css/style-login.css " rel="stylesheet" />
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
        <body class="imagem-login">
          <div class="header-login">
            <img src={logo} alt="" />
          </div>

          <div class="container-login">
            <div class="corpo-login">
              <div class="corpo-login-container">
                <TituloFormulario img={logoQuadra} titulo="Resenha" subtitulo="Acesse já nossa aplicação" />
                <form class="campo-form-login-container">
                  <div class="campo-email-login">
                    <CampoFormularioExtended nomeCampo="E-mail" type="email" id="email" name="email" />
                  </div>
                  <div class="campo-senha-login">
                    <CampoFormularioExtended nomeCampo="Senha" type="password" id="passwrd" name="password" />
                  </div>
                </form>
                <BotaoFormulario textoBotao="Entrar" textoFooter="Não possui conta ainda?" redirectFooter="CADASTRE-SE AGORA" />
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}

export default PaginaLogin;