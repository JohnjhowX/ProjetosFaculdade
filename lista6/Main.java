package lista6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("🎯 DEMONSTRAÇÃO DE POLIMORFISMO");
        System.out.println("========================================\n");

        // ============================================
        // 1. POLIMORFISMO COM PESSOAS
        // ============================================

        System.out.println("1. 📋 LISTA DE PESSOAS (Polimorfismo com getResumo())");
        System.out.println("=====================================================");

        // Criando lista polimórfica de Pessoa
        List<Pessoa> pessoas = new ArrayList<>();

        // Adicionando diferentes tipos de Pessoa
        pessoas.add(new Tutor("João Silva", "(11) 99999-1234", "123.456.789-00", "Rua das Flores, 123"));
        pessoas.add(new Veterinario("Dra. Ana Costa", "987.654.321-00", "CRMV-SP 54321", "Clínica Geral"));
        pessoas.add(new Tutor("Maria Santos", "(11) 98888-5555", "111.222.333-44", "Av. Paulista, 1000"));
        pessoas.add(new Veterinario("Dr. Carlos Lima", "555.666.777-88", "CRMV-SP 12345", "Cirurgia"));
        pessoas.add(new Tutor("Pedro Oliveira", "(11) 97777-9999", "999.888.777-66", "Rua Augusta, 500"));

        // Percorrendo a lista - POLIMORFISMO EM AÇÃO!
        for (Pessoa pessoa : pessoas) {
            System.out.println("----------------------------------------");
            System.out.println(pessoa.getResumo()); // Comportamento diferente para cada tipo!
            System.out.println("Tipo real: " + pessoa.getClass().getSimpleName());
        }

        // ============================================
        // 2. POLIMORFISMO COM ATENDIMENTOS
        // ============================================

        System.out.println("\n\n2. 🏥 LISTA DE ATENDIMENTOS (Polimorfismo com exibirResumo())");
        System.out.println("==========================================================");

        // Criando animais e veterinários para os atendimentos
        Tutor tutor1 = new Tutor("João Silva", "(11) 99999-1234", "123.456.789-00", "Rua das Flores, 123");
        Veterinario vet1 = new Veterinario("Dra. Ana Costa", "987.654.321-00", "CRMV-SP 54321", "Clínica Geral");

        Animal animal1 = new Animal("Rex", "Cachorro", 5, "Vacinação em dia");
        Animal animal2 = new Animal("Mimi", "Gato", 3, "Castrado");

        tutor1.adicionarAnimal(animal1);
        tutor1.adicionarAnimal(animal2);

        // Criando lista polimórfica de Atendimento
        List<Atendimento> atendimentos = new ArrayList<>();

        // Criando diferentes tipos de atendimento
        AtendimentoEmergencia emergencia = new AtendimentoEmergencia(
                LocalDate.now(),
                "Animal com febre alta e vômitos",
                animal1,
                vet1,
                4
        );
        emergencia.setId(1);

        AtendimentoRetorno retorno = new AtendimentoRetorno(emergencia);
        retorno.setId(2);
        retorno.setDescricao("Retorno para acompanhamento pós-tratamento");

        // Adicionando à lista polimórfica
        atendimentos.add(emergencia);
        atendimentos.add(retorno);

        // Criando mais um atendimento de emergência
        AtendimentoEmergencia emergencia2 = new AtendimentoEmergencia(
                LocalDate.now().minusDays(2),
                "Queda com suspeita de fratura",
                animal2,
                vet1,
                8
        );
        emergencia2.setId(3);
        atendimentos.add(emergencia2);

        // Percorrendo a lista - POLIMORFISMO EM AÇÃO!
        for (Atendimento atendimento : atendimentos) {
            System.out.println("----------------------------------------");
            System.out.println(atendimento.exibirDados()); // Comportamento diferente para cada tipo!
            System.out.println("Tipo real: " + atendimento.getClass().getSimpleName());

            // Demonstração adicional - cada tipo tem comportamento único
            if (atendimento instanceof AtendimentoEmergencia) {
                AtendimentoEmergencia emerg = (AtendimentoEmergencia) atendimento;
                System.out.println("Nível de urgência: " + emerg.getNivelUrgencia());
            } else if (atendimento instanceof AtendimentoRetorno) {
                AtendimentoRetorno ret = (AtendimentoRetorno) atendimento;
                System.out.println("Atendimento anterior: " + ret.getAtendimentoAnterior().getData());
            }
        }

        // ============================================
        // 3. DEMONSTRAÇÃO DE POLIMORFISMO COM INTERFACES
        // ============================================

        System.out.println("\n\n3. POLIMORFISMO COM INTERFACE Registravel");
        System.out.println("============================================");

        List<Registravel> registraveis = new ArrayList<>();
        registraveis.add(tutor1);
        registraveis.add(vet1);
        registraveis.add(emergencia);
        registraveis.add(retorno);

        for (Registravel registravel : registraveis) {
            System.out.println("----------------------------------------");
            System.out.print("Registrando: ");
            registravel.registrarNoSistema(); // Comportamento diferente para cada classe!
        }

        // ============================================
        // 4. RESUMO DO POLIMORFISMO
        // ============================================

        System.out.println("\n\n4.RESUMO DA DEMONSTRAÇÃO DE POLIMORFISMO");
        System.out.println("===========================================");

        System.out.println("PESSOAS na lista: " + pessoas.size());
        System.out.println("   - Tutores: " + pessoas.stream().filter(p -> p instanceof Tutor).count());
        System.out.println("   - Veterinários: " + pessoas.stream().filter(p -> p instanceof Veterinario).count());

        System.out.println("ATENDIMENTOS na lista: " + atendimentos.size());
        System.out.println("   - Emergências: " + atendimentos.stream().filter(a -> a instanceof AtendimentoEmergencia).count());
        System.out.println("   - Retornos: " + atendimentos.stream().filter(a -> a instanceof AtendimentoRetorno).count());

        System.out.println("\nCONCLUSÃO: O polimorfismo permite tratar objetos diferentes");
        System.out.println("de maneira uniforme, enquanto cada um mantém seu comportamento específico!");


        System.out.println("=====================================================================");
        System.out.println("");
        System.out.println("=====================================================================");

                System.out.println("🏥 SISTEMA VETERINÁRIO - TESTES COMPLETOS");
                System.out.println("==========================================\n");

                // ============================================
                // 1. CRIAÇÃO DE TUTORES E VETERINÁRIOS
                // ============================================

                System.out.println("1. CRIAÇÃO DE TUTORES E VETERINÁRIOS");
                System.out.println("=======================================");

                // Criando 5 Tutores
                List<Tutor> tutores = new ArrayList<>();
                tutores.add(new Tutor("João Silva", "(11) 99999-1111", "111.222.333-44", "Rua das Flores, 123 - São Paulo"));
                tutores.add(new Tutor("Maria Santos", "(11) 98888-2222", "222.333.444-55", "Av. Paulista, 1000 - São Paulo"));
                tutores.add(new Tutor("Pedro Oliveira", "(11) 97777-3333", "333.444.555-66", "Rua Augusta, 500 - São Paulo"));
                tutores.add(new Tutor("Ana Costa", "(11) 96666-4444", "444.555.666-77", "Alameda Santos, 200 - São Paulo"));
                tutores.add(new Tutor("Carlos Lima", "(11) 95555-5555", "555.666.777-88", "Rua Oscar Freire, 800 - São Paulo"));

                // Criando 3 Veterinários
                List<Veterinario> veterinarios = new ArrayList<>();
                veterinarios.add(new Veterinario("Dra. Mariana Souza", "666.777.888-99", "CRMV-SP 12345", "Clínica Geral"));
                veterinarios.add(new Veterinario("Dr. Roberto Alves", "777.888.999-00", "CRMV-SP 54321", "Cirurgia"));
                veterinarios.add(new Veterinario("Dra. Fernanda Lima", "888.999.000-11", "CRMV-SP 67890", "Dermatologia"));

                System.out.println(" Criados " + tutores.size() + " tutores e " + veterinarios.size() + " veterinários");

                // ============================================
                // 2. CRIAÇÃO DE ANIMAIS VINCULADOS AOS TUTORES
                // ============================================

                System.out.println("\n2. 🐾 CRIAÇÃO DE ANIMAIS");
                System.out.println("========================");

                // Criando animais para cada tutor (pelo menos 2 por tutor)
                List<Animal> todosAnimais = new ArrayList<>();

                // Tutor 1 - João Silva
                Animal rex = new Animal("Rex", "Cachorro", 5, "Vacinação em dia");
                Animal luna = new Animal("Luna", "Cachorro", 3, "Castrada");
                tutores.get(0).adicionarAnimal(rex);
                tutores.get(0).adicionarAnimal(luna);
                rex.setTutor(tutores.get(0));
                luna.setTutor(tutores.get(0));
                todosAnimais.add(rex);
                todosAnimais.add(luna);

                // Tutor 2 - Maria Santos
                Animal mimi = new Animal("Mimi", "Gato", 2, "Vermifugado");
                Animal thor = new Animal("Thor", "Cachorro", 4, "Alergia alimentar");
                tutores.get(1).adicionarAnimal(mimi);
                tutores.get(1).adicionarAnimal(thor);
                mimi.setTutor(tutores.get(1));
                thor.setTutor(tutores.get(1));
                todosAnimais.add(mimi);
                todosAnimais.add(thor);

                // Tutor 3 - Pedro Oliveira
                Animal mel = new Animal("Mel", "Gato", 1, "Filhote");
                Animal bob = new Animal("Bob", "Cachorro", 7, "Artrite");
                tutores.get(2).adicionarAnimal(mel);
                tutores.get(2).adicionarAnimal(bob);
                mel.setTutor(tutores.get(2));
                bob.setTutor(tutores.get(2));
                todosAnimais.add(mel);
                todosAnimais.add(bob);

                // Tutor 4 - Ana Costa
                Animal nina = new Animal("Nina", "Cachorro", 2, "Saudável");
                Animal felix = new Animal("Felix", "Gato", 4, "Problema renal");
                tutores.get(3).adicionarAnimal(nina);
                tutores.get(3).adicionarAnimal(felix);
                nina.setTutor(tutores.get(3));
                felix.setTutor(tutores.get(3));
                todosAnimais.add(nina);
                todosAnimais.add(felix);

                // Tutor 5 - Carlos Lima
                Animal max = new Animal("Max", "Cachorro", 6, "Cardiopata");
                Animal bella = new Animal("Bella", "Gato", 3, "Obesa");
                tutores.get(4).adicionarAnimal(max);
                tutores.get(4).adicionarAnimal(bella);
                max.setTutor(tutores.get(4));
                bella.setTutor(tutores.get(4));
                todosAnimais.add(max);
                todosAnimais.add(bella);

                System.out.println(" Criados " + todosAnimais.size() + " animais vinculados aos tutores");

                // ============================================
                // 3. CRIAÇÃO DE ATENDIMENTOS
                // ============================================

                System.out.println("\n3. CRIAÇÃO DE ATENDIMENTOS");
                System.out.println("=============================");

                List<Atendimento> todosAtendimentos = new ArrayList<>();

                // Atendimentos de Emergência
                AtendimentoEmergencia emergencia1 = new AtendimentoEmergencia(
                        LocalDate.now().minusDays(2),
                        "Febre alta e vômitos",
                        rex,
                        veterinarios.get(0),
                        4
                );
                emergencia1.setId(1);
                todosAtendimentos.add(emergencia1);
                rex.adicionarAtendimento(emergencia1);

                AtendimentoEmergencia emergencia02 = new AtendimentoEmergencia(
                        LocalDate.now().minusDays(1),
                        "Queda com suspeita de fratura",
                        mimi,
                        veterinarios.get(1),
                        8
                );
                emergencia2.setId(2);
                todosAtendimentos.add(emergencia02);
                mimi.adicionarAtendimento(emergencia02);

                AtendimentoEmergencia emergencia3 = new AtendimentoEmergencia(
                        LocalDate.now(),
                        "Convulsões",
                        max,
                        veterinarios.get(2),
                        9
                );
                emergencia3.setId(3);
                todosAtendimentos.add(emergencia3);
                max.adicionarAtendimento(emergencia3);

                AtendimentoEmergencia emergencia4 = new AtendimentoEmergencia(
                        LocalDate.now().minusDays(3),
                        "Dificuldade respiratória",
                        felix,
                        veterinarios.get(0),
                        7
                );
                emergencia4.setId(4);
                todosAtendimentos.add(emergencia4);
                felix.adicionarAtendimento(emergencia4);

                // Atendimentos de Retorno
                AtendimentoRetorno retorno1 = new AtendimentoRetorno(emergencia1);
                retorno1.setId(5);
                retorno1.setDescricao("Retorno para acompanhamento pós-tratamento");
                todosAtendimentos.add(retorno1);
                rex.adicionarAtendimento(retorno1);

                AtendimentoRetorno retorno2 = new AtendimentoRetorno(emergencia2);
                retorno2.setId(6);
                retorno2.setDescricao("Retorno para avaliação da fratura");
                todosAtendimentos.add(retorno2);
                mimi.adicionarAtendimento(retorno2);

                AtendimentoRetorno retorno3 = new AtendimentoRetorno(emergencia3);
                retorno3.setId(7);
                retorno3.setDescricao("Retorno para ajuste de medicação");
                todosAtendimentos.add(retorno3);
                max.adicionarAtendimento(retorno3);

                AtendimentoRetorno retorno4 = new AtendimentoRetorno(emergencia4);
                retorno4.setId(8);
                retorno4.setDescricao("Retorno para check-up respiratório");
                todosAtendimentos.add(retorno4);
                felix.adicionarAtendimento(retorno4);

                System.out.println("✅ Criados " + todosAtendimentos.size() + " atendimentos");
                System.out.println("   - Emergências: " + todosAtendimentos.stream().filter(a -> a instanceof AtendimentoEmergencia).count());
                System.out.println("   - Retornos: " + todosAtendimentos.stream().filter(a -> a instanceof AtendimentoRetorno).count());

                // ============================================
                // 4. TESTES DOS MÉTODOS INDIVIDUAIS
                // ============================================

                System.out.println("\n4. 🔧 TESTES DOS MÉTODOS INDIVIDUAIS");
                System.out.println("===================================");

                System.out.println("\nA) 📋 MÉTODO getResumo() - TUTORES");
                System.out.println("-----------------------------------");
                for (int i = 0; i < tutores.size(); i++) {
                    System.out.println("\nTutor " + (i + 1) + ":");
                    System.out.println(tutores.get(i).getResumo());
                }

                System.out.println("\nB) 📋 MÉTODO getResumo() - VETERINÁRIOS");
                System.out.println("---------------------------------------");
                for (int i = 0; i < veterinarios.size(); i++) {
                    System.out.println("\nVeterinário " + (i + 1) + ":");
                    System.out.println(veterinarios.get(i).getResumo());
                }

                System.out.println("\nC) 📝 MÉTODO registrarNoSistema()");
                System.out.println("---------------------------------");
                System.out.println("Tutores:");
                for (Tutor tutor : tutores) {
                    tutor.registrarNoSistema();
                }

                System.out.println("\nVeterinários:");
                for (Veterinario vet : veterinarios) {
                    vet.registrarNoSistema();
                }

                System.out.println("\nAtendimentos:");
                for (Atendimento atendimento : todosAtendimentos) {
                    atendimento.registrarNoSistema();
                }

                System.out.println("\nD) 💰 MÉTODO getDescricaoPagamento() - ATENDIMENTOS PAGÁVEIS");
                System.out.println("----------------------------------------------------------");
                for (Atendimento atendimento : todosAtendimentos) {
                    if (atendimento instanceof Pagavel) {
                        Pagavel pagavel = (Pagavel) atendimento;
                        System.out.println(pagavel.getDescricaoPagamento());
                    }
                }

                // ============================================
                // 5. DEMONSTRAÇÃO DE POLIMORFISMO COM LISTAS
                // ============================================

                System.out.println("\n5. 🎯 DEMONSTRAÇÃO DE POLIMORFISMO");
                System.out.println("=================================");

                System.out.println("\nA) 📋 LISTA POLIMÓRFICA DE PESSOAS");
                System.out.println("----------------------------------");
                List<Pessoa> todasPessoas = new ArrayList<>();
                todasPessoas.addAll(tutores);
                todasPessoas.addAll(veterinarios);

                for (Pessoa pessoa : todasPessoas) {
                    System.out.println("\n" + pessoa.getClass().getSimpleName() + ":");
                    System.out.println(pessoa.getResumo()); // Polimorfismo - comportamento diferente para cada tipo
                }

                System.out.println("\nB) 🏥 LISTA POLIMÓRFICA DE ATENDIMENTOS");
                System.out.println("--------------------------------------");
                for (Atendimento atendimento : todosAtendimentos) {
                    System.out.println("\n" + atendimento.getClass().getSimpleName() + ":");

                    // Polimorfismo - método da classe base
                    if (atendimento instanceof AtendimentoEmergencia) {
                        System.out.println(((AtendimentoEmergencia) atendimento).exibirDados());
                    } else if (atendimento instanceof AtendimentoRetorno) {
                        System.out.println(((AtendimentoRetorno) atendimento).exibirDados());
                    }

                    // Polimorfismo com interface
                    if (atendimento instanceof Pagavel) {
                        System.out.println("" + ((Pagavel) atendimento).getDescricaoPagamento());
                    }
                }

                System.out.println("\nC) LISTA POLIMÓRFICA DE REGISTRÁVEIS");
                System.out.println("--------------------------------------");
                List<Registravel> todosRegistraveis = new ArrayList<>();
                todosRegistraveis.addAll(tutores);
                todosRegistraveis.addAll(veterinarios);
                todosRegistraveis.addAll(todosAtendimentos);

                for (Registravel registravel : todosRegistraveis) {
                    System.out.print("\nRegistrando " + registravel.getClass().getSimpleName() + ": ");
                    registravel.registrarNoSistema(); // Polimorfismo - comportamento único para cada classe
                }

                // ============================================
                // 6. RESUMO FINAL
                // ============================================

                System.out.println("\n6. RESUMO FINAL DO SISTEMA");
                System.out.println("============================");

                System.out.println("✅ PESSOAS NO SISTEMA: " + todasPessoas.size());
                System.out.println("   - Tutores: " + tutores.size());
                System.out.println("   - Veterinários: " + veterinarios.size());

                System.out.println("✅ ANIMAIS NO SISTEMA: " + todosAnimais.size());
                System.out.println("   - Média de " + (todosAnimais.size() / tutores.size()) + " animais por tutor");

                System.out.println("✅ ATENDIMENTOS REALIZADOS: " + todosAtendimentos.size());
                System.out.println("   - Emergências: " + todosAtendimentos.stream().filter(a -> a instanceof AtendimentoEmergencia).count());
                System.out.println("   - Retornos: " + todosAtendimentos.stream().filter(a -> a instanceof AtendimentoRetorno).count());

                System.out.println("✅ OBJETOS REGISTRÁVEIS: " + todosRegistraveis.size());

                System.out.println("\n🎯 POLIMORFISMO DEMONSTRADO COM SUCESSO!");
                System.out.println("   - Mesma interface, comportamentos diferentes");
                System.out.println("   - Flexibilidade e extensibilidade do sistema");
                System.out.println("   - Código mais limpo e mantenível");
    }
}