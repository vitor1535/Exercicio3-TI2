package exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio_3 {
    private String nome;
    private String descricao;
    private String tipo;
    
    public Produto(String nome, String descricao, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        
        Scanner leitor = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Editar produto");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Sair");
            opcao = leitor.nextInt();
            
            switch(opcao) {
            case 1:
                System.out.println("Digite o nome do produto:");
                String nome = leitor.next();
                System.out.println("Digite a descrição do produto:");
                String descricao = leitor.next();
                System.out.println("Digite o tipo do produto:");
                String tipo = leitor.next();
                Produto novoProduto = new Produto(nome, descricao, tipo);
                produtos.add(novoProduto);
                break;
            case 2:
                System.out.println("Digite o nome do produto que deseja editar:");
                String produtoEditar = leitor.next();
                for (Produto produto : produtos) {
                    if (produto.getNome().equals(produtoEditar)) {
                        System.out.println("Digite o novo nome do produto:");
                        String novoNome = leitor.next();
                        System.out.println("Digite a nova descrição do produto:");
                        String novaDescricao = leitor.next();
                        System.out.println("Digite o novo tipo do produto:");
                        String novoTipo = leitor.next();
                        produto.setNome(novoNome);
                        produto.setDescricao(novaDescricao);
                        produto.setTipo(novoTipo);
                        System.out.println("Produto editado com sucesso!");
                    }
                }
                break;
            case 3:
                System.out.println("Digite o nome do produto que deseja remover:");
                String produtoRemover = leitor.next();
                produtos.removeIf(produto -> produto.getNome().equals(produtoRemover));
                System.out.println("Produto removido com sucesso!");
                break;
            case 4:
                for (Produto produto : produtos) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Tipo: " + produto.getTipo());
                    System.out.println("------------");
                }
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
            }
        } while (opcao != 5);
        
        leitor.close();
    }

}