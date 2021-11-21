import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import PaginaLogin from "./pages/PaginaLogin";
import PaginaCadastro from "./pages/PaginaCadastro";
import PaginaInicial from "./pages/PaginaInicial";
import PaginaResenha from "./pages/PaginaResenha";
import CadastrarCentro from "./pages/CadastrarCentros";

function Rotas() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={PaginaInicial} />
        <Route exact path="/login" component={PaginaLogin} />
        <Route exact path="/cadastrar" component={PaginaCadastro} />
        <Route exact path="/cadastrar" component={PaginaCadastro} />
        <Route exact path="/inicio" component={PaginaResenha} />
        <Route exact path="/cadastrar-centros" component={CadastrarCentro} />
      </Switch>
    </BrowserRouter>
  );
}

export default Rotas;
