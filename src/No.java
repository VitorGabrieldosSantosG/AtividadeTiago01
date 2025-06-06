public class No {

    private String conteudo;
    private No filhoEsquerdo;
    private No filhoDireito;
    private int balanceamento;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.balanceamento = 0;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(Integer balanceamento) {
        this.balanceamento = balanceamento;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
}
