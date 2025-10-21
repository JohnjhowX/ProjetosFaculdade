package lista6;
import java.util.ArrayList;

public class Tutor  extends Pessoa implements Registravel{


    /**
     * Representa o tutor de um ou mais animais.
     */
    private String telefone;
    private String endereco;
    private ArrayList<Animal> animais = new ArrayList<>();


    /**
     * Cria um novo tutor com o nome especificado.
     *
     * @param nome O nome do tutor.
     */
    public Tutor(String nome, String cpf) {
        super(nome, cpf);
    }

    /**
     * Cria um novo tutor com os detalhes especificados.
     *
     * @param nome     O nome do tutor.
     * @param telefone O telefone do tutor.
     * @param endereco O endereço do tutor.
     */
    public Tutor(String nome, String telefone, String cpf, String endereco) {
        super(nome, cpf);
        setEndereco(endereco);
        setTelefone(telefone);
    }
    public void registrarNoSistema(){
        System.out.println("Tutor Registrado no sistema");
        System.out.println(getResumo());
    }

    @Override
    public String getResumo() {
        return "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Endereço: " + getEndereco();
    }

    /**
     * Obtém o endereço do tutor.
     *
     * @return O endereço do tutor.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do tutor.
     *
     * @param endereco O novo endereço do tutor.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone do tutor.
     *
     * @return O telefone do tutor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do tutor.
     *
     * @param telefone O novo telefone do tutor.
     * @throws IllegalArgumentException se o telefone for nulo ou vazio.
     */
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
        this.telefone = telefone;
    }

    /**
     * Obtém a lista de animais do tutor.
     *
     * @return A lista de animais.
     */
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    /**
     * Adiciona um animal à lista de animais do tutor.
     *
     * @param animal O animal a ser adicionado.
     */
    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    /**
     * Remove um animal da lista de animais do tutor.
     *
     * @param animal O animal a ser removido.
     */
    public void removerAnimal(Animal animal) {
        this.animais.remove(animal);
    }
}
