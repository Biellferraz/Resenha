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
                        <label>{props.id}</label>
                    </div>
                    <div class="card-agendamento-nome-quadra">
                        <label style={{ "color": "#029EFB" }}>Preço</label>
                        <label>{props.preco}</label>
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