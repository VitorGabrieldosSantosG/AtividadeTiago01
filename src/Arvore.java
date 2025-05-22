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

    public No getRaiz() {
        return raiz;
    }
}
