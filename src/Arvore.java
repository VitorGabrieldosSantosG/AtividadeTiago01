public class Arvore {

    private No raiz;

    public Arvore(String conteudo) {
        raiz = new No(conteudo);
    }

    public void inserirFilho(String conteudo) {

        if (raiz.getFilhoEsquerdo() == null) {
            raiz.setFilhoEsquerdo(criarFilho(conteudo));
            return;
        } else if (raiz.getFilhoDireito() == null) {
            raiz.setFilhoDireito(criarFilho(conteudo));
            return;
        }

        No atual = raiz.getFilhoEsquerdo();
        No irmaoAtual = raiz.getFilhoDireito();

        while (atual != null || irmaoAtual != null) {
            if (atual != null) {
                if (atual.getFilhoEsquerdo() == null) {
                    atual.setFilhoEsquerdo(criarFilho(conteudo));
                    return;
                } else if (atual.getFilhoDireito() == null) {
                    atual.setFilhoDireito(criarFilho(conteudo));
                    return;
                }
            }

            if (irmaoAtual != null) {
                if (irmaoAtual.getFilhoEsquerdo() == null) {
                    irmaoAtual.setFilhoEsquerdo(criarFilho(conteudo));
                    return;
                } else if (irmaoAtual.getFilhoDireito() == null) {
                    irmaoAtual.setFilhoDireito(criarFilho(conteudo));
                    return;
                }
            }

            atual = atual != null ? atual.getFilhoEsquerdo() : null;
            irmaoAtual = irmaoAtual != null ? irmaoAtual.getFilhoEsquerdo() : null;
        }
    }

    public No criarFilho(String conteudo){
        return new No(conteudo);
    }

    public void mostrarArvore() {
        mostrarArvore(raiz, 0);
    }

    private void mostrarArvore(No no, int espaco) {
        if (no == null) {
            return;
        }

        int incremento = 5;
        mostrarArvore(no.getFilhoDireito(), espaco + incremento);

        for (int i = 0; i < espaco; i++) {
            System.out.print(" ");
        }
        System.out.println(no.getConteudo());

        mostrarArvore(no.getFilhoEsquerdo(), espaco + incremento);
    }

}
