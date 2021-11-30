import React from "react";
import quadraFutebol from "../html-css-template/img/quadra-futebol.svg";
function CardFutebol(props) {
    return (
        <>
            <div class="card-agendamento-futebol">
                <div class="card-agendamento-container">
                    <div class="card-agendamento-quadra">
                        <img src={quadraFutebol} alt="Quadra Futebol"></img>
                    </div>
                    <div class="card-agendamento-nome-quadra">
                        <label style={{ "color": "#029EFB" }}>Quadra</label>
                        <label>{props.quadra}</label>
                    </div>
                    <div class="card-agendamento-modalidade">
                        <div class="card-agendamento-modalidade-text">
                            <label style={{ "color": "#029EFB" }}>Modalidade</label>
                            <label>{props.modalidade}</label>
                        </div>
                    </div>
                    <div class="card-agendamento-horario">
                        <label>{props.horaMarcada}</label>
                    </div>
                </div>
            </div>

        </>
    )

}
export default CardFutebol;