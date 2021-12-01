import React from "react";
import quadraFutebol from "../html-css-template/img/quadra-futebol.svg";
import bolaFutebol from "../html-css-template/img/futball-ball.svg";
import playerResenha from "../html-css-template/img/card-player.svg";

function CardQuadra(props) {
    return (
        <>
             <div class="card-container">
                        <div class="card-header">
                          <div class="card-header-inicio-title">
                            <span>Quadra {props.numero}</span>
                          </div>
                          <div class="card-header-img">
                            <img src={bolaFutebol} alt="Bola Tênis"></img>
                          </div>
                        </div>
                        <div class="card-body">
                          <div class="card-body-img">
                            <img src={quadraFutebol } alt="Quadra Tênis"></img>
                          </div>
                        </div>
                        <div class="card-body-content">
                           <label>{props.modalidade}</label>
                            <label>{props.disponivel}</label>
                          </div>
                        <div class="card-footer">
                          <div class="card-footer-img">
                            <img src={playerResenha} alt="Resenha"></img>
                          </div>
                        </div>
                      </div>
        </>
    )
}
export default CardQuadra;