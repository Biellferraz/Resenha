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
import quadraAgendamento from "../html-css-template/img/quadra-agendamento.svg";
import bolaVolei from "../html-css-template/img/volei-ball.svg";
import quadraVolei from "../html-css-template/img/quadra-volei.svg";
import horario from "../html-css-template/img/clock.svg";
import centroEsportivo from "../html-css-template/img/centro-esportivo.svg";
import cadernoAgendamento from "../html-css-template/img/caderno-agendamento.svg";
import moeda from "../html-css-template/img/coin.svg";

function PaginaAgendamento() {
    const MySwal = withReactContent(Swal);
    const history = useHistory();

    const [centros, setCentros] = useState([]);
    const [quadras, setQuadras] = useState([]);
    const [quadra, setQuadra] = useState([]);

    const [selectCentroValue, setSelectCentroValue] = useState(1);
    const [selectQuadraValue, setSelectQuadraValue] = useState(1);

    const [horaDataDigitada, setHoraDataDigitada] = useState("");
    const [precoDigitado, setPrecoDigitado] = useState("");

    let fkLocatario;
    let fkCentroEsportivo;
    let dataAtual;

    let dataNascimentoValidada = false;

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
            // let numeroQuadraRecuperado = document.getElementById("numero_quadra");
            // let modalidadeRecuperado = document.getElementById("modalidade_quadra");

            // let numeroQuadra = quadra.numero_quadra;
            // let modalidade = quadra.modalidade;

            nome.innerHTML = `${nomeLocatario}`;
            sobrenome.innerHTML = `${sobrenomeLocatario}`;
            // numeroQuadraRecuperado.innerHTML = `${numeroQuadra}`;
            // modalidadeRecuperado.innerHTML = `${modalidade}`;
        }
    }

    // function validarData(data) {
    //     var data_array = data.split("-");
    //     var dia = data_array[2];
    //     var mes = data_array[1];
    //     var ano = data_array[0];

    //     if (data_array[0].length !== 4) {
    //         dia = data_array[0];
    //         mes = data_array[1];
    //         ano = data_array[2];
    //     }

    //     var hoje = new Date();
    //     var d1 = hoje.getDate();
    //     var m1 = hoje.getMonth() + 1;
    //     var a1 = hoje.getFullYear();

    //     d1 = new Date(a1, m1, d1);
    //     var d2 = new Date(ano, mes, dia);

    //     var diff = d2.getTime() - d1.getTime();
    //     diff = diff / (1000 * 60 * 60 * 24);

    //     console.log("Retorno do Diff", diff);
    //     if (diff !== 0) {
    //         dataNascimentoValidada = true;
    //     }
    // }



    function Agendar(e) {
        e.preventDefault();

        // validarData(horaDataDigitada);

        var data = new Date();

        // Guarda cada pedaço em uma variável
        var dia = data.getDate();           // 1-31
        var dia_sem = data.getDay();            // 0-6 (zero=domingo)
        var mes = data.getMonth();          // 0-11 (zero=janeiro)
        var ano2 = data.getYear();           // 2 dígitos
        var ano4 = data.getFullYear();       // 4 dígitos
        var hora = data.getHours();          // 0-23
        var min = data.getMinutes();        // 0-59
        var seg = data.getSeconds();        // 0-59
        var mseg = data.getMilliseconds();   // 0-999
        var tz = data.getTimezoneOffset(); // em minutos

        // Formata a data e a hora (note o mês + 1)
        var str_data = dia + '/' + (mes + 1) + '/' + ano4;
        var str_hora = hora + ':' + min + ':' + seg;

        // Mostra o resultado
        alert('Hoje é ' + str_data + ' às ' + str_hora);


        if (dataNascimentoValidada === true) {
            MySwal.fire({
                title: 'Agendamento não realizado!',
                text: 'Data deve ser depois do dia de hoje',
                icon: 'error',
                confirmButtonText: 'Ok',
            })
        } else {
            api.post("/agendamentos", {
                hora_Marcada: horaDataDigitada,
                preco: precoDigitado,
                fkQuadra: quadra.id,
                fk_Jogador: 103
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
                    text: 'Erro ao agendar no banco de dados',
                    icon: 'error',
                    confirmButtonText: 'Ok',
                })
                console.log(erro);
            })
        }
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
                                                <img src={imgMenuAgendarSelecionado} alt="Imagem Menu Agendar" />
                                            </div>
                                            <div class="menu-text">
                                                <label style={{ "color": "#8FD5FE" }}>AGENDAR HORARIO</label>
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
                            <div class="content-body-agendamento">
                                <div class="agendamento-header">
                                    <div class="agendamento-select-centro">
                                        <div class="select-centro-title">
                                            <div class="select-img">
                                                <img src={centroEsportivo} alt="Centro Esportivo"></img>
                                            </div>
                                            <div class="select-label">
                                                <label>Selecione um centro esportivo</label>
                                            </div>
                                        </div>
                                        <div class="select-centro-info">
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
                                    <div class="agendamento-select-quadra" id="select_quadra">
                                        <div class="select-quadra-title">
                                            <div class="select-img">
                                                <img src={quadraAgendamento} alt="Quadra"></img>
                                            </div>
                                            <div class="select-label">
                                                <label>Selecione uma Quadra</label>
                                            </div>
                                        </div>
                                        <div class="select-quadra-info">
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
                                <div class="agendamento-body">
                                    <form class="agendamento-body-container" onSubmit={Agendar}>
                                        {/* <div class="agendamento-body-header">
                                            <div class="agendamento-body-header-img">
                                                <img src={bolaVolei} alt=""></img>
                                            </div>
                                            <div class="agendamento-body-header-title">
                                                <label>Quadra <span id="numero_quadra"></span></label>
                                                <label style={{ "color": "#029EFB" }}><span id="modalidade_quadra"></span></label>
                                            </div>
                                        </div> */}
                                        <div class="agendamento-body-content">
                                            <div class="agendamento-body-quadra-A">
                                                <div class="agendamento-quadra-A-img">
                                                    <img src={quadraVolei} alt=""></img>
                                                </div>
                                                <div class="agendamento-quadra-A-horarios">
                                                    <div class="agendamento-quadra-A-title">
                                                        <img src={horario} alt="Horário"></img>
                                                        <label>Horários da Quadra:</label>
                                                    </div>
                                                    <div class="agendamento-quadra-A-time">
                                                        <div class="agendamento-quadra-horario">
                                                            <label>09:00 - 10:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>10:00 - 11:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>11:00 - 12:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>12:00 - 13:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>13:00 - 14:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>14:00 - 15:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>15:00 - 16:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>16:00 - 17:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>17:00 - 18:00</label>
                                                        </div>
                                                        <div class="agendamento-quadra-horario">
                                                            <label>18:00 - 19:00</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="agendamento-body-quadra-B">
                                                <div class="agendamento-campo-horario">
                                                    <div class="agendamento-campo-horario-header">
                                                        <img src={cadernoAgendamento} alt="Horário Agendamento"></img>
                                                        <label>Horário</label>
                                                    </div>
                                                    <div class="agendamento-campo-horario-content">
                                                        <input type="datetime-local" name="horario_agendamento" id="horario_agendamento" onChange={e => setHoraDataDigitada(e.target.value)} required></input>
                                                    </div>
                                                </div>
                                                <div class="agendamento-campo-valor">
                                                    <div class="agendamento-campo-valor-header">
                                                        <img src={moeda} alt="Valor"></img>
                                                        <label>Valor</label>
                                                    </div>
                                                    <div class="agendamento-campo-valor-content">
                                                        <label>R$</label>
                                                        <input type="number" name="valor_agendamento" id="valor_agendamento" onChange={e => setPrecoDigitado(e.target.value)} required></input>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="agendamento-body-footer">
                                            <button type="submit">Agendar</button>
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