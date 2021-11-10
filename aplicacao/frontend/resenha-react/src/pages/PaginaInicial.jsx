import React from "react";
import imgLogin from "../html-css-template/img/login.svg";
import imgCadastro from "../html-css-template/img/cadastro.svg";
import logoResenha from "../html-css-template/img/logo-resenha2.svg";
import camisaResenhaFrente from "../html-css-template/img/camisa-resenha-frente.svg";
import resenhaLogoSecundaria from "../html-css-template/img/resenha-logo-secundaria.svg";
import buttonArrow from "../html-css-template/img/button-arrow.svg";
import camisaResenhaAtras from "../html-css-template/img/camisa-resenha-atras.svg";
import logoSolo from "../html-css-template/img/logo-solo.png";
import agenda from "../html-css-template/img/agenda.svg";
import coneLogo from "../html-css-template/img/cone-logo.svg";
import bolaLogo from "../html-css-template/img/bola-logo.svg";

function PaginaInicial() {
    return (
        <>
            <html lang="en">
                <head>
                    <meta charset="UTF-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Resenha</title>
                    <link href="../css/header.css" rel="stylesheet" />
                    <link href="../css/index.css" rel="stylesheet" />
                    <link href="../css/footer.css" rel="stylesheet" />
                    <link rel="preconnect" href="https://fonts.googleapis.com" />
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
                    <link href="https://fonts.googleapis.com/css2?family=Spartan&display=swap" rel="stylesheet" />
                    <link href="https://fonts.googleapis.com/css2?family=Spartan:wght@100;200;300;400;500;600;700;800;900&display=swap"
                        rel="stylesheet" />
                </head>
                <body>
                    <section id="home">
                        <header>
                            <div class="logo">
                                <a href="#home" onmouseover="logoResenha.style='height:67px; transition: 0.1s ease-in'"
                                    onmouseleave="logoResenha.style='height:65px; transition: 0.1s ease-out'"><img id="logoResenha"
                                        src={logoResenha} alt="Logo" /></a>
                            </div>

                            <div class="nav-bar">
                                <div class="nav-options">
                                    <label><a href="#sobre">SOBRE</a></label>
                                    <label><a href="#funcionalidades">FUNCIONALIDADES</a></label>
                                    <label><a href="#equipe">NOSSA EQUIPE</a></label>
                                    <label><a href="#contato">ENTRE EM CONTATO</a></label>
                                </div>
                                <div class="nav-buttons">
                                    <div class="nav-buttons-field">
                                        <img src={imgCadastro} alt="Cadastro" />
                                        <label>EXPERIMENTE JÁ</label>
                                    </div>
                                    <div class="nav-buttons-field">
                                        <img src={imgLogin} alt="Login" />
                                        <label>LOGIN</label>
                                    </div>
                                </div>
                            </div>
                        </header>
                        <div class="sub-header">
                            <label>DEIXE O RESENHA<br />CUIDAR DE SEU JOGO</label>
                        </div>
                        <div class="home">
                            <div class="home-img1">
                                <img src={camisaResenhaFrente} alt="Camisa Resenha Frente" />
                            </div>
                            <div class="home-content">
                                <div class="home-content-header">
                                    <label>
                                        APLICAÇÃO PARA LOCAÇÃO E<br />AGENDAMENTO DE QUADRAS ESPORTIVAS
                                    </label>
                                </div>
                                <div class="home-content-divider">
                                    <div class="divider-container">
                                        <div class="divider-line">
                                            <label>
                                                .
                                            </label>
                                        </div>
                                        <div class="divider-img">
                                            <img src={resenhaLogoSecundaria} alt="Logo Resenha Secundário" />
                                        </div>
                                        <div class="divider-line">
                                            <label>
                                                .
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="home-content-text">
                                    <p />Automatização do sistema dos Locatários<br />e busca por quadras de
                                    esporte com horários<br />disponíveis nas regiões dos Jogadores<p />
                                </div>
                                <div class="home-content-button">
                                    <a href="#sobre"><label class="home-button">SAIBA MAIS</label></a>
                                    <div class="home-arrow-button">
                                        <img src={buttonArrow} alt="Arrow Button" />
                                    </div>
                                </div>
                            </div>
                            <div class="home-img2">
                                <img src={camisaResenhaAtras} alt="Camisa Resenha Atrás" />
                            </div>
                        </div>
                    </section>
                    <section id="sobre">
                        <div class="sobre">
                            <div class="sobre-content2">
                                <div class="logo-sobre">
                                    <div class="logo-solo">
                                        <img src={logoSolo} alt="logo-solo" />
                                    </div>
                                    <div class="sobre-content">
                                        <div class="sobre-content-header">
                                            <label>
                                                O QUE É O RESENHA?
                                            </label>
                                        </div>

                                    </div>
                                </div>
                                <div class="sobre-content-text-principal">
                                    <div class="sobre-content-text">
                                        <label>O RESENHA é um grupo que tem como objetivo proporcionar a
                                            melhor
                                            experiência
                                            para os donos de quadras e jogadores com relação a locação
                                            de
                                            quadras esportivas</label>
                                    </div>
                                    <div class="sobre-content-text2">
                                        <div>
                                            <img src={agenda} alt="agenda-logo" />
                                        </div>
                                        <p>Nossos LOCATÁRIOS podem ter um sistema próprio
                                            para o gerenciamento de horários
                                            e de uso em suas quadras</p>
                                    </div>
                                    <div class="sobre-content-text3">
                                        <div>
                                            <img src={coneLogo} alt="cone-logo3" />
                                        </div>
                                        <p>Nossos JOGADORES, podem ter um app responsável por
                                            fazer a busca por quadras
                                            disponíveis em sua região, com suas informações e seus horários</p>
                                    </div>
                                    <div class="sobre-content-text4">
                                        <div>
                                            <img src={bolaLogo} alt="bola-logo4" />
                                        </div>
                                        <p>Como INTERMEDIÁRIOS, cuidamos e assumimos
                                            a responsabilidade
                                            de estabelecer o melhor contato possivel entre o locatários e seus jogadores</p>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </section>
                </body>

            </html>
        </>
    );
}
export default PaginaInicial;