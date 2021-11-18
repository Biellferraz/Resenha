import React from "react";
import './styles.css'
function CampoFormularioExtended(props) {
    return (
        <>
            <div class="campo-form-extended">
                <label>{props.nomeCampo}</label>
                <input onChange={e => props.onChange} type={props.type} id={props.id} name={props.name} />
            </div>
        </>
    )
}

export default CampoFormularioExtended;