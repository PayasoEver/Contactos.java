import java.util.Scanner;

public class Mainli {
    private static Scanner sc= new Scanner(System.in);
    private static ProductList productList= new ProductList();

    public static  void imprimeMenu(){
        System.out.println("0 - Para imprimir menu");
        System.out.println("1 - Para imprimir productos");
        System.out.println("2 - Para añadir");
        System.out.println("3 - Para modificar");
        System.out.println("4 - Para eliminar");
        System.out.println("5 - Para salir");
    }

    public static void addItem() {
        System.out.println("Inserta el producto: ");
        productList.addProduc(sc.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Inserta número de posición: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el nuevo producto:");
        String newItem = sc.nextLine();
        productList.modiList(index, newItem);
    }

    public static void removeItem() {
        System.out.println("Inserta número de posición: ");
        int index = sc.nextInt();
        sc.nextLine();
        productList.removeList(index);
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        imprimeMenu();

        while(continuar) {
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    imprimeMenu();
                    break;
                case 1:
                    productList.printPro();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
    }
}
