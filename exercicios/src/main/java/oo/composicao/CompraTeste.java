package oo.composicao;

public class CompraTeste {
    public static void main(String[] args) {
        Compra c1 = new Compra("João");
        c1.adicionarItem(new Item("Apple", 10, 5000.00));
        c1.adicionarItem(new Item("HDD", 20, 200.00));
        c1.adicionarItem("Mouse", 30, 100.00);

        System.out.println(c1.itens.size());
        System.out.println(c1.obterValorTotal());

        // um para um, relação bidirecional
        System.out.println(c1.itens.get(0).compra.itens.get(0).nome);
    }
}
