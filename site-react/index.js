// Como criar um elemento HTML com JS

var divApp = document.getElementById("app");

var divInput = document.getElementById("inputLogin");

// Criação de Título
// var titulo = document.createElement("h1");
// titulo.innerHTML = "Esse título foi criado com JS";

// divApp.appendChild(titulo);

function SegundoComponente(){
    return (
        <ReactDOM
        placeholder="aaaaa">
            
        </ReactDOM>

    )
}

function PrimeiroComponente() {
    return (
        <h1>RESENHA</h1> 

    );
}

ReactDOM.render(PrimeiroComponente(), divApp);
ReactDOM.render(SegundoComponente(), divInput);