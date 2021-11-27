package ListaCentroEsportivo;

public class CentroEsportivo {

    private Integer idCentroEsportivo;
    private String cnpj;
    private String cep;
    private String cidade;
    private Integer numero;
    private String nome;
    private String horaAbre;
    private String horaFecha;
    private String telefone;

    public CentroEsportivo(Integer idCentroEsportivo, String cnpj, String cep, Integer numero, String cidade, String nome,
                           String horaAbre, String horaFecha, String telefone) {
        this.idCentroEsportivo = idCentroEsportivo;
        this.cnpj = cnpj;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.nome = nome;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
        this.telefone = telefone;
    }

    public Integer getIdCentroEsportivo() {
        return idCentroEsportivo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getHoraAbre() {
        return horaAbre;
    }

    public String getHoraFecha() {
        return horaFecha;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "\nCentroEsportivo: " +
                " idCentroEsportivo=" + idCentroEsportivo +
                ", cnpj='" + cnpj + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", horaAbre='" + horaAbre + '\'' +
                ", horaFecha='" + horaFecha + '\'' +
                ", telefone='" + telefone + '\'' +
                '\n';
    }
}
