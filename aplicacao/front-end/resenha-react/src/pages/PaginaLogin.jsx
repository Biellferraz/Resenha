import React from "react";
import logo from "../html-css-template/imagens/pessoa-logo.png";
import logoQuadra from "../html-css-template/imagens/logo-quadra.png";
import imagemFundo from "../html-css-template/imagens/quadra-login.png";


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
          <title>Faça login</title>
          <link href="../css/style-login.css" rel="stylesheet" />
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
        <body class="imagem">
          <div class="header-login">
            <img src={logo} alt="" />
          </div>
          <div class="container-login">
            <div class="corpo-login">
              <div class="components-logo">
                <img src={logoQuadra} alt="" />
              </div>
              <div class="components-leights">
                <p>RESENHA</p>
              </div>
              <div class="components-lineone"></div>
              <div class="components-linetwo"></div>
              <div class="components-text">
                <p>
                  ACESSE JÁ NOSSA <b>APLICAÇÃO</b>
                </p>
              </div>
              <div class="components-email">
                <p>EMAIL</p>
              </div>
              <div class="components-senha">
                <p>SENHA</p>
              </div>
              <div class="components-text-aviso">
                <p>
                  NÃO POSSUI UMA CONTA AINDA? <b>CADASTRE-SE AGORA</b>
                </p>
              </div>
              <div class="contato-form-sendbutton">
                <button>Enviar</button>
              </div>
              <div class="components-input-email">
                <input
                  type="input"
                  class="form__email"
                  placeholder=""
                  name="email"
                  id="email"
                  required
                />
              </div>
              <div class="components-input-senha">
                <input
                  type="input"
                  class="form__senha"
                  placeholder=""
                  name="senha"
                  id="senha"
                  required
                />
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}

export default PaginaLogin;
