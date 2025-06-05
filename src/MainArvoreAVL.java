public class MainArvoreAVL {

    public static void main(String[] args) {

        ArvoreAVL arvoreAVL = new ArvoreAVL(10);

        arvoreAVL.inserirFilho(12);
        arvoreAVL.inserirFilho(14);

        arvoreAVL.percorrerPreOrdem(arvoreAVL.getRaiz());
    }

}
