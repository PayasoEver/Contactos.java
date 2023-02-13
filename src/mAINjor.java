import java.util.*;

public class mAINjor {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Album> albumes = new ArrayList<Album>();

    public static void printListOrder(LinkedList<Cancion> listaReproduccion) {
        ListIterator<Cancion> it = listaReproduccion.listIterator();
        while (it.hasNext()) {
            System.out.println("Canción: " + it.next());
        }
        System.out.println("----------");
    }

    public static void Menu() {
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción de la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú");
        System.out.println("6 - Eliminar canción actual");

    }
    public static void removeSong(LinkedList<Cancion> listRe) {
        ListIterator<Cancion> tio = listRe.listIterator();

    }



    public static void main(String[] args) {
        boolean sali = true;
        int select;
        Album al1 = new Album(" Fantasy ", " I. D. ");
        Album al2 = new Album(" Lagoon ", " Vamos-san ");
        albumes.add(al1);
        albumes.add(al2);

        LinkedList<Cancion> listRep = new LinkedList<Cancion>();

        al1.addSong("Bones", 3.05);
        al1.addSong("Enemy", 3.30);
        al1.addSong("Thunder", 3.00);

        al2.addSong("Vamos", 2.20);
        al2.addSong("Listo", 1.50);
        al2.addSong("My heart", 3.05);

        System.out.println(albumes.get(0).getArtista() + albumes.get(0).getNombre());
        albumes.get(0).printSong();

        System.out.println(albumes.get(1).getArtista() + albumes.get(1).getNombre());
        albumes.get(1).printSong();

        albumes.get(0).addToPlayList("Bones", listRep);
        albumes.get(0).addToPlayList("Enemy", listRep);
        albumes.get(0).addToPlayList("Thunder", listRep);
        albumes.get(1).addToPlayList(0, listRep);
        albumes.get(1).addToPlayList(2, listRep);
        albumes.get(1).addToPlayList(1, listRep);

        System.out.println(listRep);
        ListIterator<Cancion> iterator=listRep.listIterator();

        Menu();
        try {
            while (sali) {
                System.out.println("Elige una opción");
                select = sc.nextInt();
                boolean emp = true;
                switch (select) {
                    case 0://Salir
                        System.out.println("Saliendo");
                        sali = false;
                    break;

                    case 1://Hacia adelante
                        try{
                            System.out.println("La Siguiente canción");
                            //play(listRep, select);
                            iterator.next();
                            if (iterator.hasNext()) {
                                System.out.println("Poniendo la canción " + iterator.next());

                            } else {
                                System.out.println("Esta es la última de la lista de canciones");
                            }
                            if(iterator.hasPrevious()){
                                iterator.previous();
                            }
                        }catch (NoSuchElementException e){
                            System.out.println("Esta es la última de la lista de canciones");
                        }
                    break;

                    case 2://Hacia atras
                        try{
                            System.out.println("La anterior canción");

                            if (iterator.hasPrevious()) {
                                System.out.println("Poniendo la canción " + iterator.previous());

                            } else {
                                System.out.println("Esta es la primera de la lista de canciones");
                            }
                        }catch (NoSuchElementException e){
                            System.out.println("Esta es la última de la lista de canciones");
                        }
                    break;

                    case 3://Actual
                        System.out.println("La canción actual");
                        System.out.println("La canción actual es " + iterator.next());
                        iterator.previous();
                    break;
                    case 4:
                        System.out.println("Tenemos estas canciones");
                        printListOrder(listRep);
                    break;

                    case 5:
                        Menu();
                        break;
                    case 6:
                        try {
                            System.out.println("La canción actual se va");
                            iterator.remove();
                            if (iterator.hasNext()) {
                                System.out.println("Pasando a la siguiente" + iterator.next());
                            } else if (iterator.hasPrevious()) {
                                System.out.println("Pasando a la siguiente" + iterator.next());
                            }
                            break;
                        }catch (NoSuchElementException e){
                            System.out.println();
                        }catch (IllegalStateException e){
                            System.out.println("No quedan más canciones");
                        }
                        break;

                    default:
                        System.out.println("Esta opción no existe");
                        break;
                }

            }


        } catch (InputMismatchException e){
            System.out.println("No se permiten letras, solo números");}

    }
}
