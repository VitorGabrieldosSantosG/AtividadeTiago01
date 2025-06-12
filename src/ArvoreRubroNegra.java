public class ArvoreRubroNegra {

        private NoRubroNegra raiz;

        public ArvoreRubroNegra(int conteudo) {
            raiz = new NoRubroNegra(conteudo);
        }

    public void inserir(int conteudo) {
        NoRubroNegra novo = new NoRubroNegra(conteudo);
        raiz = inserir(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRubroNegra inserir(NoRubroNegra atual, NoRubroNegra novo) {
        if (atual == null) return novo;

        if (novo.getConteudo() < atual.getConteudo()) {
            atual.setFilhoEsquerdo(inserir(atual.getFilhoEsquerdo(), novo));
            atual.getFilhoEsquerdo().setPai(atual);
        } else if (novo.getConteudo() > atual.getConteudo()) {
            atual.setFilhoDireito(inserir(atual.getFilhoDireito(), novo));
            atual.getFilhoDireito().setPai(atual);
        }

        return atual;
    }

    private void corrigirInsercao(NoRubroNegra no) {
        while (no != raiz && no.getPai().ehVermelho()) {
            NoRubroNegra pai = no.getPai();
            NoRubroNegra avo = pai.getPai();

            if (pai == avo.getFilhoEsquerdo()) {
                NoRubroNegra tio = avo.getFilhoDireito();

                if (tio != null && tio.verificaVermelho()) {
                    pai.setCor("preto");
                    tio.setCor("preto");
                    avo.setCor("vermelho");
                    no = avo;
                } else {
                    if (no == pai.getFilhoDireito()) {
                        no = pai;
                        rotacaoEsquerda(no);
                    }
                    pai.setCor("preto");
                    avo.setCor("vermelho");
                    rotacaoDireita(avo);
                }
            } else {
                NoRubroNegra tio = avo.getFilhoEsquerdo();

                if (tio != null && tio.verificaVermelho()) {
                    pai.setCor("preto");
                    tio.setCor("preto");
                    avo.setCor("vermelho");
                    no = avo;
                } else {
                    if (no == pai.getFilhoEsquerdo()) {
                        no = pai;
                        rotacaoDireita(no);
                    }
                    pai.setCor("preto");
                    avo.setCor("vermelho");
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.setCor("preto");
    }

    private void rotacaoEsquerda(NoRubroNegra x) {
        NoRubroNegra y = x.getFilhoDireito();
        x.setFilhoDireito(y.getFilhoEsquerdo());
        if (y.getFilhoEsquerdo() != null)
            y.getFilhoEsquerdo().setPai(x);

        y.setPai(x.getPai());

        if (x.getPai() == null)
            raiz = y;
        else if (x == x.getPai().getFilhoEsquerdo())
            x.getPai().setFilhoEsquerdo(y);
        else
            x.getPai().setFilhoDireito(y);

        y.setFilhoEsquerdo(x);
        x.setPai(y);
    }

    private void rotacaoDireita(NoRubroNegra y) {
        NoRubroNegra x = y.getFilhoEsquerdo();
        y.setFilhoEsquerdo(x.getFilhoDireito());
        if (x.getFilhoDireito() != null)
            x.getFilhoDireito().setPai(y);

        x.setPai(y.getPai());

        if (y.getPai() == null)
            raiz = x;
        else if (y == y.getPai().getFilhoEsquerdo())
            y.getPai().setFilhoEsquerdo(x);
        else
            y.getPai().setFilhoDireito(x);

        x.setFilhoDireito(y);
        y.setPai(x);
    }







}
