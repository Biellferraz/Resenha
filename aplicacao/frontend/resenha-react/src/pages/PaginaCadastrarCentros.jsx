import React from "react";
import { Helmet } from 'react-helmet';
import { Link } from "react-router-dom";
import favicon from "../html-css-template/img/resenha-icon.ico";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import imgMenuInicio from "../html-css-template/img/inicio-menu.svg";
import imgMenuAgendar from "../html-css-template/img/agenda-menu-lateral.svg";
import imgMenuCentrosSelecionado from "../html-css-template/img/cadastrar-centro-menu-lateral-azul.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral.svg";
import imgMenuSair from "../html-css-template/img/botao-sair-menu-lateal.svg";
import bolaResenha from "../html-css-template/img/ball.svg";
import calendario from "../html-css-template/img/calendar.svg";
import logoQuadra from "../html-css-template/img/resenha-quadra-inicio.svg";
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";

function CadastrarCentros() {
    return (
        <>
            <Helmet>
                <title>Cadastrar Centros</title>
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
                                                <img src={imgMenuCentrosSelecionado} alt="Imagem Menu Cadastrar Centros" />
                                            </div>
                                            <div class="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>CADASTRAR CENTROS</label>
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
                                <div class="content-body-centros">
                                    <div class="centros-content">
                                        <div class="card-cadastrar-centros">
                                            <form class="card-centro-container">
                                                <div class="card-centro-header">
                                                    <div class="card-header-title">
                                                        <img src={centroEsportivo} alt="Centro Esportivo" />
                                                        <span>CADASTRO DE CENTROS ESPORTIVOS</span>
                                                    </div>
                                                </div>
                                                <div class="card-centro-body">
                                                    <div class="card-centro-body-A">
                                                        <div class="campo-centro-nome">
                                                            <label>Nome do centro esportivo</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-telefone">
                                                            <label>Telefone</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-cep">
                                                            <label>Cep</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-cnpj">
                                                            <label>CNPJ</label>
                                                            <input type="text" />
                                                        </div>
                                                    </div>
                                                    <div class="card-centro-body-B">
                                                        <div class="campo-centro-horario-abre">
                                                            <label>Horario que abre</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-horario-fecha">
                                                            <label>Horario que fecha</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-numero-centro">
                                                            <label>Numero do Centro</label>
                                                            <input type="text" />
                                                        </div>
                                                        <div class="campo-centro-vazio">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-centro-footer">
                                                    <div class="card-centro-footer-limpar">
                                                        <button>limpar</button>
                                                    </div>
                                                    <div class="card-centro-footer-cadastrar">
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

export default CadastrarCentros;
