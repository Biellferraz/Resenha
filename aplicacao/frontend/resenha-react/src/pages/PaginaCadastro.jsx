import React from "react";
import { Helmet } from 'react-helmet';
import favicon from "../html-css-template/img/resenha-icon.ico";
import logo from "../html-css-template/img/logo-quadra.svg";
import logoResenha from "../html-css-template/img/logo-resenha2.svg";
import TituloFormulario from "../components/titulo-form/TituloFormulario";
import BotaoFormulario from "../components/botao-form/BotaoFormulario";
import { Link } from "react-router-dom";
import { useState } from "react";
import api from "../api";

function PaginaCadastro() {

  const [nomeDigitado, setNomeDigitado] = useState("");
  const [sobrenomeDigitado, setSobrenomeDigitado] = useState("");
  const [emailDigitado, setEmailDigitado] = useState("");
  const [senhaDigitada, setSenhaDigitada] = useState("");
  const [cpfDigitado, setCpfDigitado] = useState("");
  const [dataNascimentoDigitado, setDataNascimentoDigitado] = useState("");
  const [telefoneDigitado, setTelefoneDigitado] = useState("");

  function Cadastrar(e) {
    e.preventDefault();

    console.log(nomeDigitado)
    console.log(sobrenomeDigitado)
    console.log(emailDigitado)
    console.log(senhaDigitada)
    console.log(cpfDigitado)
    console.log(dataNascimentoDigitado)
    console.log(telefoneDigitado)

    api.post("/locatarios", {
      nome: nomeDigitado,
      sobrenome: sobrenomeDigitado,
      email: emailDigitado,
      senha: senhaDigitada,
      cpf: cpfDigitado,
      data_nasc: dataNascimentoDigitado,
      telefone: telefoneDigitado,
    }).then((resposta) => {
      alert("Sucesso!");
      console.log(resposta)
    }).catch((erro) => {
      alert("Erro ao Cadastrar!");
      console.log(erro);
    })
  }

  return (
    <>
      <Helmet>
        <title>Cadastro</title>
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
                <form class="campo-formulario-container" onSubmit={Cadastrar}>
                  <div class="inputs-form-container">
                    <div class="campo-nome">
                      <div class="campo-form">
                        <label>Nome</label>
                        <input type="text" id="nome" name="nome" onChange={e => setNomeDigitado(e.target.value)} />
                      </div>
                      <div class="campo-form">
                        <label>Sobrenome</label>
                        <input type="text" id="sobrenome" name="sobrenome" onChange={e => setSobrenomeDigitado(e.target.value)} />
                      </div>
                    </div>
                    <div class="campo-email">
                      <div class="campo-form-extended">
                        <label>E-mail</label>
                        <input type="email" id="email" name="email" onChange={e => setEmailDigitado(e.target.value)} />
                      </div>
                    </div>
                    <div class="campo-senha">
                      <div class="campo-form">
                        <label>Senha</label>
                        <input type="password" id="password" name="password" onChange={e => setSenhaDigitada(e.target.value)} />
                      </div>
                      <div class="campo-form">
                        <label>Confirmar Senha</label>
                        <input type="password" id="new_password" name="new_password" />
                      </div>
                    </div>
                    <div class="campo-cpf-idade">
                      <div class="campo-form">
                        <label>CPF</label>
                        <input type="number" id="cpf" name="cpf" onChange={e => setCpfDigitado(e.target.value)} />
                      </div>
                      <div class="campo-form">
                        <label>Data de Nascimento</label>
                        <input type="text" id="nascimento" name="nascimento" onChange={e => setDataNascimentoDigitado(e.target.value)} />
                      </div>
                    </div>
                    <div class="campo-telefone">
                      <div class="campo-form">
                        <label>Telefone</label>
                        <input type="number" id="telefone" name="telefone" onChange={e => setTelefoneDigitado(e.target.value)} />
                      </div>
                    </div>
                  </div>
                  <BotaoFormulario textoBotao="Criar Conta" textoFooter="Já possui login?" redirectFooter="ACESSE AGORA" destino="/login" />
                </form>
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}
export default PaginaCadastro;
