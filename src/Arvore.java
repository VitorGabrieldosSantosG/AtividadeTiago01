public class Arvore {

    private No raiz;

    public Arvore(String conteudo) {
        raiz = new No(conteudo);
    }

    public void inserirFilho(String conteudo){
        No atual = raiz;
        if(raiz.getFilhoEsquerdo() == null || raiz.getFilhoDireito() == null){
            raiz.setFilhoEsquerdo(criarFilho(conteudo));
        } else if (raiz.getFilhoEsquerdo() != null || raiz.getFilhoDireito() == null){
            raiz.setFilhoDireito(criarFilho(conteudo));
        }
    }

    public No criarFilho(String conteudo){
        return new No(conteudo);
    }
}
