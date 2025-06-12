public class ArvoreRubroNegra {

        private NoRubroNegra root;
        private final NoRubroNegra NIL;

        public ArvoreRubroNegra() {
            NIL = new NoRubroNegra(-1);
            NIL.color = Color.BLACK;
            NIL.left = NIL.right = NIL.parent = null;
            root = NIL;
        }

        private void leftRotate(NoRubroNegra x){
            NoRubroNegra y = x.right;
            x.right = y.left;

            if(y.left != NIL) y.left.parent = x;

            y.parent = x.parent;

            if(x.parent == null) root = y;
            else if (x == x.parent.left) x.parent.left = y;
            else x.parent.right = y;

            y.left = x;
            x.parent = y;

        }

        private void rightRotate(NoRubroNegra y){
            NoRubroNegra x = y.left;
            y.left = x.right;
            if(x.right != NIL) x.right.parent = y;

            x.parent = y.parent;

            if(y.parent == null) root = x;
            else if (y ==y.parent.right) y.parent.right =x;
            else y.parent.left = x;

            x.right = y;
            y.parent = x;

        }

        public void insert(int key){
            NoRubroNegra node = new NoRubroNegra(key);
            node.left = node.right = node.parent = null;

            NoRubroNegra y =null;
            NoRubroNegra x = root;

            while(x!= NIL){
                 y = x ;
                 if(node.key < x.key) x = x.left;
                 else x = x.right;
            }

            node.parent = y;
            if(y == null) root = node;
            else if(node.key < y.key) x =x.left;
            else y.right = node;

            node.left = NIL;
            node.right = NIL;
            node.color = Color.RED;

            insertFix(node);
        }

         private void insertFix(NoRubroNegra k){
            while(k.parent != null && k.parent.color == Color.RED){
                if(k.parent == k.parent.parent.left){
                    NoRubroNegra u = k.parent.parent.right;
                    if(u.color == Color.RED){
                        k.parent.color = Color.BLACK;
                        u.color = Color.BLACK;
                        k.parent.parent.color = Color.RED;
                        k = k.parent.parent;
                    } else {
                        if( k == k.parent.right){
                            k = k.parent;
                            leftRotate(k);
                        }
                        k.parent.color = Color.BLACK;
                        k.parent.parent.color = Color.RED;
                        rightRotate(k.parent.parent);
                    }
                }
            }
         }



}
