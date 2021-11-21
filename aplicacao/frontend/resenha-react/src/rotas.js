import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import PaginaLogin from "./pages/PaginaLogin";
import PaginaCadastro from "./pages/PaginaCadastro";
import PaginaInicial from "./pages/PaginaInicial";
import PaginaResenha from "./pages/PaginaResenha";
import PaginaCadastrarCentro from "./pages/PaginaCadastrarCentros";
import PaginaCadastrarQuadras from "./pages/PaginaCadastrarQuadras";
import PaginaAgendamento from "./pages/PaginaAgendamento";

function Rotas() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={PaginaInicial} />
        <Route exact path="/login" component={PaginaLogin} />
        <Route exact path="/cadastrar" component={PaginaCadastro} />
        <Route exact path="/cadastrar" component={PaginaCadastro} />
        <Route exact path="/inicio" component={PaginaResenha} />
        <Route exact path="/cadastrar-centros" component={PaginaCadastrarCentro} />
        <Route exact path="/cadastrar-quadras" component={PaginaCadastrarQuadras} />
        <Route exact path="/agendar" component={PaginaAgendamento} />
      </Switch>
    </BrowserRouter>
  );
}

export default Rotas;
