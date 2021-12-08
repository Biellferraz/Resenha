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
import imgMenuCentrosSelecionado from "../html-css-template/img/cadastrar-centro-menu-lateral-azul.svg";
import imgMenuQuadras from "../html-css-template/img/cadastrar-quadra-menu-lateral.svg";
import imgMenuSair from "../html-css-template/img/botao-sair-menu-lateal.svg";
import bolaResenha from "../html-css-template/img/ball.svg";
import calendario from "../html-css-template/img/calendar.svg";
import logoQuadra from "../html-css-template/img/resenha-quadra-inicio.svg";
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";

function CadastrarCentros() {
    const MySwal = withReactContent(Swal);
    const history = useHistory();

    let [nomeCentroDigitado, setNomeCentroDigitado] = useState("");
    let [telefoneCentroDigitado, setTelefoneCentroDigitado] = useState("");
    let [cepCentroDigitado, setCepCentroDigitado] = useState("");
    let [cnpjCentroDigitado, setCnpjCentroDigitado] = useState("");
    let [horarioAbreCentroDigitado, setHorarioAbreCentroDigitado] = useState("");
    let [horarioFechaCentroDigitado, setHorarioFechaCentroDigitado] = useState("");
    let [numeroCentroDigitado, setNumeroCentroDigitado] = useState("");
    let [cidadeCentroDigitado, setCidadeCentroDigitado] = useState("");
    let fkLocatario;

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

        api.post("/centros", {
            nome: nomeCentroDigitado,
            telefone: telefoneCentroDigitado,
            cep: cepCentroDigitado,
            cnpj: cnpjCentroDigitado,
            horaAbre: horarioAbreCentroDigitado,
            horaFecha: horarioFechaCentroDigitado,
            numero: numeroCentroDigitado,
            cidade: cidadeCentroDigitado,
            fkLocatario: fkLocatario,
        }).then((resposta) => {
            MySwal.fire({
                title: 'Centro cadastro com sucesso!',
                text: 'Agora você pode cadastrar suas quadras',
                icon: 'success',
                confirmButtonText: 'Ok',
            })
        }).catch((erro) => {
            MySwal.fire({
                title: 'Centro esportivo não cadastrado!',
                text: 'Erro ao cadastrar no banco de dados',
                icon: 'error',
                confirmButtonText: 'Ok',
            })
            console.log(erro);
        })
    }

    function mascaraTelefone(tel) {
        let valor = tel.value;
        valor = valor.replace(/\D/g, "")
        valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
        valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
        tel.value = valor;
        return;
    }

    function mascaraCEP(t, mask) {
        var i = t.value.length;
        var saida = mask.substring(1, 0);
        var texto = mask.substring(i);
        if (texto.substring(0, 1) !== saida) {
            t.value += texto.substring(0, 1);
        }
    }

    function mascaraCNPJ(v) {
        let valor = v.value;
        valor = valor.replace(/^(\d{2})(\d)/, "$1.$2");
        valor = valor.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3");
        valor = valor.replace(/\.(\d{3})(\d)/, ".$1/$2");
        valor = valor.replace(/(\d{4})(\d)/, "$1-$2");
        v.value = valor;
        return;
    }

    function importarCentros() {
        var formData = new FormData();
        var imagefile = document.querySelector('#file');
        formData.append("arquivo", imagefile.files[0]);
        api.post(`/centros/importacao/${fkLocatario}`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        }).then(() => {
            MySwal.fire({
                title: "Centros importados com sucesso!",
                text: "Seu documento de layout foi lido com sucesso",
                icon: "success",
                confirmButtonText: "Ok",
            });
        }).catch(() => {
            MySwal.fire({
                title: "Erro ao cadastrar centros",
                text: "Não foi possível ler seu documento de layout",
                icon: "error",
                confirmButtonText: "Ok",
            });
        })
    }

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
                    <div className="container-inicio">
                        {/* sidebar começo */}
                        <div className="sidebar">
                            <center>
                                <img src={logoResenha} className="image" alt="Logo Resenha" />
                            </center>

                            <div className="container-menu">
                                <div className="menu-content">
                                    <div className="inicio-menu">
                                        <Link to={"/inicio"} style={{ textDecoration: 'none' }}>
                                            <div className="menu-img">
                                                <img src={imgMenuInicio} alt="Imagem Menu Início" />
                                            </div>
                                            <div className="menu-text">
                                                <label>INICIO</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div className="centro-menu">
                                        <Link to={"/cadastrar-centros"} style={{ textDecoration: 'none' }}>
                                            <div className="menu-img">
                                                <img src={imgMenuCentrosSelecionado} alt="Imagem Menu Cadastrar Centros" />
                                            </div>
                                            <div className="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>CADASTRAR CENTROS</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div className="quadras-menu">
                                        <Link to={"/cadastrar-quadras"} style={{ textDecoration: 'none' }}>
                                            <div className="menu-img">
                                                <img src={imgMenuQuadras} alt="Imagem Menu Cadastrar Quadras" />
                                            </div>
                                            <div className="menu-text">
                                                <label>CADASTRAR QUADRAS</label>
                                            </div>
                                        </Link>
                                    </div>
                                    <div className="agenda-menu">
                                        <Link to={"/agendar"} style={{ textDecoration: 'none' }}>
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
                                        <label>Bem-Vindo <span id="nome"></span> <span id="sobrenome"></span></label>
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
                                <div className="content-body-centros">
                                    <div className="centros-content">
                                        <div className="card-cadastrar-centros">
                                            <form className="card-centro-container" onSubmit={Cadastrar}>
                                                <div className="card-centro-header">
                                                    <div className="card-header-title">
                                                        <img src={centroEsportivo} alt="Centro Esportivo" />
                                                        <span>CADASTRO DE CENTROS ESPORTIVOS</span>
                                                    </div>
                                                </div>
                                                <div className="card-centro-body">
                                                    <div className="card-centro-body-A">
                                                        <div className="campo-centro-nome">
                                                            <label>Nome do centro esportivo</label>
                                                            <input id="nome_centro" type="text" onChange={e => setNomeCentroDigitado(e.target.value)} maxLength="50" required />
                                                        </div>
                                                        <div className="campo-centro-telefone">
                                                            <label>Telefone</label>
                                                            <input type="text" onInput={e => mascaraTelefone(e.target)} maxLength="15" pattern="\(\d{2}\)\s*\d{5}-\d{4}" onChange={e => setTelefoneCentroDigitado(e.target.value)} required />
                                                        </div>
                                                        <div className="campo-centro-cep">
                                                            <label>Cep</label>
                                                            <input type="text" onInput={e => mascaraCEP((e.target), '#####-###')} maxLength="9" pattern="\d{5}-?\d{3}" onChange={e => setCepCentroDigitado(e.target.value)} required />
                                                        </div>
                                                        <div className="campo-centro-cnpj">
                                                            <label>CNPJ</label>
                                                            <input type="text" onInput={e => mascaraCNPJ(e.target)} maxLength="18" pattern="^(\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2})$" onChange={e => setCnpjCentroDigitado(e.target.value)} required />
                                                        </div>
                                                    </div>
                                                    <div className="card-centro-body-B">
                                                        <div className="campo-centro-horario-abre">
                                                            <label>Horario que abre</label>
                                                            <input type="time" pattern="([01][0-9]|2[0-3]):[0-5][0-9])" onChange={e => setHorarioAbreCentroDigitado(e.target.value)} required />
                                                        </div>
                                                        <div className="campo-centro-horario-fecha">
                                                            <label>Horario que fecha</label>
                                                            <input type="time" pattern="([01][0-9]|2[0-3]):[0-5][0-9])" onChange={e => setHorarioFechaCentroDigitado(e.target.value)} required />
                                                        </div>
                                                        <div className="campo-centro-numero-centro">
                                                            <label>Numero do Centro</label>
                                                            <input type="number" onChange={e => setNumeroCentroDigitado(e.target.value)} required />
                                                        </div>
                                                        <div className="campo-centro-cidade">
                                                            <label>Cidade</label>
                                                            <input type="text" onChange={e => setCidadeCentroDigitado(e.target.value)} required />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div className="card-centro-footer">
                                                    <form className='importar-agendamentos' id="uploadForm" enctype="multipart/form-data" onChange={importarCentros}>
                                                        <label>importar Centros Esportivos</label>
                                                        <input type="file" id="file" name="file" />
                                                    </form>
                                                    <div className="footer-buttons">
                                                        <div className="card-centro-footer-limpar">
                                                            <button type="reset">limpar</button>
                                                        </div>
                                                        <div className="card-centro-footer-cadastrar">
                                                            <button type="submit">cadastrar</button>
                                                        </div>
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
