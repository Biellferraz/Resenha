import React from "react";
import { Helmet } from 'react-helmet';
import favicon from "../html-css-template/img/resenha-icon.ico";
import logo from "../html-css-template/img/logo-resenha2.svg";
import logoQuadra from "../html-css-template/img/logo-quadra.svg";
import TituloFormulario from "../components/titulo-form/TituloFormulario";
import BotaoFormulario from "../components/botao-form/BotaoFormulario";
import { Link } from "react-router-dom";
import { useHistory } from "react-router";
import { useState } from "react";
import api from "../api";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

function PaginaLogin() {

  const MySwal = withReactContent(Swal);
  const history = useHistory();

  const [emailDigitado, setEmailDigitado] = useState("");
  const [senhaDigitada, setSenhaDigitada] = useState("");

  function Entrar(e) {
    e.preventDefault();

    api.post("/locatarios/login", {
      email: emailDigitado,
      senha: senhaDigitada,
    }).then((resposta) => {
      sessionStorage.locatario = JSON.stringify(resposta.data);
      history.push("/inicio");
    }).catch((erro) => {
      MySwal.fire({
        title: 'Erro ao se conectar!',
        text: 'E-mail e/ou senha inválido(s)',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
      console.log(erro);
    })
  }

  return (
    <>
      <Helmet>
        <title>Login</title>
        <link rel="icon" type="image/png" href={favicon} sizes="16x16" />
      </Helmet>

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
            <Link to={"/"}>
              <img id="logoResenhaLogin" src={logo} alt="" />
            </Link>
          </div>

          <div class="container-login">
            <div class="corpo-login">
              <div class="corpo-login-container">
                <TituloFormulario img={logoQuadra} titulo="Resenha" subtitulo="Acesse já nossa aplicação" />
                <form class="campo-form-login-container" onSubmit={Entrar}>
                  <div class="campo-email-login">
                    <div class="campo-form-extended">
                      <label>E-mail</label>
                      <input type="email" id="email" name="email" onChange={e => setEmailDigitado(e.target.value)} required />
                    </div>
                  </div>
                  <div class="campo-senha-login">
                    <div class="campo-form-extended">
                      <label>Senha</label>
                      <input type="password" id="password" name="password" onChange={e => setSenhaDigitada(e.target.value)} required />
                    </div>
                  </div>
                  <BotaoFormulario textoBotao="Entrar" textoFooter="Não possui conta ainda?" redirectFooter="CADASTRE-SE AGORA" destino="/cadastrar" />
                </form>
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}

export default PaginaLogin;
