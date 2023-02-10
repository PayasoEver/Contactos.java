import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Linkarlista {
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        String extinto;
        LinkedList<String> animal = new LinkedList<String>();
        animal.add("Zorro");
        animal.add("Abeja");
        animal.add("Elefante");
        animal.add("Tigre");
        printList(animal);

        System.out.println("Otro animal:");
        extinto=sc.next();
        addInOrder(animal,extinto);
        printList(animal);

    }

    public static void printList(LinkedList<String> animal) {
        Iterator<String> it = animal.iterator();
            while(it.hasNext()){
                System.out.println("Se ha encontrado un:"+ it.next());
            }
        System.out.println("--------");
    }

    private static boolean addInOrder(LinkedList<String> animal, String newItem) {
        ListIterator<String> it = animal.listIterator();
        while (it.hasNext()) {
            int comparacion = it.next().compareTo(newItem);
            if (comparacion == 0) {
                //no queremos añadir porque no queremos tener duplicados
                System.out.println("el lugar " + newItem + " ya está incluido");
                return false;
            } else if (comparacion > 0) { //newItem es más pequeño
                it.previous();
                it.add(newItem);
                return true;
            }
        }
        it.add(newItem);
        return true;
    }

}