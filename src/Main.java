    public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore("A");
        arvore.inserirFilho("B");
        arvore.inserirFilho("C");
        arvore.inserirFilho("D");
        arvore.inserirFilho("E");
        arvore.inserirFilho("F");

//        arvore.contarNos(arvore.getRaiz());
//        System.out.println(" ");
//
//        arvore.contarNosSemRecursao();
//        System.out.println(" ");
//
//        arvore.percorrerPreOrdem(arvore.getRaiz());
//        System.out.println(" ");
//
//        arvore.percorrerPreOrdemSemRecursividade();
//        System.out.println(" ");
//
//        arvore.percorrerEmOrdem(arvore.getRaiz());
//        System.out.println(" ");
//
//        arvore.percorrerEmOrdemSemRecursividade();
//        System.out.println(" ");
//
//        arvore.percorrerEmPosOrdem(arvore.getRaiz());
//        System.out.println(" ");
//
//        arvore.percorrerPosOrdemSemRecursividade();

        arvore.contarNosFolhasRecursivo();
        arvore.contarNosFolhaSemRecursao(arvore.getRaiz());
    }
}