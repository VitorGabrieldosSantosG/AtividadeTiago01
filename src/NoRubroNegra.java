public class NoRubroNegra {

    private int conteudo;
    private NoRubroNegra filhoEsquerdo;
    private NoRubroNegra filhoDireito;
    private NoRubroNegra pai;
    private String cor; // "vermelho" ou "preto"

    public NoRubroNegra(int conteudo) {
        this.conteudo = conteudo;
        this.cor = "vermelho";
    }

    // Getters e setters
    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public NoRubroNegra getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NoRubroNegra filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NoRubroNegra getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NoRubroNegra filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean verificaVermelho() {
        return "vermelho".equals(this.cor);
    }

    public boolean verificaPreto() {
        return "preto".equals(this.cor);
    }

    public NoRubroNegra getPai() {
        return pai;
    }

    public void setPai(NoRubroNegra pai) {
        this.pai = pai;
    }


}
