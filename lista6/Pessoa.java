package lista6;

public abstract class Pessoa {

    private String nome;
    private String cpf;

    /**
     * @param nome Recebe o nome da pessoa
     * @param cpf Recebe o CPF da pessoa
     * @throws IllegalArgumentException se o nome for nulo, vazio ou contiver apenas espaços
     * @throws IllegalArgumentException se o CPF for nulo, vazio ou contiver apenas espaços
     */
    public Pessoa (String nome, String cpf){
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio ou conter espaço!!");
        }
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio ou conter espaço!!");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Método subEscrita para melhor legibidade, faz com que
     * quando chama o object mostre algo mais contextual do object
     */
    @Override
    public String toString() {
        return "Pessoa: " + this.nome + " CPF: " + this.cpf;
    }

    /**
     * Metodo abstract para retorna um resumo das Informações.
     */
    public abstract String getResumo();

    /**
     * Cria os métodos gets e Sets
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
