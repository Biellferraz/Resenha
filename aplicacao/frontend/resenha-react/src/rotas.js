import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import PaginaLogin from "./pages/PaginaLogin";
import PaginaCadastro from "./pages/PaginaCadastro";
import PaginaInicial from "./pages/PaginaInicial";
function Rotas() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={PaginaInicial}/>
        <Route exact path="/login" component={PaginaLogin} />
        <Route exact path="/cadastrar" component={PaginaCadastro} />
      </Switch>
    </BrowserRouter>
  );
}

export default Rotas;
