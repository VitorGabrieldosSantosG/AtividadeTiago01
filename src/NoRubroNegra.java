enum Color {
    RED, BLACK;
}

public class NoRubroNegra {

    int key;
    Color color;
    NoRubroNegra left,right, parent;

    public NoRubroNegra(int key) {
        this.key = key;
        this.color = Color.RED;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
