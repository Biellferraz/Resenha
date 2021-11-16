import React from "react";
import { Helmet } from 'react-helmet';
import favicon from "../html-css-template/img/resenha-icon.ico";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import imgMenuInicio from "../html-css-template/img/inicio-menu.svg";
import imgMenuAgendar from "../html-css-template/img/agenda-menu-lateral.svg";
import imgMenuCentros from "../html-css-template/img/cadastrar-centro-menu-lateral.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral.svg";
import imgMenuSair from "../html-css-template/img/botao-sair-menu-lateal.svg";

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
                    <input type="checkbox" id="check" />

                    {/* sidebar começo */}
                    <div class="sidebar">
                        <center>
                            <img src={logoResenha} class="image" alt="Logo Resenha" />
                        </center>

                        <div class="container-menu">
                            <div class="menu-content">
                                <div class="inicio-menu">
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

                    <div class="content"></div>

                </body>

            </html>
        </>
    );
}

export default PaginaResenha;
