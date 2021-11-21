import React from "react";
import { Helmet } from 'react-helmet';
import favicon from "../html-css-template/img/resenha-icon.ico";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import imgMenuInicio from "../html-css-template/img/inicio-menu.svg";
import imgMenuAgendar from "../html-css-template/img/agenda-menu-lateral.svg";
import imgMenuCentrosSelecionado from "../html-css-template/img/cadastrar-centro-menu-lateral.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral-azul.svg";
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
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";
import quadraEsportiva from "../html-css-template/img/quadra-esportiva-centro.svg";

function CadastrarQuadras() {
    return (
        <>
            <Helmet>
                <title>Cadastrar Quadras</title>
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
                                    <div class="inicio-menu" >
                                        <div class="menu-img">
                                            <img src={imgMenuInicio} alt="Imagem Menu Início" />
                                        </div>
                                        <div class="menu-text">
                                            <label>INICIO</label>
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
                                            <img src={imgMenuCentrosSelecionado} alt="Imagem Menu Cadastrar Centros" />
                                        </div>
                                        <div class="menu-text">
                                            <label >CADASTRAR CENTROS</label>
                                        </div>
                                    </div>
                                    <div class="quadras-menu">
                                        <div class="menu-img">
                                            <img src={imgMenuQuadras} alt="Imagem Menu Cadastrar Quadras" />
                                        </div>
                                        <div class="menu-text">
                                            <label style={{ "color": "#8FD5FE" }}>CADASTRAR QUADRAS</label>
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
                                <div class="content-body-quadra">
                                    <div class="quadras-content">
                                        <div class="card-cadastrar-quadra">
                                            <form class="card-quadra-container">
                                                <div class="card-quadra-header">
                                                    <div class="card-header-title">
                                                        <img src={quadraEsportiva} alt="Quadra Esportiva" />
                                                        <span>CADASTRO DE QUADRAS</span>
                                                    </div>
                                                </div>
                                                <div class="card-quadra-body">
                                                    <div class="card-quadra-body-A">
                                                    <div class="campo-quadra-centro">
                                                    <label>SELECIONE UM CENTRO ESPORTIVO</label>
                                                    <select name="centros" id="centros">
                                                    <option value="centro-esportivo" selected>Arena Esportiva</option>
                                                    <option value="centro-esportivo">ABC QUADRAS</option>
                                                    <option value="centro-esportivo">Multiquadras</option>
                                                    <option value="centro-esportivo">Playball</option>
                                                    </select>
                                                    
                                                    </div>
                                                    <div class="campo-quadra-nome">
                                                    <label>Nome da quadra</label>
                                                    <input type="text" />
                                                    </div>
                                                    <div class="campo-modalidade">
                                                    <label>Modalidade</label>
                                                    <select name="modalidade" id="modalidade">
                                                    <option value="modalidades" selected>Futebol</option>
                                                    <option value="modalidades">Volêi</option>
                                                    <option value="modalidades">Basquete</option>
                                                    <option value="modalidades">Tenis</option>
                                                    </select>
                                                    </div>
                                                    <div class="campo-numero-quadra">
                                                    <label>Nº da Quadra</label>
                                                    <input type="text" />
                                                    </div>
                                                    </div>
                                                </div>
                                                <div class="card-quadra-footer">
                                                    <div class="card-quadra-footer-limpar">
                                                    <button>limpar</button>
                                                    </div>
                                                    <div class="card-quadra-footer-cadastrar">
                                                    <button>cadastrar</button>
                                                    </div>
                                                </div>
                                            </form>
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

export default CadastrarQuadras;
