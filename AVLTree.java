public class AVLTree {
    Node raiz;

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    private Node insertar(Node nodo, int valor) {
        if (nodo == null)
            return new Node(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo;

        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        int fb = getFactorBalance(nodo);

        // LL
        if (fb > 1 && valor < nodo.izquierda.valor) {
            System.out.println(" Desbalanceo detectado en nodo " + nodo.valor + " (LL)");
            System.out.println("    Se realiza Rotación Simple a la Derecha\n");
            return rotarDerecha(nodo);
        }

        // RR
        if (fb < -1 && valor > nodo.derecha.valor) {
            System.out.println(" Desbalanceo detectado en nodo " + nodo.valor + " (RR)");
            System.out.println("    Se realiza Rotación Simple a la Izquierda\n");
            return rotarIzquierda(nodo);
        }

        // LR
        if (fb > 1 && valor > nodo.izquierda.valor) {
            System.out.println(" Desbalanceo detectado en nodo " + nodo.valor + " (LR)");
            System.out.println("    Se realiza Rotación Izquierda en hijo izquierdo (" + nodo.izquierda.valor + ")");
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            System.out.println("    Luego Rotación Derecha en nodo " + nodo.valor + "\n");
            return rotarDerecha(nodo);
        }

        // RL
        if (fb < -1 && valor < nodo.derecha.valor) {
            System.out.println(" Desbalanceo detectado en nodo " + nodo.valor + " (RL)");
            System.out.println("    Se realiza Rotación Derecha en hijo derecho (" + nodo.derecha.valor + ")");
            nodo.derecha = rotarDerecha(nodo.derecha);
            System.out.println("    Luego Rotación Izquierda en nodo " + nodo.valor + "\n");
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private int getAltura(Node nodo) {
        if (nodo == null)
            return 0;
        return nodo.altura;
    }

    private int getFactorBalance(Node nodo) {
        if (nodo == null)
            return 0;
        return getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    private Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = 1 + Math.max(getAltura(y.izquierda), getAltura(y.derecha));
        x.altura = 1 + Math.max(getAltura(x.izquierda), getAltura(x.derecha));

        return x;
    }

    private Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = 1 + Math.max(getAltura(x.izquierda), getAltura(x.derecha));
        y.altura = 1 + Math.max(getAltura(y.izquierda), getAltura(y.derecha));

        return y;
    }

    public void printTree(Node nodo) {
        printPretty(nodo, "", true);
    }

    private void printPretty(Node nodo, String prefix, boolean isTail) {
        if (nodo == null) return;

        if (nodo.derecha != null) {
            printPretty(nodo.derecha, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + nodo.valor);

        if (nodo.izquierda != null) {
            printPretty(nodo.izquierda, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
