import java.util.LinkedList;
import java.util.Queue;

public class Arvore {

    private No raiz;

    public Arvore(String conteudo) {
        raiz = new No(conteudo);
    }

    public void inserirFilho(String conteudo) {
        No novoNo = criarFilho(conteudo);

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual.getFilhoEsquerdo() == null) {
                atual.setFilhoEsquerdo(novoNo);
                return;
            } else {
                fila.add(atual.getFilhoEsquerdo());
            }

            if (atual.getFilhoDireito() == null) {
                atual.setFilhoDireito(novoNo);
                return;
            } else {
                fila.add(atual.getFilhoDireito());
            }
        }
    }

    public No criarFilho(String conteudo){
        return new No(conteudo);
    }

    public int contarNos(No no){
        if (no == null) return 0;
        return 1 + contarNos(no.getFilhoEsquerdo()) + contarNos(no.getFilhoDireito());
    }

//    public void contarNosSemRecursao(No no){
//        int contador= 1;
//        No atual = no;
//        Queue<No> fila = new LinkedList<>();
//        fila.add(no);
//        while(atual.getFilhoEsquerdo() !=  null && atual.getFilhoDireito() != null){
//
//            if(atual.getFilhoEsquerdo() != null){
//                contador++;
//                fila.add(atual);
//                atual = atual.getFilhoEsquerdo();
//            } else if(atual.getFilhoDireito() != null){
//                contador++;
//                fila.add(atual);
//                atual =atual.getFilhoDireito();
//            }
//
//            if(atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null){
//                fila.remove();
//                atual = fila.poll();
//            }
//
//        }
//        System.out.println(contador);
//    }

    public void percorrerPreOrdem(No no){
        if (no == null) return;
        System.out.println(no.getConteudo() + " ");
        percorrerPreOrdem(no.getFilhoEsquerdo());
        percorrerPreOrdem(no.getFilhoDireito());

    }

    public void percorrerEmOrdem(No no){
        if(no==null)return;
        percorrerEmOrdem(no.getFilhoEsquerdo());
        System.out.println(no.getConteudo() + " ");
        percorrerEmOrdem(no.getFilhoDireito());

    }

    public void percorrerEmPosOrdem(No no){
        if(no == null){return;}
        percorrerEmPosOrdem(no.getFilhoEsquerdo());
        percorrerEmPosOrdem(no.getFilhoDireito());
        System.out.println(no.getConteudo());
    }

    public No getRaiz() {
        return raiz;
    }
}
