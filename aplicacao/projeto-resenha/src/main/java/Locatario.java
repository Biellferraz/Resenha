public class Locatario extends Usuario{
    private Double salario;

    public Locatario(String nome, String login, String senha, Double salario) {
        super(nome, login, senha);
        this.salario = salario;
    }

    public Double calculaSalario(){
        return salario;
    }

    @Override
    public String toString() {
        return "Locatario{" +
                "salario=" + salario +
                "} " + super.toString();
    }
}
