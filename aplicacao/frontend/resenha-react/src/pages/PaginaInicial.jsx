import React from "react";
import { Helmet } from "react-helmet";
import favicon from "../html-css-template/img/resenha-icon.ico";
import imgLogin from "../html-css-template/img/login.svg";
import imgCadastro from "../html-css-template/img/cadastro.svg";
import logoResenha from "../html-css-template/img/logo-resenha.svg";
import camisaResenhaFrente from "../html-css-template/img/camisa-resenha-frente.svg";
import resenhaLogoSecundaria from "../html-css-template/img/resenha-logo-secundaria.svg";
import buttonArrow from "../html-css-template/img/button-arrow.svg";
import camisaResenhaAtras from "../html-css-template/img/camisa-resenha-atras.svg";
import logoSolo from "../html-css-template/img/logo-solo.png";
import agenda from "../html-css-template/img/agenda.svg";
import coneLogo from "../html-css-template/img/cone-logo.svg";
import bolaLogo from "../html-css-template/img/bola-logo.svg";
import quadraSobre from "../html-css-template/img/quadra-sobre.png";
import imgFlag from "../html-css-template/img/flag.svg";
import funcionanlidadeAgendamento from "../html-css-template/img/funcionalidade-agendamento.svg";
import funcionanlidadeQuadra from "../html-css-template/img/funcionalidade-quadra.svg";
import funcionanlidadeAluguel from "../html-css-template/img/funcionalidade-aluguel.svg";
import funcionanlidadeRegiao from "../html-css-template/img/funcionalidade-regiao.svg";
import funcionanlidadeBoleto from "../html-css-template/img/funcionalidade-boleto.svg";
import funcionanlidadeContato from "../html-css-template/img/funcionalidade-contato.svg";
import logoSoloEquipe from "../html-css-template/img/logo-solo.png";
import ferraz from "../html-css-template/img/fotos-equipe/Gabriel_ferraz.png";
import gitFerraz from "../html-css-template/img/icon-github.svg";
import lnFerraz from "../html-css-template/img/icon-linkedin.svg";
import gw from "../html-css-template/img/fotos-equipe/wesley.png";
import gitGw from "../html-css-template/img/icon-github.svg";
import lnGw from "../html-css-template/img/icon-linkedin.svg";
import pedrao from "../html-css-template/img/fotos-equipe/pedrao.png";
import gitPedrao from "../html-css-template/img/icon-github.svg";
import lnPedrao from "../html-css-template/img/icon-linkedin.svg";
// import vini from "../html-css-template/img/fotos-equipe/vini.png";
// import gitVini from "../html-css-template/img/icon-github.svg";
// import lnVini from "../html-css-template/img/icon-linkedin.svg";
import bruno from "../html-css-template/img/fotos-equipe/bruno.png";
import gitBruno from "../html-css-template/img/icon-github.svg";
import lnBruno from "../html-css-template/img/icon-linkedin.svg";
import jean from "../html-css-template/img/fotos-equipe/jean.png";
import gitJean from "../html-css-template/img/icon-github.svg";
import lnJean from "../html-css-template/img/icon-linkedin.svg";
import jailson from "../html-css-template/img/fotos-equipe/jailson.png";
import gitJailson from "../html-css-template/img/icon-github.svg";
import lnJailson from "../html-css-template/img/icon-linkedin.svg";
import mathias from "../html-css-template/img/fotos-equipe/mathias.png";
import gitMathias from "../html-css-template/img/icon-github.svg";
import lnMathias from "../html-css-template/img/icon-linkedin.svg";
import logoResenhaContato from "../html-css-template/img/logo-resenha.svg";
import resenhaBall from "../html-css-template/img/resenha-ball.svg";
import logoResenhaFull from "../html-css-template/img/logo-resenha-full.svg";
import insta from "../html-css-template/img/resenha-instagram.svg";
import face from "../html-css-template/img/resenha-facebook.svg";
import whats from "../html-css-template/img/resenha-whatsapp.svg";
import resenhaPhone from "../html-css-template/img/resenha-phone.svg";
import resenhaEmail from "../html-css-template/img/resenha-email.svg";
import { Link } from "react-router-dom";

