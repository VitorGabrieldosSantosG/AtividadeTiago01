public class NoAVL {

    private int conteudo;
    private NoAVL filhoEsquerdo;
    private NoAVL filhoDireito;
    private int altura;

    public NoAVL(int conteudo) {
        this.conteudo = conteudo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.altura = 1;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public NoAVL getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NoAVL filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NoAVL getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NoAVL filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


}
