public class ArvoreAVL {

    private NoAVL raiz;
    private int contador = 0;

    public ArvoreAVL(int conteudo) {
        raiz = new NoAVL(conteudo);
    }

    public void inserirFilho(int conteudo) {
        if(raiz == null){
            raiz = criarFilho(conteudo);
        }

        NoAVL atual = this.raiz;

        if(conteudo > atual.getConteudo()){
            atual.setFilhoEsquerdo(criarFilho(conteudo));
        } else if(conteudo < atual.getConteudo()){
            atual.setFilhoDireito(criarFilho(conteudo));
        } else {
            System.out.println("Conteúdo já existente!!");
            return;
        }

        atual.setAltura( 1 + Math.max(altura(atual.getFilhoEsquerdo()), altura(atual.getFilhoDireito())));

        int balanceamento = calcularBalanceamento(atual);

        if(calcularBalanceamento(atual) > 1 && atual.getConteudo() < atual.getFilhoEsquerdo().getConteudo()){
            rotacaoSimpleDireita(atual);
        }

        if(calcularBalanceamento(atual) < 1 && atual.getConteudo() < atual.getFilhoDireito().getConteudo()){
            rotacaoSimplesEsquerda(atual);
        }
//
//        if(calcularBalanceamento(atual) > 1 && atual.getConteudo() > atual.getFilhoEsquerdo().getConteudo()){
//            rotacaoDuplaDireitaEsquerda(atual);
//        }
//        if(calcularBalanceamento(atual) < 1 && atual.getConteudo() > atual.getFilhoDireito().getConteudo()){
//            rotacaoDuplaEsquerdaDireita(atual);
//        }

    }

    public NoAVL criarFilho(int conteudo) {
        return new NoAVL(conteudo);
    }

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.getAltura();
    }


    public void rotacaoSimpleDireita(NoAVL atual) {
        rotacaoSimpleDireita(atual.getFilhoDireito());
        if (atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null) {
            atual.setFilhoDireito(criarFilho(atual.getConteudo()));
        }
    }

    public void rotacaoSimplesEsquerda(NoAVL atual) {

        rotacaoSimplesEsquerda(atual.getFilhoEsquerdo());
        if (atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null) {
            atual.setFilhoEsquerdo(criarFilho(atual.getConteudo()));
        }


    }

//    public void rotacaoDuplaEsquerdaDireita(NoAVL atual) {
//        if (atual.getFilhoEsquerdo() != null) {
//            rotacaoDuplaEsquerdaDireita(atual.getFilhoEsquerdo());
//        }
//        if (atual.getFilhoDireito() != null) {
//            rotacaoDuplaEsquerdaDireita(atual.getFilhoDireito());
//        }
//        atual.setFilhoDireito(criarFilho(atual.getConteudo()));
//    }
//
//
//    public void rotacaoDuplaDireitaEsquerda(NoAVL atual) {
//        if (atual.getFilhoDireito() != null) {
//            rotacaoDuplaEsquerdaDireita(atual);
//            atual = atual.getFilhoDireito();
//        }
//        if (atual.getFilhoEsquerdo() != null) {
//            rotacaoDuplaEsquerdaDireita(atual);
//            atual = atual.getFilhoEsquerdo();
//        }
//        atual.setFilhoEsquerdo(criarFilho(atual.getConteudo()));
//    }

    private int calcularBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.getFilhoEsquerdo()) - altura(no.getFilhoDireito());
    }


    public NoAVL getRaiz() {
        return raiz;
    }

    public void percorrerPreOrdem(NoAVL no){
        if (no == null) return;
        System.out.println(no.getConteudo());
        percorrerPreOrdem(no.getFilhoEsquerdo());
        percorrerPreOrdem(no.getFilhoDireito());

    }

    public NoAVL buscar(int conteudo) {
        NoAVL atual = raiz;

        while (atual != null) {
            if (conteudo == atual.getConteudo()) {
                return atual;
            } else if (conteudo < atual.getConteudo()) {
                atual = atual.getFilhoEsquerdo();
            } else {
                atual = atual.getFilhoDireito();
            }
        }

        return null;
    }

}