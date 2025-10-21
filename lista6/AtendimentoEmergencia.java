package lista6;

import java.time.LocalDate;

/**
 * Representa um atendimento de emergência veterinário.
 * Esta classe herda de Atendimento e implementa a interface Pagavel,
 *  permitindo o cálculo de valores com base no nível de urgência.
 * @see Atendimento
 * @see Pagavel
 */
public class AtendimentoEmergencia extends Atendimento implements Pagavel{
    /**
     * Nivel de Urgencia entre 1 e 10.
     */
    private int nivelUrgencia;

    /**
     * Cria um novo atendimento de emergência com os detalhes especificados.
     *
     * @param data          A data do atendimento.
     * @param descricao     A descrição do atendimento.
     * @param animal        O animal que está sendo atendido.
     * @param veterinario   O veterinário que realizou o atendimento.
     * @param nivelUrgencia O nível de urgência do atendimento (1-5, sendo 5 o mais urgente).
     */
    public AtendimentoEmergencia(LocalDate data, String descricao, Animal animal, Veterinario veterinario, int nivelUrgencia) {
        if (nivelUrgencia < 1 || nivelUrgencia > 10) {
            throw new IllegalArgumentException("Nivel de Emergência entre 1 e 5.");
        }
        super();
        this.setData(data);
        this.setDescricao(descricao);
        this.setAnimal(animal);
        this.setVeterinario(veterinario);
        this.nivelUrgencia = nivelUrgencia;
    }

    /**
     * Calcula o valor do atendimento de emergência.
     * O valor base é de R$ 150,00 com acréscimo de 10% por nível de urgência.
     * Por exemplo:
     * Nível 1: R$ 165,00 (150 + 10%)
     * Nível 2: R$ 180,00 (150 + 20%)
     * Nível 5: R$ 225,00 (150 + 50%)
     *
     * @return o valor calculado do atendimento em reais
     */
    @Override
    public int calcularValor() {
        int valorBase = 150;
        int acrescimoUrgencia = valorBase + (this.getNivelUrgencia() * 10 / 100);
        return valorBase + acrescimoUrgencia;
    }
    /**
     * Retorna o valor total do atendimento.
     * Este metodo é uma implementação da interface Pagavel e delega o cálculo
     * para o metodo calcularValor().
     *
     * @return o valor total do atendimento como double
     * @see Pagavel#getValorTotal()
     */
    @Override
    public double getValorTotal(){
        return calcularValor();
    }
    /**
     * Retorna uma descrição formatada do pagamento do atendimento.
     * A descricao inclui o tipo de atendimento, nível de urgência e valor total.
     *
     * @return uma string descrevendo os detalhes do pagamento
     * @see Pagavel#getDescricaoPagamento()
     */
    @Override
    public String getDescricaoPagamento(){
        return "Atendimento de emergência - Urgência nível " + getNivelUrgencia() +
                " - Valor: R$ " + getValorTotal();
    }

    /**
     * Sobrescreve o metodo registrar() para incluir mensagem especial de emergência.
     */
    @Override
    public void registrar() {
        System.out.println("Consulta de emergência registrada para " + this.getAnimal().getNome() + "(urgência: " +
                this.getNivelUrgencia() + " com o veterinário " + this.getVeterinario().getNome() + ".");
    }


    /**
     * Obtém o nível de urgência do atendimento.
     *
     * @return O nível de urgência.
     */
    public int getNivelUrgencia(){
        return this.nivelUrgencia;
    }
    /**
     * Define o nível de urgência do atendimento.
     *
     * @param nivelUrgencia O novo nível de urgência.
     */
    public void setNivelUrgencia(int nivelUrgencia){
        if (nivelUrgencia < 1 || nivelUrgencia > 5) {
            throw new IllegalArgumentException("Nível de Emergência deve ser entre 1 e 5.");
        }
        this.nivelUrgencia = nivelUrgencia;
    }
}
