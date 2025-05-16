public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore("A");
        arvore.inserirFilho("B");
        arvore.inserirFilho("C");
        arvore.inserirFilho("D");
        arvore.inserirFilho("E");
        arvore.inserirFilho("F");

        System.out.println("Atenção a árvore está deitada!!");
        arvore.mostrarArvore();
    }
}