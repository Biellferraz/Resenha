import React from "react";
import { Link } from "react-router-dom";

function Botao(props) {
    return (
        <>
            <Link to={props.destino}>
                <button class="btn">{props.texto}</button>
            </Link>
        </>
    );
}

export default Botao;