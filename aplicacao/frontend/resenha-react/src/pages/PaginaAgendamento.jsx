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
import quadraAgendamento from "../html-css-template/img/quadra-agendamento.svg"
import horario from "../html-css-template/img/clock.svg";
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";
import cadernoAgendamento from "../html-css-template/img/caderno-agendamento.svg";
import moeda from "../html-css-template/img/coin.svg";
import HorarioAgendamento from "../components/HorarioAgendamento";

function PaginaAgendamento() {
    const MySwal = withReactContent(Swal);
    const history = useHistory();

    const [centros, setCentros] = useState([]);
    const [quadras, setQuadras] = useState([]);
    const [quadra, setQuadra] = useState([]);
    const [horarios, setHorarios] = useState([]);

    const [selectCentroValue, setSelectCentroValue] = useState(1);
    const [selectQuadraValue, setSelectQuadraValue] = useState(1);
    const [selectHorarioValue, setSelectHorarioValue] = useState();

    const [dataDigitada, setDataDigitada] = useState("");
    const [precoDigitado, setPrecoDigitado] = useState("")

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

    useEffect(() => {
        async function recuperarHorarios() {
            const resposta = await api.get(`/agendamentos/horarios/${quadra.id}/${dataDigitada}`);
            const aux = resposta.data.map(hour => ({ hour, selected: false }))
            setHorarios(aux)
            sessionStorage.quadra = JSON.stringify(resposta.data);
        }
        recuperarHorarios();
    }, [dataDigitada, quadra.id]);

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
            data: dataDigitada,
            hora: selectHorarioValue,
            preco: precoDigitado,
            idQuadra: quadra.id,
            idJogador: 103
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
                text: 'Deve ser uma data inserida no futuro',
                icon: 'error',
                confirmButtonText: 'Ok',
            })
        })
    }

    function selecionarHorario(horario) {
        setSelectHorarioValue(horario);
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
                                                <img src={imgMenuCentros} alt="Imagem Menu Cadastrar Centros" />
                                            </div>
                                            <div className="menu-text">
                                                <label>CADASTRAR CENTROS</label>
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
                                                <img src={imgMenuAgendarSelecionado} alt="Imagem Menu Agendar" />
                                            </div>
                                            <div className="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>AGENDAR HORARIO</label>
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
                            <div className="content-body-agendamento">
                                <div className="agendamento-header">
                                    <div className="agendamento-select-centro">
                                        <div className="select-centro-title">
                                            <div className="select-img">
                                                <img src={centroEsportivo} alt="Centro Esportivo"></img>
                                            </div>
                                            <div className="select-label">
                                                <label>Selecione um centro esportivo</label>
                                            </div>
                                        </div>
                                        <div className="select-centro-info">
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
                                    <div className="agendamento-select-quadra" id="select_quadra">
                                        <div className="select-quadra-title">
                                            <div className="select-img">
                                                <img src={quadraAgendamento} alt="Quadra"></img>
                                            </div>
                                            <div className="select-label">
                                                <label>Selecione uma Quadra</label>
                                            </div>
                                        </div>
                                        <div className="select-quadra-info">
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
                                <div className="agendamento-body">
                                    <form className="agendamento-body-container" onSubmit={Agendar}>
                                        <div className="agendamento-body-header">
                                            <div className="agendamento-campo-dia">
                                                <div className="agendamento-campo-dia-header">
                                                    <img src={calendario} alt="Horário Agendamento"></img>
                                                    <label>SELECIONE O DIA</label>
                                                </div>
                                                <div className="agendamento-campo-dia-content">
                                                    <input type="date" name="data_agendamento" id="horario_agendamento" onChange={e => setDataDigitada(e.target.value)} required></input>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="agendamento-body-content">
                                            <div className="agendamento-body-quadra-A">
                                                <div className="agendamento-quadra-A-img">
                                                    <img src={quadraAgendamento} alt=""></img>
                                                </div>
                                                <div className="agendamento-quadra-A-horarios">
                                                    <div className="agendamento-quadra-A-title">
                                                        <img src={horario} alt="Horário"></img>
                                                        <label>Horários da Quadra:</label>
                                                    </div>
                                                    <div className="agendamento-quadra-A-time">
                                                        {
                                                            horarios.map((item, index) => (
                                                                <HorarioAgendamento funcao={() => selecionarHorario(item.hour)} horarioInicial={item.hour} horarioFinal={typeof (horarios[index + 1]) !== 'undefined' ? horarios[index + 1].hour : "18:00:00"} />
                                                            ))
                                                        }
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="agendamento-body-quadra-B">
                                                <div className="agendamento-campo-horario">
                                                    <div className="agendamento-campo-horario-header">
                                                        <img src={cadernoAgendamento} alt="Horário Agendamento"></img>
                                                        <label>Horário</label>
                                                    </div>
                                                    <div className="agendamento-campo-horario-content">
                                                        <input type="text" name="campo_horario_agendamento" value={selectHorarioValue} id="campo_horario_agendamento" onChange={e => setSelectHorarioValue(e.target.value)}></input>
                                                    </div>
                                                </div>
                                                <div className="agendamento-campo-valor">
                                                    <div className="agendamento-campo-valor-header">
                                                        <img src={moeda} alt="Valor"></img>
                                                        <label>Valor</label>
                                                    </div>
                                                    <div className="agendamento-campo-valor-content">
                                                        <label>R$</label>
                                                        <input type="number" name="valor_agendamento" id="valor_agendamento" onChange={e => setPrecoDigitado(e.target.value)} required></input>
                                                    </div>
                                                </div>
                                                <div className="agendamento-body-footer">
                                                    <button type="submit">Agendar</button>
                                                </div>
                                            </div>
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