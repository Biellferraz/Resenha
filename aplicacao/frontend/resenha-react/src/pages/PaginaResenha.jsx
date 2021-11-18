import React from "react";
import { Helmet } from 'react-helmet';
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

function PaginaResenha() {
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
                    <div class="container">
                        {/* sidebar começo */}
                        <div class="sidebar">
                            <center>
                                <img src={logoResenha} class="image" alt="Logo Resenha" />
                            </center>

                            <div class="container-menu">
                                <div class="menu-content">
                                    <div class="inicio-menu" >
                                        <div class="menu-img">
                                            <img src={imgMenuInicioSelecionado} alt="Imagem Menu Início" />
                                        </div>
                                        <div class="menu-text">
                                            <label style={{ "color": "#8FD5FE" }}>INICIO</label>
                                        </div>
                                    </div>
                                    <div class="agenda-menu">
                                        <div class="menu-img">
                                            <img src={imgMenuAgendar} alt="Imagem Menu Agendar" />
                                        </div>
                                        <div class="menu-text">
                                            <label>AGENDAR HORARIO</label>
                                        </div>
                                    </div>
                                    <div class="centro-menu">
                                        <div class="menu-img">
                                            <img src={imgMenuCentros} alt="Imagem Menu Cadastrar Centros" />
                                        </div>
                                        <div class="menu-text">
                                            <label>CADASTRAR CENTROS</label>
                                        </div>
                                    </div>
                                    <div class="quadras-menu">
                                        <div class="menu-img">
                                            <img src={imgMenuQuadras} alt="Imagem Menu Cadastrar Quadras" />
                                        </div>
                                        <div class="menu-text">
                                            <label>CADASTRAR QUADRAS</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="menu-footer">
                                    <div class="sair-menu">
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
                                        <label>Bem-Vindo <span>Usuário</span></label>
                                    </div>
                                    <div class="header-info-date">
                                        <label>17 de Novembro de 2021</label>
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
                                                    <option value="arena">Arena Poliesportivas</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="quadras-content">
                                        <div class="card-quadra-futebol">

                                            
                                        </div>
                                        <div class="card-quadra-tenis">
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
