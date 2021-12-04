import React, { useEffect, useState } from "react";
import { Helmet } from "react-helmet";
import { Link } from "react-router-dom";
import { useHistory } from "react-router";
import favicon from "../html-css-template/img/resenha-icon.ico";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import imgMenuInicioSelecionado from "../html-css-template/img/inicio-menu-azul.svg";
import imgMenuAgendar from "../html-css-template/img/agenda-menu-lateral.svg";
import imgMenuCentros from "../html-css-template/img/cadastrar-centro-menu-lateral.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral.svg";
import imgMenuSair from "../html-css-template/img/botao-sair-menu-lateal.svg";
import bolaResenha from "../html-css-template/img/ball.svg";
import calendario from "../html-css-template/img/calendar.svg";
import logoQuadra from "../html-css-template/img/resenha-quadra-inicio.svg";
import imgTaticas from "../html-css-template/img/tatico.svg";
import imgAgendamento from "../html-css-template/img/agendamento-inicio.svg";
import CardFutebol from "../components/CardFutebol";
import api from "../api";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import CardQuadra from "../components/CardQuadra";
import { apiUrl } from "../api"

function PaginaResenha() {
  let fkLocatario;
  const [download, setDownload] = useState("");
  const urlToDownload = api.get("<localhost:80800>/agendamentos/exportar-txt</localhost:80800>")
  const [count, setCount] = useState(0);
  const history = useHistory();
  const MySwal = withReactContent(Swal);
  const [centros, setCentros] = useState([]);
  const [selectCentroValue, setSelectCentroValue] = useState(1);
  const [quadras, setQuadras] = useState([]);
  const [agendamentoPassado, setAgendamentosAnteriores] = useState([]);
  let proximoAgendamento

  let [agendamento, setAgendamento] = useState([]);

  useEffect(() => {
    validarAutenticacao();
  });
  useEffect(() => {
    async function recuperarAgendamentos() {
      const resposta = await api.get(`/agendamentos/`);
      setAgendamento(resposta.data);
    }
    recuperarAgendamentos();
  }, []);
  useEffect(() => {
    async function recuperarAgendamentosAnteriores() {
      const resposta = await api.get(`/agendamentos/ocorridos/`);
      setAgendamentosAnteriores(resposta.data);
    }
    recuperarAgendamentosAnteriores();
  }, []);
  useEffect(() => {
    async function recuperarCentros() {
      const resposta = await api.get(
        `/centros/recuperar-centros/${fkLocatario}`
      );
      setCentros(resposta.data);
    }
    recuperarCentros();
  }, []);
  function agendamentosAnteriores() {
    proximoAgendamento.style = 'display:block';

  }

  function baixarAgendamentos(e) {
    e.preventDefault();

    api
      .get("/agendamentos/relatorios", {})
      .then(() => {
        MySwal.fire({
          title: "Download realizado com sucesso!",
          text: "Agora você pode visualizar o download",
          icon: "success",
          confirmButtonText: "Ok",
        });
      })
      .catch((erro) => {
        MySwal.fire({
          title: "Não foi possível fazer o download",
          text: "Erro ao fazer download do arquivo",
          icon: "error",
          confirmButtonText: "Ok",
        });
        console.log(erro);
      });
  }
  function validarAutenticacao() {
    let login_locatario = sessionStorage.locatario;
    if (login_locatario === undefined) {
      logoff();
    } else {
      let locatario = JSON.parse(login_locatario);
      let nomeLocatario = locatario.nome;
      let sobrenomeLocatario = locatario.sobrenome;
      let nome = document.getElementById("nome");
      let sobrenome = document.getElementById("sobrenome");
      fkLocatario = locatario.id;
      nome.innerHTML = `${nomeLocatario}`;
      sobrenome.innerHTML = `${sobrenomeLocatario}`;
    }
  }

  function logoff() {
    sessionStorage.clear();
    history.push("/login");
  }

  function disponivel() {
    if ((quadras.disponivel = 1)) {
      return "Disponivel";
    } else {
      return "Ocupada";
    }
  }

  return (
    <>
      <Helmet>
        <title>Início</title>
        <link rel="icon" type="image/png" href={favicon} sizes="16x16" />
      </Helmet>

      <html lang="pt">
        <head>
          <meta charset="UTF-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0"
          />
          <title>Resenha</title>
          <link rel="stylesheet" href="../css/menu-lateral.css" />
          <link
            rel="shortcut icon"
            href="../img/resenha-favicon.icon"
            type="image/x-icon"
          />
        </head>

        <body>
          <div class="container-inicio">
            {/* sidebar começo */}
            <div class="sidebar">
              <center>
                <img src={logoResenha} class="image" alt="Logo Resenha" />
              </center>

              <div class="container-menu">
                <div class="menu-content">
                  <div class="inicio-menu">
                    <Link to={"/inicio"} style={{ textDecoration: "none" }}>
                      <div class="menu-img">
                        <img
                          src={imgMenuInicioSelecionado}
                          alt="Imagem Menu Início"
                        />
                      </div>
                      <div class="menu-text">
                        <label style={{ color: "#8FD5FE" }}>INICIO</label>
                      </div>
                    </Link>
                  </div>
                  <div class="centro-menu">
                    <Link
                      to={"/cadastrar-centros"}
                      style={{ textDecoration: "none" }}
                    >
                      <div class="menu-img">
                        <img
                          src={imgMenuCentros}
                          alt="Imagem Menu Cadastrar Centros"
                        />
                      </div>
                      <div class="menu-text">
                        <label>CADASTRAR CENTROS</label>
                      </div>
                    </Link>
                  </div>
                  <div class="quadras-menu">
                    <Link
                      to={"/cadastrar-quadras"}
                      style={{ textDecoration: "none" }}
                    >
                      <div class="menu-img">
                        <img
                          src={imgMenuQuadras}
                          alt="Imagem Menu Cadastrar Quadras"
                        />
                      </div>
                      <div class="menu-text">
                        <label>CADASTRAR QUADRAS</label>
                      </div>
                    </Link>
                  </div>
                  <div class="agenda-menu">
                    <Link to={"/agendar"} style={{ textDecoration: "none" }}>
                      <div class="menu-img">
                        <img src={imgMenuAgendar} alt="Imagem Menu Agendar" />
                      </div>
                      <div class="menu-text">
                        <label>AGENDAR HORARIO</label>
                      </div>
                    </Link>
                  </div>
                </div>
                <div class="menu-footer">
                  <div class="sair-menu" onClick={logoff}>
                    <div class="menu-img">
                      <img src={imgMenuSair} alt="Imagem Menu Sair" />
                    </div>
                    <div class="menu-text">
                      <label>SAIR</label>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            {/* sidebar final */}

            <div class="content">
              <div class="content-header">
                <div class="header-info">
                  <div class="header-info-username">
                    <img src={bolaResenha} alt="Icone Resenha"></img>
                    <label>
                      Bem-Vindo <span id="nome"></span>{" "}
                      <span id="sobrenome"></span>
                    </label>
                  </div>
                  <div class="header-info-date">
                    <label>01 de Dezembro de 2021</label>
                    <img src={calendario} alt="Calendário Resenha"></img>
                  </div>
                </div>
                <div class="header-line">
                  <div class="line"></div>
                  <div class="line-img">
                    <img src={logoQuadra} alt="Quadra Logo Resenha"></img>
                  </div>
                  <div class="line"></div>
                </div>
              </div>
              <div class="content-body">
                <div class="content-body-quadras">
                  <div class="quadras-header">
                    <div class="quadras-header-title">
                      <div class="quadras-header-img">
                        <img src={imgTaticas} alt="Táticas"></img>
                      </div>
                      <div class="quadras-header-texto">
                        <label>
                          <span style={{ color: "#029EFB" }}>Agendamentos</span>
                          <br />
                          <span style={{ color: "black" }} >Antigos  </span>
                        </label>
                        {/* <select
                          value={selectCentroValue}
                          name="centros"
                          id="centros"
                          onChange={(e) => setSelectCentroValue(e.target.value)}
                        >
                          <option value="Selecione">Selecione</option>
                          {centros.map((centro) => (
                            <option value={centro.id} id="centro_selecionado">
                              {centro.nome}
                            </option>
                          ))}
                        </select> */}
                      </div>
                    </div>
                  </div>
                  <div class="agendamentos-contents">
                    {agendamentoPassado.map((agendamento) => (
                      <CardFutebol
                        preco={agendamento.preco}
                        horaMarcada={agendamento.hora_Marcada}
                        id={agendamento.id}
                      />
                    ))}
                  </div>
                </div>
                <div class="content-body-agendamentos">
                  <div class="agendamentos-header">
                    <div class="agendamentos-header-title">
                      <div class="agendamentos-header-img">
                        <img src={imgAgendamento} alt="Táticas"></img>
                      </div>
                      <div class="agendamentos-header-texto">
                        <label>
                          <span style={{ color: "#029EFB" }}>Agendamentos</span>
                          <br />
                          Marcado
                        </label>
                      </div>
                      <div class="baixar-agendamentos">
                        <p>
                          <button
                            onClick={() => {
                              setDownload(urlToDownload);
                              setCount((old) => old + 1);
                            }}
                          >
                            Download
                          </button>
                        </p>
                        <p>{download}</p>
                        {download && (
                          <iframe
                            src={download + "?c=" + count}
                            style={{ display: "none" }}
                          ></iframe>
                        )}
                        <br />
                        <p>{download}</p>
                        {download && <iframe src={download}></iframe>}
                      </div>
                    </div>
                  </div>
                  <div class="agendamentos-content">
                    {agendamento.map((agendamento) => (
                      <CardFutebol
                        preco={agendamento.preco}
                        horaMarcada={agendamento.hora_Marcada}
                        id={agendamento.id}
                      />
                    ))}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </body>
      </html>
    </>
  );
}

export default PaginaResenha;
