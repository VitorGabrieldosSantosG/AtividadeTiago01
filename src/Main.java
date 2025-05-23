    public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore("A");
        arvore.inserirFilho("B");
        arvore.inserirFilho("C");
        arvore.inserirFilho("D");
        arvore.inserirFilho("E");
        arvore.inserirFilho("F");

//        arvore.contarNos(arvore.getRaiz());
//        arvore.percorrerPreOrdem(arvore.getRaiz());
//        arvore.percorrerEmOrdem(arvore.getRaiz());
//        arvore.percorrerEmPosOrdem(arvore.getRaiz());
        arvore.contarNosSemRecursao(arvore.getRaiz());
    }
}