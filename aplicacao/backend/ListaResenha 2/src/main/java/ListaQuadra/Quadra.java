package ListaQuadra;

public class Quadra {

    private Integer id;
    private String modalidade;
    private Integer numeroQuadra;
    private Boolean disponivel;

    public Quadra(Integer id, String modalidade, Integer numeroQuadra, Boolean disponivel) {
        this.id = id;
        this.modalidade = modalidade;
        this.numeroQuadra = numeroQuadra;
        this.disponivel = disponivel;
    }

    public Integer getId() {
        return id;
    }

    public String getModalidade() {
        return modalidade;
    }

    public Integer getNumeroQuadra() {
        return numeroQuadra;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "\nQuadra: " +
                " id=" + id +
                ", modalidade='" + modalidade + '\'' +
                ", numeroQuadra=" + numeroQuadra +
                ", disponivel=" + disponivel +
                '\n';
    }
}
