import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree arbol = new AVLTree();

        System.out.println(" Bienvenido al Generador de Árboles AVL ");
        System.out.println("Inserta números uno por uno y verás cómo el árbol se equilibra solo.");
        System.out.println("Escribe 'exit' o '-1' para finalizar el programa.");
        System.out.println("-------------------------------------------------\n");

        while (true) {
            System.out.print("Ingresa un número: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("exit") || entrada.equals("-1")) {
                System.out.println("\nGracias por usar el generador de árboles AVL. ¡Hasta pronto!");
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                arbol.insertar(numero);
                System.out.println("\n Árbol actualizado: ");
                arbol.printTree(arbol.raiz);
                System.out.println(); // Línea en blanco
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Por favor, ingresa un número entero. ");
            }
        }

        scanner.close();
    }
}