function PaginaInicial() {
  return (
    <>
      <Helmet>
        <title>Resenha</title>
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
          <title>Resenha2</title>
          <link href="../css/header.css" rel="stylesheet" />
          <link href="../css/index.css" rel="stylesheet" />
          <link href="../css/footer.css" rel="stylesheet" />
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
        <body>
          <section id="home">
            <header>
              <div className="logo">
                <a href="#home">
                  <img id="logoResenha" src={logoResenha} alt="Logo" />
                </a>
              </div>

              <div className="nav-bar">
                <div className="nav-options">
                  <label>
                    <a href="#sobre">SOBRE</a>
                  </label>
                  <label>
                    <a href="#funcionalidades">FUNCIONALIDADES</a>
                  </label>
                  <label>
                    <a href="#equipe">NOSSA EQUIPE</a>
                  </label>
                  <label>
                    <a href="#contato">ENTRE EM CONTATO</a>
                  </label>
                </div>
                <div className="nav-buttons">
                  <Link to={"/cadastrar"}>
                    <div className="nav-buttons-field">
                      <img src={imgCadastro} alt="Cadastro" />
                      <label>EXPERIMENTE JÁ</label>
                    </div>
                  </Link>
                  <Link to={"/login"}>
                    <div className="nav-buttons-field">
                      <img src={imgLogin} alt="Login" />
                      <label>LOGIN</label>
                    </div>
                  </Link>
                </div>
              </div>
            </header>
            <div className="sub-header">
              <label>
                DEIXE O RESENHA2
                <br />
                CUIDAR DE SEU JOGO
              </label>
            </div>
            <div className="home">
              <div className="home-img1">
                <img src={camisaResenhaFrente} alt="Camisa Resenha Frente" />
              </div>
              <div className="home-content">
                <div className="home-content-header">
                  <label>
                    APLICAÇÃO PARA LOCAÇÃO E<br />
                    AGENDAMENTO DE QUADRAS ESPORTIVAS
                  </label>
                </div>
                <div className="home-content-divider">
                  <div className="divider-container">
                    <div className="divider-line">
                      <label>.</label>
                    </div>
                    <div className="divider-img">
                      <img
                        src={resenhaLogoSecundaria}
                        alt="Logo Resenha Secundário"
                      />
                    </div>
                    <div className="divider-line">
                      <label>.</label>
                    </div>
                  </div>
                </div>
                <div className="home-content-text">
                  <p />
                  Automatização do sistema dos Locatários
                  <br />e busca por quadras de esporte com horários
                  <br />
                  disponíveis nas regiões dos Jogadores
                  <p />
                </div>
                <div className="home-content-button">
                  <a href="#sobre">
                    <label className="home-button">SAIBA MAIS</label>
                  </a>
                  <div className="home-arrow-button">
                    <img src={buttonArrow} alt="Arrow Button" />
                  </div>
                </div>
              </div>
              <div className="home-img2">
                <img src={camisaResenhaAtras} alt="Camisa Resenha Atrás" />
              </div>
            </div>
          </section>
          <section id="sobre">
            <div className="sobre">
              <div className="sobre-content2">
                <div className="logo-sobre">
                  <div className="logo-solo">
                    <img src={logoSolo} alt="logo-solo" />
                  </div>
                  <div className="sobre-content">
                    <div className="sobre-content-header">
                      <label>O QUE É O RESENHA?</label>
                    </div>
                  </div>
                </div>
                <div className="sobre-content-text-principal">
                  <div className="sobre-content-text">
                    <label>
                      O RESENHA é um grupo que tem como objetivo proporcionar a
                      melhor experiência para os donos de quadras e jogadores
                      com relação a locação de quadras esportivas
                    </label>
                  </div>
                  <div className="sobre-content-text2">
                    <div>
                      <img src={agenda} alt="agenda-logo" />
                    </div>
                    <p>
                      Nossos LOCATÁRIOS podem ter um sistema próprio para o
                      gerenciamento de horários e de uso em suas quadras
                    </p>
                  </div>
                  <div className="sobre-content-text3">
                    <div>
                      <img src={coneLogo} alt="cone-logo3" />
                    </div>
                    <p>
                      Nossos JOGADORES, podem ter um app responsável por fazer a
                      busca por quadras disponíveis em sua região, com suas
                      informações e seus horários
                    </p>
                  </div>
                  <div className="sobre-content-text4">
                    <div>
                      <img src={bolaLogo} alt="bola-logo4" />
                    </div>
                    <p>
                      Como INTERMEDIÁRIOS, cuidamos e assumimos a
                      responsabilidade de estabelecer o melhor contato possivel
                      entre o locatários e seus jogadores
                    </p>
                  </div>
                </div>
              </div>
              <div className="sobre-img">
                <img src={quadraSobre} alt="Quadra esportiva" />
              </div>
            </div>
          </section>
          <section id="funcionalidades">
            <div className="funcionalidades">
              <div className="funcionalidades-container">
                <div className="funcionalidades-header">
                  <div className="funcionalidades-header-container">
                    <img src={imgFlag} alt="Flag Funcionalidades" />
                    <label>Funcionalidades</label>
                  </div>
                </div>
                <div className="funcionalidades-content">
                  <div className="funcionalidades-content-box-A">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeAgendamento}
                          alt="Flag Funcionalidades"
                        />
                        <label>Agendamentos</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Como LOCATÁRIO, gerencie o agendamento de horários de uso
                      em suas quadras esportivas de forma mais rápida e
                      eficiente de acordo com a preferência dos JOGADORES
                    </p>
                  </div>
                  <div className="funcionalidades-content-box-B">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeQuadra}
                          alt="Flag Funcionalidades"
                        />
                        <label>Gerenciamento de Quadras</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Você como LOCATÁRIO que possui mais de um tipo de quadra
                      esportiva, faça o gerenciamento de cada uma delas de
                      acordo com sua modalidade
                    </p>
                  </div>
                  <div className="funcionalidades-content-box-A">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeAluguel}
                          alt="Flag Funcionalidades"
                        />
                        <label>Aluguel de Equipamentos</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Como LOCATÁRIO, tenha o controle total dos empréstimos de
                      equipamentos sediados pelo seu centro esportivo de forma
                      mais prática
                    </p>
                  </div>
                  <div className="funcionalidades-content-box-B">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeRegiao}
                          alt="Flag Funcionalidades"
                        />
                        <label>Quadras na Região</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Como JOGADOR, faça a das melhores quadras esportivas
                      disponíveis em sua região de acordo com sua preferência e
                      modalidade
                    </p>
                  </div>
                  <div className="funcionalidades-content-box-A">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeBoleto}
                          alt="Flag Funcionalidades"
                        />
                        <label>Emissão de Boletos</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Como LOCATÁRIO, faça as cobranças através da emissão de
                      boletos para seus jogadores avulsos ou mensalistas.
                    </p>
                  </div>
                  <div className="funcionalidades-content-box-B">
                    <div className="funcionalidades-box-header">
                      <div className="funcionalidades-box-header-container">
                        <img
                          src={funcionanlidadeContato}
                          alt="Flag Funcionalidades"
                        />
                        <label>Informações & Contatos</label>
                      </div>
                    </div>
                    <p className="funcionalidades-box-text">
                      Como JOGADOR, tenha a sua disposição todas as informações
                      necessárias e formas de contato das quadras que você
                      encontrar e p ossuir interesse
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <section id="equipe">
            <div className="equipe">
              <div className="logo-equipe">
                <div className="logo-solo">
                  <img src={logoSoloEquipe} alt="logo-solo" />
                </div>
                <div className="equipe-content">
                  <div className="equipe-content-header">
                    <label>NOSSA EQUIPE</label>
                  </div>
                </div>
              </div>

              <div className="equipe-fotos">
                <div className="container-equipe">
                  <div className="container-equipe-a">
                    <div className="equipe-fotos-a">
                      <img src={bruno} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Bruno Ricardo</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/BrunoRGSilva"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitBruno} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/bruno-ricardo-gomes-silva-618a6b1b4/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnBruno} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                    <div className="equipe-fotos-a">
                      <img src={ferraz} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Gabriel Ferraz</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/Biellferraz"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitFerraz} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/gabriel-ferraz-85baa4129/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnFerraz} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                    <div className="equipe-fotos-a">
                      <img src={gw} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Gabriel Wesley</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/gabrielwesley1"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitGw} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/gabriel-wesley-294b02213/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnGw} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="container-equipe-b">
                    <div className="equipe-fotos-b">
                      <img src={jailson} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Jailson Vitor</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/JAILSON-VITOR"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitJailson} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/jailson-vitor-5444bb1ba/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnJailson} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                    <div className="equipe-fotos-b">
                      <img src={jean} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Jean Sousa</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/jean-sousasilva"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitJean} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/jean-sousa-3a433721a/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnJean} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                    <div className="equipe-fotos-b">
                      <img src={mathias} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Mathias Carvalho</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/dasSouza"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitMathias} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/mathias-de-souza-953068205/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnMathias} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                    <div className="equipe-fotos-b">
                      <img src={pedrao} alt="" />
                      <div className="equipe-content-fotos">
                        <div className="equipe-content-username">
                          <h4>
                            <b>Pedro Leiva</b>
                          </h4>
                        </div>
                        <div className="equipe-content-midia">
                          <a
                            href="https://github.com/PedroLeiva"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={gitPedrao} alt="" />
                          </a>
                          <a
                            href="https://www.linkedin.com/in/pedro-henrique-l-a43104169/"
                            rel="noreferrer"
                            target="_blank"
                          >
                            {" "}
                            <img src={lnPedrao} alt="" />
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>

                  {/* <div className="equipe-fotos">
                    <img src={vini} alt="" />
                    <div className="equipe-content-fotos">
                      <div className="equipe-content-username">
                        <h4>
                          <b>Vinicius Oliveira</b>
                        </h4>
                      </div>
                      <div className="equipe-content-midia">
                        <a
                          href="https://github.com/akzv-oliveira"
                          rel="github"
                          target="_blank"
                        >
                          {" "}
                          <img src={gitVini} alt="" />
                        </a>
                        <a
                          href="https://www.linkedin.com/in/akz-oliveira/"
                          rel="linkedin"
                          target="_blank"
                        >
                          {" "}
                          <img src={lnVini} alt="" />
                        </a>
                      </div>
                    </div>
                  </div> */}
                </div>
              </div>
            </div>
          </section>
          <section id="contato">
            <div className="contato">
              <div className="contato-container">
                <div className="contato-container-side-A">
                  <div className="contato-slogan">
                    <img src={logoResenhaContato} alt="Logo Resenha" />
                    <label>Entre em contato conosco</label>
                  </div>
                </div>
                <div className="contato-container-side-B">
                  <div className="contato-form">
                    <div className="contato-form-container">
                      <div className="contato-form-header">
                        <div className="contato-form-title">
                          <img src={resenhaBall} alt="Resenha Form" />
                          <label>Entre em contato!</label>
                        </div>
                        <div className="contato-form-subtitle">
                          Preencha o formulário para contato via e-mail
                        </div>
                      </div>
                      <form className="contato-form-body">
                        <div className="contato-form-inputs">
                          <div className="contato-form-nome">
                            <label for="nome">Nome *</label>
                            <input
                              autocomplete="off"
                              type="text"
                              id="nome"
                              name="nome"
                            />
                          </div>
                          <div className="contato-form-email">
                            <label for="email">E-mail *</label>
                            <input
                              autocomplete="off"
                              type="email"
                              id="email"
                              name="email"
                            />
                          </div>
                          <div className="contato-form-telefone">
                            <label for="telefone">Telefone *</label>
                            <input
                              autocomplete="off"
                              type="number"
                              id="telefone"
                              name="telefone"
                            />
                          </div>
                          <div className="contato-form-cep">
                            <div className="contato-form-cidade">
                              <label for="cidade">Cidade *</label>
                              <input
                                autocomplete="off"
                                type="text"
                                id="cidade"
                                name="cidade"
                              />
                            </div>
                            <div className="contato-form-uf">
                              <label for="uf">UF *</label>
                              <input
                                autocomplete="off"
                                type="text"
                                id="uf"
                                name="uf"
                              />
                            </div>
                          </div>
                          <div className="contato-form-msg">
                            <label for="mensagem">Mensagem</label>
                            <textarea id="mensagem" name="mensagem"></textarea>
                          </div>
                        </div>
                      </form>
                      <div className="contato-form-buttons">
                        <div className="contato-form-sendbutton">
                          <button>Enviar</button>
                        </div>
                        <div className="contato-form-clearbutton">
                          <button>Limpar</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <footer>
            <div className="footer-container">
              <div className="footer-logo">
                <img src={logoResenhaFull} alt="Logo Resenha Completo" />
              </div>
              <div className="footer-contacts">
                <div className="footer-social-medias">
                  <img src={insta} alt="Instagram" />
                  <img src={face} alt="Facebook" />
                  <img src={whats} alt="Whatsapp" />
                </div>
                <div className="footer-phone">
                  <img src={resenhaPhone} alt="Telefone" />
                  <label>Contato: 4242-2424</label>
                </div>
                <div className="footer-email">
                  <img src={resenhaEmail} alt="E-mail" />
                  <label>E-mail: resenha@gmail.com</label>
                </div>
                <div className="footer-copyright">
                  <label>Copyright © resenha 2021</label>
                </div>
              </div>
            </div>
          </footer>
        </body>
      </html>
    </>
  );
}
export default PaginaInicial;
