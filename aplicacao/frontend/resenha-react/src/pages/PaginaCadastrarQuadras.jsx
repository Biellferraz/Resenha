import React, { useEffect, useState } from "react";
import { Helmet } from 'react-helmet';
import { Link } from "react-router-dom";
import { useHistory } from "react-router";
import api from "../api";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
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
import quadraEsportiva from "../html-css-template/img/quadra-esportiva-centro.svg";

function CadastrarQuadras() {
    const MySwal = withReactContent(Swal);
    const history = useHistory();

    const [centros, setCentros] = useState([]);
    const [selectCentroValue, setSelectCentroValue] = useState(1);
    const [selectModalidadeValue, setSelectModalidadeValue] = useState("Futebol");
    let [numeroQuadraDigitado, setNumeroQuadraDigitado] = useState("");
    let fkLocatario;

    useEffect(() => {
        validarAutenticacao();
    });

    useEffect(() => {
        async function recuperarCentros() {
            const resposta = await api.get(`/centros/recuperar-centros/${fkLocatario}`);
            setCentros(resposta.data)
        }
        recuperarCentros();
    }, [fkLocatario]);

    function validarAutenticacao() {
        let login_locatario = sessionStorage.locatario;
        if (login_locatario === undefined) {
            logoff();
        } else {
            let locatario = JSON.parse(login_locatario);
            let nomeLocatario = locatario.nome;
            let sobrenomeLocatario = locatario.sobrenome;
            fkLocatario = locatario.id;
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

    function Cadastrar(e) {
        e.preventDefault();

        api.post("/quadras", {
            numero_quadra: numeroQuadraDigitado,
            modalidade: selectModalidadeValue,
            disponivel: 1,
            fkCentroEsportivo: selectCentroValue,
        }).then(() => {
            MySwal.fire({
                title: 'Quadra cadastrada com sucesso!',
                text: 'Agora você pode fazer seus agendamentos',
                icon: 'success',
                confirmButtonText: 'Ok',
            })
        }).catch((erro) => {
            MySwal.fire({
                title: 'Quadra não cadastrada!',
                text: 'Erro ao cadastrar no banco de dados',
                icon: 'error',
                confirmButtonText: 'Ok',
            })
            console.log(erro);
        })
    }

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
                                                <label style={{ "color": "#8FD5FE" }}>CADASTRAR QUADRAS</label>
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
                                        <label>08 de Dezembro de 2021</label>
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
                                            <form class="card-quadra-container" onSubmit={Cadastrar}>
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
                                                            <select value={selectCentroValue} name="centros" id="centros" onChange={e => setSelectCentroValue(e.target.value)}>
                                                                <option value="Selecione">Selecione</option>
                                                                {
                                                                    centros.map((centro) => (
                                                                        <option value={centro.id} id="centro_selecionado">{centro.nome}</option>
                                                                    ))
                                                                }
                                                            </select>

                                                        </div>
                                                        <div class="campo-numero-quadra">
                                                            <label>Nº da Quadra</label>
                                                            <input type="text" onChange={e => setNumeroQuadraDigitado(e.target.value)} />
                                                        </div>
                                                        <div class="campo-modalidade">
                                                            <label>Modalidade</label>
                                                            <select value={selectModalidadeValue} name="modalidades" id="modalidade" onChange={e => setSelectModalidadeValue(e.target.value)}>
                                                                <option value="Futebol">Futebol</option>
                                                                <option value="Vôlei">Volêi</option>
                                                                <option value="Basquete">Basquete</option>
                                                                <option value="Tênis">Tênis</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-quadra-footer">
                                                    <div class="card-quadra-footer-limpar">
                                                        <button type="reset">limpar</button>
                                                    </div>
                                                    <div class="card-quadra-footer-cadastrar">
                                                        <button type="submit">cadastrar</button>
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
