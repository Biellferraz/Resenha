import React from "react";
import './styles.css'
import { Link } from "react-router-dom";

function BotaoFormulario(props) {
    return (
        <>
            <div class="botao-formulario-container">
                <div class="sendbutton-form">
                    <button>{props.textoBotao}</button>
                </div>
                <div class="button-form-footer">
                    <label>
                        {props.textoFooter}
                        <Link to={props.destino} style={{ textDecoration: 'none' }}>
                            <b> {props.redirectFooter}</b>
                        </Link>
                    </label>
                </div>
            </div>
        </>
    )
}

export default BotaoFormulario;