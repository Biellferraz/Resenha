import React from "react";
import './styles.css'
function BotaoFormulario(props) {
    return (
        <>
            <div class="botao-formulario-container">
                <div class="sendbutton-form">
                    <button>{props.textoBotao}</button>
                </div>
                <div class="button-form-footer">
                    <label>{props.textoFooter} <b>{props.redirectFooter}</b></label>
                </div>
            </div>
        </>
    )
}

export default BotaoFormulario;