package lista6;

public class AtendimentoRetorno extends Atendimento implements Pagavel{
    private Atendimento atendimentoAnterior;

    public AtendimentoRetorno(Atendimento atendimentoAnterior) {
        if (atendimentoAnterior == null) {
            throw new IllegalArgumentException("Atendimento não pode ser vazio.");
        }
        super();
        this.atendimentoAnterior = atendimentoAnterior;

        // Herda dados do atendimento anterior
        if (atendimentoAnterior != null) {
            this.setAnimal(atendimentoAnterior.getAnimal());
            this.setVeterinario(atendimentoAnterior.getVeterinario());
            this.setData(atendimentoAnterior.getData());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public double getValorTotal() {
        return calcularValor();
    }
    @Override
    public String getDescricaoPagamento(){
        return "Retorno agendado: " + getAnimal().getNome() +
                " com " + this.getVeterinario().getNome() +
                " -Valor com 50% de Desconto: R$ " + calcularValor();
    }

    /**
     *
     */
    @Override
    public int calcularValor(){
        int valor = 150, valorBase;
        valorBase = valor - (valor * 50 / 100);
        return  valorBase;
    }

    @Override
    public void registrar() {
        super.registrar();
        if (atendimentoAnterior != null) {
            System.out.println("Consulta de retorno registrada para " + this.getAnimal().getNome() +
                    ", referente à consulta anterior em " + atendimentoAnterior.getData() + ".");
        }
    }

    public Atendimento getAtendimentoAnterior() { // REMOVER PARÂMETROS
        return atendimentoAnterior;
    }

    public void setAtendimentoAnterior(Atendimento atendimentoAnterior) {
        this.atendimentoAnterior = atendimentoAnterior;
    }
}
