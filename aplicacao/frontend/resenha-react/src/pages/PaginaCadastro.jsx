import React from "react";
import { Helmet } from 'react-helmet';
import favicon from "../html-css-template/img/resenha-icon.ico";
import logo from "../html-css-template/img/logo-quadra.svg";
import logoResenha from "../html-css-template/img/logo-resenha2.svg";
import TituloFormulario from "../components/titulo-form/TituloFormulario";
import BotaoFormulario from "../components/botao-form/BotaoFormulario";
import { Link } from "react-router-dom";
import { useState } from "react";
import { useHistory } from "react-router";
import api from "../api";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

function PaginaCadastro() {

  const MySwal = withReactContent(Swal);
  const history = useHistory();

  const [nomeDigitado, setNomeDigitado] = useState("");
  const [sobrenomeDigitado, setSobrenomeDigitado] = useState("");
  const [emailDigitado, setEmailDigitado] = useState("");
  const [senhaDigitada, setSenhaDigitada] = useState("");
  const [confirmarSenhaDigitada, setConfirmarSenhaDigitada] = useState("");
  const [cpfDigitado, setCpfDigitado] = useState("");
  const [dataNascimentoDigitado, setDataNascimentoDigitado] = useState("");
  const [telefoneDigitado, setTelefoneDigitado] = useState("");

  // Variável para verificação da valição dos campos
  const senha = senhaDigitada;
  const confirmarSenha = confirmarSenhaDigitada;
  const nome = nomeDigitado;
  const sobrenome = sobrenomeDigitado;

  // Variáveis booleanos para controle de validação dos campos
  let senhaValidada = false;
  let tamanhoSenhaValidado = false;
  let nomeValidado = false;
  let sobrenomeValidado = false;
  let dataNascimentoValidada = false;

  function validarConfirmarSenha() {
    if (senha === confirmarSenha) {
      senhaValidada = true;
    }
  }

  function validarTamanhoSenha() {
    if (senha.length >= 6) {
      tamanhoSenhaValidado = true;
    }
  }

  function validarNome() {
    if (nome.length >= 3) {
      nomeValidado = true;
    }
  }

  function validarSobrenome() {
    if (sobrenome.length >= 3) {
      sobrenomeValidado = true;
    }
  }

  function mascaraCPF(i) {
    let v = i.value;

    if (isNaN(v[v.length - 1])) {
      i.value = v.substring(0, v.length - 1);
      return;
    }

    i.setAttribute("maxlength", "14");
    if (v.length === 3 || v.length === 7) i.value += ".";
    if (v.length === 11) i.value += "-";
  }

  function mascaraTelefone(tel) {
    let valor = tel.value;
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
    valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
    tel.value = valor;
    return;
  }

  function validarData(data) {
    console.log(data);
    var data_array = data.split("-");
    var dia = data_array[2];
    var mes = data_array[1];
    var ano = data_array[0];

    if (data_array[0].length !== 4) {
      dia = data_array[0];
      mes = data_array[1];
      ano = data_array[2];
    }

    var hoje = new Date();
    var d1 = hoje.getDate();
    var m1 = hoje.getMonth() + 1;
    var a1 = hoje.getFullYear();

    d1 = new Date(a1, m1, d1);
    var d2 = new Date(ano, mes, dia);

    var diff = d2.getTime() - d1.getTime();
    diff = diff / (1000 * 60 * 60 * 24);

    if (diff <= 0) {
      dataNascimentoValidada = true;
    }
  }

  function Cadastrar(e) {
    e.preventDefault();

    validarNome();
    validarSobrenome();
    validarTamanhoSenha();
    validarConfirmarSenha();
    validarData(dataNascimentoDigitado);

    if (nomeValidado === false) {
      MySwal.fire({
        title: 'Usuário não cadastrado!',
        text: 'Nome deve possuir no mínimo 3 caracteres',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
    } else if (sobrenomeValidado === false) {
      MySwal.fire({
        title: 'Usuário não cadastrado!',
        text: 'Sobrenome deve possuir no mínimo 3 caracteres',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
    } else if (tamanhoSenhaValidado === false) {
      MySwal.fire({
        title: 'Usuário não cadastrado!',
        text: 'Senha deve possuir no mínimo 6 caracteres',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
    } else if (senhaValidada === false) {
      MySwal.fire({
        title: 'Usuário não cadastrado!',
        text: 'As senhas inseridas nao conferem',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
    } else if (dataNascimentoValidada === false) {
      MySwal.fire({
        title: 'Usuário não cadastrado!',
        text: 'Data deve ser anterior ao dia de hoje',
        icon: 'error',
        confirmButtonText: 'Ok',
      })
    } else {
      api.post("/locatarios", {
        nome: nomeDigitado,
        sobrenome: sobrenomeDigitado,
        email: emailDigitado,
        senha: senhaDigitada,
        cpf: cpfDigitado,
        data_nasc: dataNascimentoDigitado,
        telefone: telefoneDigitado,
      }).then((resposta) => {
        MySwal.fire({
          title: 'Usuário cadastro com sucesso!',
          text: 'Agora você pode conectar em nossa aplicação',
          icon: 'success',
          confirmButtonText: 'Ok',
        }).then((result) => {
          if (result.isConfirmed) {
            history.push("/login");
          }
        })
        console.log(resposta)
      }).catch((erro) => {
        MySwal.fire({
          title: 'Usuário não cadastrado!',
          text: 'Erro ao cadastrar no banco de dados',
          icon: 'error',
          confirmButtonText: 'Ok',
        })
        console.log(erro);
      })
    }
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
                        <input type="text" id="nome" name="nome" onChange={e => setNomeDigitado(e.target.value)} required />
                      </div>
                      <div class="campo-form">
                        <label>Sobrenome</label>
                        <input type="text" id="sobrenome" name="sobrenome" onChange={e => setSobrenomeDigitado(e.target.value)} required />
                      </div>
                    </div>
                    <div class="campo-email">
                      <div class="campo-form-extended">
                        <label>E-mail</label>
                        <input type="email" id="email" name="email" onChange={e => setEmailDigitado(e.target.value)} required />
                      </div>
                    </div>
                    <div class="campo-senha">
                      <div class="campo-form">
                        <label>Senha</label>
                        <input type="password" id="password" name="password" onChange={e => setSenhaDigitada(e.target.value)} required />
                      </div>
                      <div class="campo-form">
                        <label>Confirmar Senha</label>
                        <input type="password" id="new_password" name="new_password" onChange={e => setConfirmarSenhaDigitada(e.target.value)} required />
                      </div>
                    </div>
                    <div class="campo-cpf-idade">
                      <div class="campo-form">
                        <label>CPF</label>
                        <input type="cpf" id="cpf" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" maxLength="14" onInput={e => mascaraCPF(e.target)} onChange={e => setCpfDigitado(e.target.value)} required />
                      </div>
                      <div class="campo-form">
                        <label>Data de Nascimento</label>
                        <input type="date" id="nascimento" name="nascimento" onChange={e => setDataNascimentoDigitado(e.target.value)} required />
                      </div>
                    </div>
                    <div class="campo-telefone">
                      <div class="campo-form">
                        <label>Telefone</label>
                        <input type="text" id="telefone" name="telefone" onInput={e => mascaraTelefone(e.target)} maxLength="15" pattern="\(\d{2}\)\s*\d{5}-\d{4}" onChange={e => setTelefoneDigitado(e.target.value)} required />
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
