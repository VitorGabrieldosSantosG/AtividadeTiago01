public class ArvoreAVL {

    private NoAVL raiz;
    private int contador = 0;

    public ArvoreAVL(int conteudo) {
        raiz = new NoAVL(conteudo);
    }

    public void inserirFilho(int conteudo) {

        NoAVL atual = raiz.getFilhoEsquerdo();
        NoAVL aux = raiz.getFilhoDireito();

        if(calcularAltura(atual, aux) == 0){
            if(atual.getFilhoEsquerdo() == null){
                atual.setFilhoEsquerdo(criarFilho(conteudo));
            } else {
                atual.setFilhoDireito(criarFilho(conteudo));
            }
        }
        if(calcularAltura(atual, aux) == -1){
            rotacaoSimpleDireita(atual, conteudo);
        }
        if(calcularAltura(atual, aux) == 1){
            rotacaoDuplaDireitaEsquerda(atual, conteudo);
        }



    }

    public NoAVL criarFilho(int conteudo){
        return new NoAVL(conteudo);
    }

    public void rotacaoSimpleDireita(NoAVL atual, int conteudo){

        while(atual != null){
            rotacaoSimpleDireita(atual, conteudo);
            if(atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null){
                atual.setFilhoDireito(criarFilho(conteudo));
                break;
            }
            atual = atual.getFilhoDireito();
        }
    }

    public void rotacaoSimplesEsquerda(NoAVL atual, int conteudo){

        while(atual != null){
            rotacaoSimplesEsquerda(atual, conteudo);
            if(atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null){
                atual.setFilhoEsquerdo(criarFilho(conteudo));
                break;
            }
            atual = atual.getFilhoEsquerdo();
        }

    }

    public void rotacaoDuplaEsquerdaDireita(NoAVL atual, int conteudo){
        while(atual != null){
            if(atual.getFilhoEsquerdo() != null){
                rotacaoDuplaEsquerdaDireita(atual, conteudo);
                atual = atual.getFilhoEsquerdo();
            }
            if(atual.getFilhoDireito() != null){
                rotacaoDuplaEsquerdaDireita(atual, conteudo);
                atual= atual.getFilhoDireito();
            }
            atual.setFilhoDireito(criarFilho(conteudo));
        }
    }

    public void rotacaoDuplaDireitaEsquerda(NoAVL atual, int conteudo){
        while(atual != null){
            if(atual.getFilhoDireito() != null){
                rotacaoDuplaEsquerdaDireita(atual, conteudo);
                atual= atual.getFilhoDireito();
            }
            if(atual.getFilhoEsquerdo() != null){
                rotacaoDuplaEsquerdaDireita(atual, conteudo);
                atual = atual.getFilhoEsquerdo();
            }
            atual.setFilhoEsquerdo(criarFilho(conteudo));
        }
    }

    public int calcularAltura(NoAVL no1, NoAVL no2){
        return no1.getBalanceamento() - no2.getBalanceamento();
    }

    public NoAVL getRaiz() {
        return raiz;
    }
}