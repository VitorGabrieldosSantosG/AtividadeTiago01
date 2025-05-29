import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {

    private No raiz;
    private int contador = 0;

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

    public void contarNosSemRecursao(){

        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            contador++;

            if (atual.getFilhoEsquerdo() != null) {
                fila.add(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                fila.add(atual.getFilhoDireito());
            }
        }

        System.out.println(contador);
    }

    public void percorrerPreOrdem(No no){
        if (no == null) return;
        System.out.println(no.getConteudo());
        percorrerPreOrdem(no.getFilhoEsquerdo());
        percorrerPreOrdem(no.getFilhoDireito());

    }

    public void percorrerPreOrdemSemRecursividade() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.getConteudo());

            if (atual.getFilhoDireito() != null) {
                pilha.push(atual.getFilhoDireito());
            }
            if (atual.getFilhoEsquerdo() != null) {
                pilha.push(atual.getFilhoEsquerdo());
            }
        }
    }

    public void percorrerEmOrdem(No no){
        if(no==null)return;
        percorrerEmOrdem(no.getFilhoEsquerdo());
        System.out.println(no.getConteudo());
        percorrerEmOrdem(no.getFilhoDireito());

    }

    public void percorrerEmOrdemSemRecursividade() {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.getFilhoEsquerdo();
            }

            atual = pilha.pop();
            System.out.println(atual.getConteudo());

            atual = atual.getFilhoDireito();
        }
    }

    public void percorrerEmPosOrdem(No no){
        if(no == null){return;}
        percorrerEmPosOrdem(no.getFilhoEsquerdo());
        percorrerEmPosOrdem(no.getFilhoDireito());
        System.out.println(no.getConteudo());
    }

    public void percorrerPosOrdemSemRecursividade() {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.getFilhoEsquerdo() != null) {
                pilha1.push(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                pilha1.push(atual.getFilhoDireito());
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop().getConteudo());
        }
    }

    public void contarNosFolhasRecursivo(){
        System.out.println(contarNosFolhasRecursivo(getRaiz()));
    }
  
    private int contarNosFolhasRecursivo(No no){
        if(no == null){return contador;}
        contarNosFolhasRecursivo(no.getFilhoEsquerdo());
        if(no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null){
            contador++;
        }
        contarNosFolhasRecursivo(no.getFilhoDireito());
        return contador;
    }

    public void contarNosFolhaSemRecursao(No no){

        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if(atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null){
                contador++;
            }

            if (atual.getFilhoEsquerdo() != null) {
                fila.add(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                fila.add(atual.getFilhoDireito());
            }
        }

        System.out.println(contador);
        
    }


    public No getRaiz() {
        return raiz;
    }
}