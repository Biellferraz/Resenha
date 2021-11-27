import React from "react";
import './styles.css'
function CampoFormularioExtended(props) {
    return (
        <>
            <div class="campo-form-extended">
                <label>{props.nomeCampo}</label>
                <input type={props.type} id={props.id} name={props.name} />
            </div>
        </>
    )
}

export default CampoFormularioExtended;