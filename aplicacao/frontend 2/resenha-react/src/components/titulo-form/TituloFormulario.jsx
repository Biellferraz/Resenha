import React from "react";
import './styles.css'
function TituloFormulario(props) {
    return (
        <>
            <div class="header-form-container">
                <div class="header-form-img">
                    <img src={props.img} alt="Logo Resenha"></img>
                </div>
                <div class="header-form-texto">
                    <div class="header-form-titulo">
                        <label>{props.titulo}</label>
                    </div>
                    <div class="header-form-subtitulo">
                        <label>{props.subtitulo}</label>
                    </div>
                </div>
            </div>
        </>
    )
}

export default TituloFormulario;