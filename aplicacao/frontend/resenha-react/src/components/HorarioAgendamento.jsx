import React from "react";

function HorarioAgendamento(props) {
    return (
        <div class="agendamento-quadra-horario" onClick={props.funcao}>
            <label>{props.horarioInicial} - {props.horarioFinal || " "}</label>
        </div>
    )
}
export default HorarioAgendamento;