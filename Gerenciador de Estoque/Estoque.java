// REMOVA qualquer linha 'package' no início
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto.getNome());
    }

    // Outros métodos permanecem iguais
    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}