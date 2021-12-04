import React, { useEffect, useState } from "react";
import { Helmet } from 'react-helmet';
import { Link } from "react-router-dom";
import { useHistory } from "react-router";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import api from "../api";
import favicon from "../html-css-template/img/resenha-icon.ico";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import imgMenuInicio from "../html-css-template/img/inicio-menu.svg";
import imgMenuAgendarSelecionado from "../html-css-template/img/agenda-menu-lateral-azul.svg";
import imgMenuCentros from "../html-css-template/img/cadastrar-centro-menu-lateral.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral.svg";
import imgMenuSair from "../html-css-template/img/botao-sair-menu-lateal.svg";
import bolaResenha from "../html-css-template/img/ball.svg";
import calendario from "../html-css-template/img/calendar.svg";
import logoQuadra from "../html-css-template/img/resenha-quadra-inicio.svg";
import quadraAgendamento from "../html-css-template/img/quadra-agendamento.svg";
import quadraVolei from "../html-css-template/img/quadra-volei.svg";
import horario from "../html-css-template/img/clock.svg";
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";
import cadernoAgendamento from "../html-css-template/img/caderno-agendamento.svg";
import moeda from "../html-css-template/img/coin.svg";

function PaginaAgendamento() {
    const MySwal = withReactContent(Swal);
    const history = useHistory();

    const [centros, setCentros] = useState([]);
    const [quadras, setQuadras] = useState([]);
    const [quadra, setQuadra] = useState([]);

    const [selectCentroValue, setSelectCentroValue] = useState(1);
    const [selectQuadraValue, setSelectQuadraValue] = useState(1);

    const [horaDataDigitada, setHoraDataDigitada] = useState("");
    const [precoDigitado, setPrecoDigitado] = useState("");

    let fkLocatario;
    let fkCentroEsportivo;

    useEffect(() => {
        validarAutenticacao();
    });

    useEffect(() => {
        async function recuperarUmaQuadra() {
            const resposta = await api.get(`/quadras/${selectQuadraValue}`);
            setQuadra(resposta.data);
            sessionStorage.quadra = JSON.stringify(resposta.data);
        }
        recuperarUmaQuadra();
    }, [selectQuadraValue]);

    useEffect(() => {
        async function recuperarCentros() {
            const resposta = await api.get(`/centros/recuperar-centros/${fkLocatario}`);
            setCentros(resposta.data);
        }
        recuperarCentros();
    }, [fkLocatario]);

    useEffect(() => {
        async function recuperarQuadras() {
            const resposta = await api.get(`/quadras/recuperar-quadras/${fkCentroEsportivo}`);
            setQuadras(resposta.data)
        }
        recuperarQuadras();
    }, [fkCentroEsportivo, selectCentroValue]);

    function validarAutenticacao() {
        let login_locatario = sessionStorage.locatario;
        if (login_locatario === undefined) {
            logoff();
        } else {
            let locatario = JSON.parse(login_locatario);

            let nomeLocatario = locatario.nome;
            let sobrenomeLocatario = locatario.sobrenome;

            fkLocatario = locatario.id;
            sessionStorage.fkCentroEsportivo = selectCentroValue;
            fkCentroEsportivo = sessionStorage.fkCentroEsportivo;

            let nome = document.getElementById("nome");
            let sobrenome = document.getElementById("sobrenome");

            nome.innerHTML = `${nomeLocatario}`;
            sobrenome.innerHTML = `${sobrenomeLocatario}`;
        }
    }


    function Agendar(e) {
        e.preventDefault();

        api.post("/agendamentos", {
            hora_Marcada: horaDataDigitada,
            preco: precoDigitado,
            fkQuadra: quadra.id,
            fk_Jogador: 103
        }).then(() => {
            MySwal.fire({
                title: 'Agendado com sucesso!',
                text: 'Agora você pode visualizar seus agendamentos',
                icon: 'success',
                confirmButtonText: 'Ok',
            })
        }).catch((erro) => {
            MySwal.fire({
                title: 'Agendamento não realizado!',
                text: 'Erro ao agendar no banco de dados',
                icon: 'error',
                confirmButtonText: 'Ok',
            })
            console.log(erro);
        })
    }

    function logoff() {
        sessionStorage.clear();
        history.push("/login");
    }

    return (
        <>
            <Helmet>
                <title>Agendar Horário</title>
                <link rel="icon" type="image/png" href={favicon} sizes="16x16" />
            </Helmet>

            <html lang="pt">

                <head>
                    <meta charset="UTF-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Resenha</title>
                    <link rel="stylesheet" href="../css/menu-lateral.css" />
                    <link rel="shortcut icon" href="../img/resenha-favicon.icon" type="image/x-icon" />
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
                                        <Link to={"/inicio"} style={{ textDecoration: 'none' }}>
                                            <div class="menu-img">
                                                <img src={imgMenuInicio} alt="Imagem Menu Início" />
                                            </div>
                                            <div class="menu-text">
                                                <label>INICIO</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div class="centro-menu">
                                        <Link to={"/cadastrar-centros"} style={{ textDecoration: 'none' }}>
                                            <div class="menu-img">
                                                <img src={imgMenuCentros} alt="Imagem Menu Cadastrar Centros" />
                                            </div>
                                            <div class="menu-text">
                                                <label>CADASTRAR CENTROS</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div class="quadras-menu">
                                        <Link to={"/cadastrar-quadras"} style={{ textDecoration: 'none' }}>
                                            <div class="menu-img">
                                                <img src={imgMenuQuadras} alt="Imagem Menu Cadastrar Quadras" />
                                            </div>
                                            <div class="menu-text">
                                                <label>CADASTRAR QUADRAS</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div class="agenda-menu">
                                        <Link to={"/agendar"} style={{ textDecoration: 'none' }}>
                                            <div class="menu-img">
                                                <img src={imgMenuAgendarSelecionado} alt="Imagem Menu Agendar" />
                                            </div>
                                            <div class="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>AGENDAR HORARIO</label>
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
                                        <label>Bem-Vindo <span id="nome"></span> <span id="sobrenome"></span></label>
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
                            <div class="content-body-agendamento">
                                <div class="agendamento-header">
                                    <div class="agendamento-select-centro">
                                        <div class="select-centro-title">
                                            <div class="select-img">
                                                <img src={centroEsportivo} alt="Centro Esportivo"></img>
                                            </div>
                                            <div class="select-label">
                                                <label>Selecione um centro esportivo</label>
                                            </div>
                                        </div>
                                        <div class="select-centro-info">
                                            <select value={selectCentroValue} name="centros" id="centros" onChange={e => setSelectCentroValue(e.target.value)}>
                                                <option value="Selecione">Selecione</option>
                                                {
                                                    centros.map((centro) => (
                                                        <option value={centro.id} id="centro_selecionado">{centro.nome}</option>
                                                    ))
                                                }
                                            </select>
                                        </div>
                                    </div>
                                    <div class="agendamento-select-quadra" id="select_quadra">
                                        <div class="select-quadra-title">
                                            <div class="select-img">
                                                <img src={quadraAgendamento} alt="Quadra"></img>
                                            </div>
                                            <div class="select-label">
                                                <label>Selecione uma Quadra</label>
                                            </div>
                                        </div>
                                        <div class="select-quadra-info">
                                            <select value={selectQuadraValue} name="quadras" id="quadras" onChange={e => setSelectQuadraValue(e.target.value)}>
                                                <option value="Selecione">Selecione</option>
                                                {
                                                    quadras.map((quadra) => (
                                                        <option value={quadra.id} id="arma_selecionado">{quadra.numero_quadra}</option>
                                                    ))
                                                }
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="agendamento-body">
                                    <form class="agendamento-body-container" onSubmit={Agendar}>
                                        {/* <div class="agendamento-body-header">
                                            <div class="agendamento-body-header-img">
                                                <img src={bolaVolei} alt=""></img>
                                            </div>
                                            <div class="agendamento-body-header-title">
                                                <label>Quadra <span id="numero_quadra"></span></label>
                                                <label style={{ "color": "#029EFB" }}><span id="modalidade_quadra"></span></label>
                                            </div>
                                        </div> */}
                                        <div class="agendamento-body-content">
                                            <div class="agendamento-body-quadra-A">
                                                <div class="agendamento-quadra-A-img">
                                                    <img src={quadraVolei} alt=""></img>
                                                </div>
                                                <div class="agendamento-quadra-A-horarios">
                                                    <div class="agendamento-quadra-A-title">
                                                        <img src={horario} alt="Horário"></img>
                                                        <label>Horários da Quadra:</label>
                                                    </div>
                                                    <div class="agendamento-quadra-A-time">
                                                        <div class="agendamento-quadra-horario">
                                                            <label>09:00 - 10:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>10:00 - 11:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>11:00 - 12:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>12:00 - 13:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>13:00 - 14:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>14:00 - 15:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>15:00 - 16:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>16:00 - 17:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>17:00 - 18:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>18:00 - 19:00</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="agendamento-body-quadra-B">
                                                <div class="agendamento-campo-horario">
                                                    <div class="agendamento-campo-horario-header">
                                                        <img src={cadernoAgendamento} alt="Horário Agendamento"></img>
                                                        <label>SELECIONE O DIA</label>
                                                    </div>
                                                    <div class="agendamento-campo-horario-content">
                                                        <input type="datetime" name="data_agendamento" id="horario_agendamento" onChange={e => setHoraDataDigitada(e.target.value)} required></input>
                                                    </div>
                                                </div>
                                                <div class="agendamento-campo-horario">
                                                    <div class="agendamento-campo-horario-header">
                                                        <img src={cadernoAgendamento} alt="Horário Agendamento"></img>
                                                        <label>Horário</label>
                                                    </div>
                                                    <div class="agendamento-campo-horario-content">
                                                        <labe></labe>
                                                    </div>
                                                </div>
                                                <div class="agendamento-campo-valor">
                                                    <div class="agendamento-campo-valor-header">
                                                        <img src={moeda} alt="Valor"></img>
                                                        <label>Valor</label>
                                                    </div>
                                                    <div class="agendamento-campo-valor-content">
                                                        <label>R$</label>
                                                        <input type="number" name="valor_agendamento" id="valor_agendamento" onChange={e => setPrecoDigitado(e.target.value)} required></input>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="agendamento-body-footer">
                                            <button type="submit">Agendar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </body>

            </html>
        </>
    );
}

export default PaginaAgendamento;