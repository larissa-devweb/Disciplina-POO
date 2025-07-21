// SEM package
public class main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        
        Produto p1 = new Produto(1, "Notebook", 3500.00, 10);
        Produto p2 = new Produto(2, "Mouse", 50.00, 30);
        
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        
        System.out.println("\nLista de Produtos:");
        estoque.listarProdutos();
    }
}