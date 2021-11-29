import React, { useEffect } from "react";
import { Helmet } from 'react-helmet';
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
import bolaFutebol from "../html-css-template/img/futball-ball.svg";
import quadraFutebol from "../html-css-template/img/quadra-futebol.svg";
import playerResenha from "../html-css-template/img/card-player.svg";
import bolaTenis from "../html-css-template/img/tenis-ball.svg";
import quadraTenis from "../html-css-template/img/quadra-tenis.svg";
import bolaVolei from "../html-css-template/img/volei-ball.svg";
import quadraVolei from "../html-css-template/img/quadra-volei.svg";
import bolaBasquete from "../html-css-template/img/basquete-ball.svg";
import quadraBasquete from "../html-css-template/img/quadra-basquete.svg";

function PaginaResenha() {
    const history = useHistory();

    useEffect(() => {
        validarAutenticacao();
    });

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
                                                <img src={imgMenuInicioSelecionado} alt="Imagem Menu Início" />
                                            </div>
                                            <div class="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>INICIO</label>
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
                            <div class="content-body">
                                <div class="content-body-quadras">
                                    <div class="quadras-header">
                                        <div class="quadras-header-title">
                                            <div class="quadras-header-img">
                                                <img src={imgTaticas} alt="Táticas"></img>
                                            </div>
                                            <div class="quadras-header-texto">
                                                <label>Quadras de</label>
                                                <select name="quadras" id="quadras">
                                                    <option value="arena" selected>Arena Poliesportiva</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="quadras-content">
                                        <div class="card-quadra-futebol">
                                            <div class="card-container">
                                                <div class="card-header">
                                                    <div class="card-header-inicio-title">
                                                        <span>Quadra A1</span>
                                                        <label>Futebol</label>
                                                    </div>
                                                    <div class="card-header-img">
                                                        <img src={bolaFutebol} alt="Bola Futebol"></img>
                                                    </div>
                                                </div>
                                                <div class="card-body">
                                                    <div class="card-body-img">
                                                        <img src={quadraFutebol} alt="Quadra Futebol"></img>
                                                    </div>
                                                    <div class="card-body-content">
                                                        <select name="quadras" id="quadras">
                                                            <option value="arena" selected>09:00</option>
                                                            <option value="arena" selected>10:00</option>
                                                            <option value="arena" selected>11:00</option>
                                                            <option value="arena" selected>12:00</option>
                                                            <option value="arena" selected>13:00</option>
                                                        </select>
                                                        <label>Agendada</label>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <div class="card-footer-img">
                                                        <img src={playerResenha} alt="Resenha"></img>
                                                    </div>
                                                    <div class="card-footer-player">
                                                        <label>Nome do Usuário</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-quadra-tenis">
                                            <div class="card-container">
                                                <div class="card-header">
                                                    <div class="card-header-inicio-title">
                                                        <span>Quadra A2</span>
                                                        <label>Tênis</label>
                                                    </div>
                                                    <div class="card-header-img">
                                                        <img src={bolaTenis} alt="Bola Tênis"></img>
                                                    </div>
                                                </div>
                                                <div class="card-body">
                                                    <div class="card-body-img">
                                                        <img src={quadraTenis} alt="Quadra Tênis"></img>
                                                    </div>
                                                    <div class="card-body-content">
                                                        <select name="quadras" id="quadras">
                                                            <option value="arena" selected>09:00</option>
                                                            <option value="arena" selected>10:00</option>
                                                            <option value="arena" selected>11:00</option>
                                                            <option value="arena" selected>12:00</option>
                                                            <option value="arena" selected>13:00</option>
                                                        </select>
                                                        <label>LIVRE</label>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <div class="card-footer-img">
                                                        <img src={playerResenha} alt="Resenha"></img>
                                                    </div>
                                                    <div class="card-footer-player">
                                                        <label>Nome do Usuário</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-quadra-volei">
                                            <div class="card-container">
                                                <div class="card-header">
                                                    <div class="card-header-inicio-title">
                                                        <span>Quadra A2</span>
                                                        <label>Tênis</label>
                                                    </div>
                                                    <div class="card-header-img">
                                                        <img src={bolaVolei} alt="Bola Vôlei"></img>
                                                    </div>
                                                </div>
                                                <div class="card-body">
                                                    <div class="card-body-img">
                                                        <img src={quadraVolei} alt="Quadra Vôlei"></img>
                                                    </div>
                                                    <div class="card-body-content">
                                                        <select name="quadras" id="quadras">
                                                            <option value="arena" selected>09:00</option>
                                                            <option value="arena">10:00</option>
                                                            <option value="arena">11:00</option>
                                                            <option value="arena">12:00</option>
                                                            <option value="arena">13:00</option>
                                                        </select>
                                                        <label>LIVRE</label>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <div class="card-footer-img">
                                                        <img src={playerResenha} alt="Resenha"></img>
                                                    </div>
                                                    <div class="card-footer-player">
                                                        <label>Nome do Usuário</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-quadra-basquete">
                                            <div class="card-container">
                                                <div class="card-header">
                                                    <div class="card-header-inicio-title">
                                                        <span>Quadra A4</span>
                                                        <label>Basquete</label>
                                                    </div>
                                                    <div class="card-header-img">
                                                        <img src={bolaBasquete} alt="Bola Basquete"></img>
                                                    </div>
                                                </div>
                                                <div class="card-body">
                                                    <div class="card-body-img">
                                                        <img src={quadraBasquete} alt="Quadra Basquete"></img>
                                                    </div>
                                                    <div class="card-body-content">
                                                        <select name="quadras" id="quadras">
                                                            <option value="arena" selected>09:00</option>
                                                            <option value="arena" selected>10:00</option>
                                                            <option value="arena" selected>11:00</option>
                                                            <option value="arena" selected>12:00</option>
                                                            <option value="arena" selected>13:00</option>
                                                        </select>
                                                        <label>LIVRE</label>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <div class="card-footer-img">
                                                        <img src={playerResenha} alt="Resenha"></img>
                                                    </div>
                                                    <div class="card-footer-player">
                                                        <label>Nome do Usuário</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="content-body-agendamentos">
                                    <div class="agendamentos-header">
                                        <div class="agendamentos-header-title">
                                            <div class="agendamentos-header-img">
                                                <img src={imgAgendamento} alt="Táticas"></img>
                                            </div>
                                            <div class="agendamentos-header-texto">
                                                <label><span style={{ "color": "#029EFB" }}>Agendamentos</span><br />Marcado</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="agendamentos-content">
                                        <div class="card-agendamento-futebol">
                                            <div class="card-agendamento-container">
                                                <div class="card-agendamento-quadra">
                                                    <img src={quadraFutebol} alt="Quadra Futebol"></img>
                                                </div>
                                                <div class="card-agendamento-nome-quadra">
                                                    <label style={{ "color": "#029EFB" }}>Quadra</label>
                                                    <label>Quadra A1</label>
                                                </div>
                                                <div class="card-agendamento-modalidade">
                                                    <div class="card-agendamento-modalidade-text">
                                                        <label style={{ "color": "#029EFB" }}>Modalidade</label>
                                                        <label>Futebol</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-jogador">
                                                    <div class="card-agendamento-jogador-text">
                                                        <label style={{ "color": "#029EFB" }}>Jog.Responsável</label>
                                                        <label>Nome Jogador</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-horario">
                                                    <label>09:00</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-agendamento-basquete">
                                            <div class="card-agendamento-container">
                                                <div class="card-agendamento-quadra">
                                                    <img src={quadraBasquete} alt="Quadra Basquete"></img>
                                                </div>
                                                <div class="card-agendamento-nome-quadra">
                                                    <label style={{ "color": "#029EFB" }}>Quadra</label>
                                                    <label>Quadra A1</label>
                                                </div>
                                                <div class="card-agendamento-modalidade">
                                                    <div class="card-agendamento-modalidade-text">
                                                        <label style={{ "color": "#029EFB" }}>Modalidade</label>
                                                        <label>Basquete</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-jogador">
                                                    <div class="card-agendamento-jogador-text">
                                                        <label style={{ "color": "#029EFB" }}>Jog.Responsável</label>
                                                        <label>Nome Jogador</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-horario">
                                                    <label>10:00</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-agendamento-volei">
                                            <div class="card-agendamento-container">
                                                <div class="card-agendamento-quadra">
                                                    <img src={quadraVolei} id="quadra_volei" alt="Quadra Vôlei"></img>
                                                </div>
                                                <div class="card-agendamento-nome-quadra">
                                                    <label style={{ "color": "#029EFB" }}>Quadra</label>
                                                    <label>Quadra A1</label>
                                                </div>
                                                <div class="card-agendamento-modalidade">
                                                    <div class="card-agendamento-modalidade-text">
                                                        <label style={{ "color": "#029EFB" }}>Modalidade</label>
                                                        <label>Vôlei</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-jogador">
                                                    <div class="card-agendamento-jogador-text">
                                                        <label style={{ "color": "#029EFB" }}>Jog.Responsável</label>
                                                        <label>Nome Jogador</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-horario">
                                                    <label>11:00</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-agendamento-tenis">
                                            <div class="card-agendamento-container">
                                                <div class="card-agendamento-quadra">
                                                    <img src={quadraTenis} alt="Quadra Tênis"></img>
                                                </div>
                                                <div class="card-agendamento-nome-quadra">
                                                    <label style={{ "color": "#029EFB" }}>Quadra</label>
                                                    <label>Quadra A1</label>
                                                </div>
                                                <div class="card-agendamento-modalidade">
                                                    <div class="card-agendamento-modalidade-text">
                                                        <label style={{ "color": "#029EFB" }}>Modalidade</label>
                                                        <label>Tênis</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-jogador">
                                                    <div class="card-agendamento-jogador-text">
                                                        <label style={{ "color": "#029EFB" }}>Jog.Responsável</label>
                                                        <label>Nome Jogador</label>
                                                    </div>
                                                </div>
                                                <div class="card-agendamento-horario">
                                                    <label>12:00</label>
                                                </div>
                                            </div>
                                        </div>
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
