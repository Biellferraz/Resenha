import React from "react";
import './styles.css'
function CampoFormulario(props) {
    return (
        <>
            <div class="campo-form">
                <label>{props.nomeCampo}</label>
                <input type={props.type} id={props.id} name={props.name} />
            </div>
        </>
    )
}

export default CampoFormulario;