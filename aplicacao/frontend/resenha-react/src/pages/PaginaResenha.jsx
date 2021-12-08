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


function PaginaResenha() {
  let fkLocatario;
  let fkCentroEsportivo;
  const history = useHistory();
  const MySwal = withReactContent(Swal);
  const [centros, setCentros] = useState([]);
  const [selectCentroValue, setSelectCentroValue] = useState(1);
  const [agendamentosPassados, setAgendamentosPassados] = useState([]);

  const [agendamentos, setAgendamentos] = useState([]);

  useEffect(() => {
    validarAutenticacao();
  });

  function testeDownload() {
    window.location.href = `http://localhost:8080/agendamentos/exportar/${fkCentroEsportivo}`;
  }

  useEffect(() => {
    async function recuperarAgendamentos() {
      const respostaAgendamentosMarcados = await api.get(
        `/agendamentos/marcados/${fkCentroEsportivo}`
      );
      if (respostaAgendamentosMarcados.status === 204) {
        MySwal.fire({
          title: "Agendamentos não encontrados",
          text: "Esse centro esportivo não possui agendamentos",
          icon: "error",
          confirmButtonText: "Ok",
        });
        setAgendamentos([]);
      } else if (respostaAgendamentosMarcados.data.length === 0) {
        MySwal.fire({
          title: "Sem agendamentos marcados",
          text: "Esse centro esportivo não possui agendamentos marcados para o futuro",
          icon: "error",
          confirmButtonText: "Ok",
        });
        setAgendamentos([]);
      } else {
        setAgendamentos(respostaAgendamentosMarcados.data);
      }
    }
    recuperarAgendamentos();
  }, [fkCentroEsportivo, selectCentroValue]);

  useEffect(() => {
    async function recuperarAgendamentosAnteriores() {
      const respostaAgendamentosOcorridos = await api.get(
        `/agendamentos/ocorridos/${fkCentroEsportivo}`
      );
      if (respostaAgendamentosOcorridos.status === 204) {
        MySwal.fire({
          title: "Agendamentos não encontrados",
          text: "Esse centro esportivo não possui agendamentos",
          icon: "error",
          confirmButtonText: "Ok",
        });
        setAgendamentosPassados([]);
      } else if (respostaAgendamentosOcorridos.data.length === 0) {
        MySwal.fire({
          title: "Sem agendamentos ocorridos",
          text: "Esse centro esportivo não possui um historico de agendamentos",
          icon: "error",
          confirmButtonText: "Ok",
        });
        setAgendamentosPassados([]);
      } else {
        setAgendamentosPassados(respostaAgendamentosOcorridos.data);
      }
    }
    recuperarAgendamentosAnteriores();
  }, [fkCentroEsportivo, selectCentroValue]);

  useEffect(() => {
    async function recuperarCentros() {
      const resposta = await api.get(
        `/centros/recuperar-centros/${fkLocatario}`
      );
      setCentros(resposta.data);
    }
    recuperarCentros();
  }, []);

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
      sessionStorage.fkCentroEsportivo = selectCentroValue;
      fkCentroEsportivo = sessionStorage.fkCentroEsportivo;
      nome.innerHTML = `${nomeLocatario}`;
      sobrenome.innerHTML = `${sobrenomeLocatario}`;
    }
  }

  function logoff() {
    sessionStorage.clear();
    history.push("/login");
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
          <div className="container-inicio">
            {/* sidebar começo */}
            <div className="sidebar">
              <center>
                <img src={logoResenha} className="image" alt="Logo Resenha" />
              </center>

              <div className="container-menu">
                <div className="menu-content">
                  <div className="inicio-menu">
                    <Link to={"/inicio"} style={{ textDecoration: "none" }}>
                      <div className="menu-img">
                        <img
                          src={imgMenuInicioSelecionado}
                          alt="Imagem Menu Início"
                        />
                      </div>
                      <div className="menu-text">
                        <label style={{ color: "#8FD5FE" }}>INICIO</label>
                      </div>
                    </Link>
                  </div>
                  <div className="centro-menu">
                    <Link
                      to={"/cadastrar-centros"}
                      style={{ textDecoration: "none" }}
                    >
                      <div className="menu-img">
                        <img
                          src={imgMenuCentros}
                          alt="Imagem Menu Cadastrar Centros"
                        />
                      </div>
                      <div className="menu-text">
                        <label>CADASTRAR CENTROS</label>
                      </div>
                    </Link>
                  </div>
                  <div className="quadras-menu">
                    <Link
                      to={"/cadastrar-quadras"}
                      style={{ textDecoration: "none" }}
                    >
                      <div className="menu-img">
                        <img
                          src={imgMenuQuadras}
                          alt="Imagem Menu Cadastrar Quadras"
                        />
                      </div>
                      <div className="menu-text">
                        <label>CADASTRAR QUADRAS</label>
                      </div>
                    </Link>
                  </div>
                  <div className="agenda-menu">
                    <Link to={"/agendar"} style={{ textDecoration: "none" }}>
                      <div className="menu-img">
                        <img src={imgMenuAgendar} alt="Imagem Menu Agendar" />
                      </div>
                      <div className="menu-text">
                        <label>AGENDAR HORARIO</label>
                      </div>
                    </Link>
                  </div>
                </div>
                <div className="menu-footer">
                  <div className="sair-menu" onClick={logoff}>
                    <div className="menu-img">
                      <img src={imgMenuSair} alt="Imagem Menu Sair" />
                    </div>
                    <div className="menu-text">
                      <label>SAIR</label>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            {/* sidebar final */}

            <div className="content">
              <div className="content-header">
                <div className="header-info">
                  <div className="header-info-username">
                    <img src={bolaResenha} alt="Icone Resenha"></img>
                    <label>
                      Bem-Vindo <span id="nome"></span>{" "}
                      <span id="sobrenome"></span>
                    </label>
                  </div>
                  <div className="header-info-date">
                    <label>08 de Dezembro de 2021</label>
                    <img src={calendario} alt="Calendário Resenha"></img>
                  </div>
                </div>
                <div className="header-line">
                  <div className="line"></div>
                  <div className="line-img">
                    <img src={logoQuadra} alt="Quadra Logo Resenha"></img>
                  </div>
                  <div className="line"></div>
                </div>
              </div>
              <div className="content-body">
                <div className="content-body-header">
                  <div className="campo-quadra-centro">
                    <label>SELECIONE UM CENTRO ESPORTIVO</label>
                    <select
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
                    </select>
                  </div>
                  {/* <div > */}
                  <div className='btn-group'>
                    <button className="baixar-agendamentos" onClick={testeDownload}>
                      Exportar Agendamentos
                    </button>
                  </div>
                </div>
                <div className="content-body-quadras">
                  <div className="quadras-header">
                    <div className="quadras-header-title">
                      <div className="quadras-header-img">
                        <img src={imgTaticas} alt="Táticas"></img>
                      </div>
                      <div className="quadras-header-texto">
                        <label>
                          <span style={{ color: "#029EFB" }}>Agendamentos</span>
                          <br />
                          <span style={{ color: "black" }}>Antigos</span>
                        </label>
                      </div>
                    </div>
                  </div>
                  <div className="agendamentos-contents">
                    {agendamentosPassados.map((agendamento) => (
                      <CardFutebol
                        preco={agendamento.preco}
                        horaMarcada={agendamento.hora_Marcada}
                        id={agendamento.id}
                      />
                    ))}
                  </div>
                </div>
                <div className="content-body-agendamentos">
                  <div className="agendamentos-header">
                    <div className="agendamentos-header-title">
                      <div className="agendamentos-header-img">
                        <img src={imgAgendamento} alt="Táticas"></img>
                      </div>
                      <div className="agendamentos-header-texto">
                        <label>
                          <span style={{ color: "#029EFB" }}>Agendamentos</span>
                          <br />
                          Marcados
                        </label>
                      </div>
                    </div>
                  </div>
                  <div className="agendamentos-content">
                    {agendamentos.map((agendamento) => (
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
