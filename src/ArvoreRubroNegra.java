public class ArvoreRubroNegra {

        private NoRubroNegra raiz;
        private int contador = 0;

        public ArvoreRubroNegra(int conteudo) {
            raiz = new NoRubroNegra(conteudo);
        }

        public NoRubroNegra inserirFilho(NoRubroNegra atual,int conteudo) {
            if(raiz == null){
                raiz = criarFilho(conteudo);
            }

            if(conteudo > atual.getConteudo()){
                atual.setFilhoEsquerdo(inserirFilho(atual.getFilhoEsquerdo(),conteudo));
            } else if(conteudo < atual.getConteudo()){
                atual.setFilhoDireito(inserirFilho(atual.getFilhoDireito(), conteudo));
            } else {
                System.out.println("Conteúdo já existente!!");
                return atual;
            }

            atual.setAltura( 1 + Math.max(altura(atual.getFilhoEsquerdo()), altura(atual.getFilhoDireito())));

            int balanceamento = calcularBalanceamento(atual);

            if(calcularBalanceamento(atual) > 1 && atual.getConteudo() < atual.getFilhoEsquerdo().getConteudo()){
                return rotacaoDireita(atual);
            }

            if(calcularBalanceamento(atual) < - 1 && atual.getConteudo() < atual.getFilhoDireito().getConteudo()){
                return rotacaoEsquerda(atual);
            }

            if(calcularBalanceamento(atual) > 1 && atual.getConteudo() > atual.getFilhoEsquerdo().getConteudo()){
                atual.setFilhoEsquerdo(rotacaoEsquerda(atual.getFilhoEsquerdo()));
                return rotacaoDireita(atual);

            }
            if(calcularBalanceamento(atual) < -1 && atual.getConteudo() > atual.getFilhoDireito().getConteudo()){
                atual.setFilhoDireito(rotacaoDireita(atual.getFilhoDireito()));
                return rotacaoEsquerda(atual);
            }
            return atual;
        }

        public NoRubroNegra criarFilho(int conteudo) {
            return new NoRubroNegra(conteudo);
        }

        private int altura(NoRubroNegra no) {
            return (no == null) ? 0 : no.getAltura();
        }

        //ADICIONAR EXCLUSÃO

        private int calcularBalanceamento(NoRubroNegra no) {
            return (no == null) ? 0 : altura(no.getFilhoEsquerdo()) - altura(no.getFilhoDireito());
        }

        public NoRubroNegra getRaiz() {
            return raiz;
        }

        public void percorrerPreOrdem(NoRubroNegra no){
            if (no == null) return;
            System.out.println(no.getConteudo());
            percorrerPreOrdem(no.getFilhoEsquerdo());
            percorrerPreOrdem(no.getFilhoDireito());

        }

        public NoRubroNegra buscar(int conteudo) {
            NoRubroNegra atual = raiz;

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

        private NoRubroNegra rotacaoDireita(NoRubroNegra y) {
            NoRubroNegra x = y.getFilhoEsquerdo();
            NoRubroNegra T2 = x.getFilhoDireito();

            x.setFilhoDireito(y);
            y.setFilhoEsquerdo(T2);

            y.setAltura( 1 + Math.max(altura(y.getFilhoEsquerdo()), altura(y.getFilhoDireito())));
            x.setAltura(1 + Math.max(altura(x.getFilhoEsquerdo()), altura(x.getFilhoDireito())));

            return x;
        }

        private NoRubroNegra rotacaoEsquerda(NoRubroNegra x) {
            NoRubroNegra y = x.getFilhoDireito();
            NoRubroNegra T2 = y.getFilhoEsquerdo();

            y.setFilhoEsquerdo(x);
            x.setFilhoDireito(T2);

            x.setAltura( 1 + Math.max(altura(x.getFilhoEsquerdo()), altura(x.getFilhoDireito())));
            y.setAltura(1 + Math.max(altura(y.getFilhoEsquerdo()), altura(y.getFilhoDireito())));

            return y;
        }







}
