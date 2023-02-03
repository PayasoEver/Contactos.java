import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contacto{
        private String name;
        private String phoneNumber;

        public Contacto(String name, String phoneNumber){
            this.name=name;
            this.phoneNumber=phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public static Contacto  createContact(String name, String phoneNumber){
            Contacto con= new Contacto(name, phoneNumber);
             return con;
        }
    }

    class TelefonoMovil {
        private String myNumber;
        ArrayList<Contacto> myContacts;

        public TelefonoMovil(String myNumber, ArrayList<Contacto> myContacts) {
            this.myNumber = myNumber;
            this.myContacts = myContacts;
        }

        public boolean addNewContact(Contacto con) {
            if (findContact(con.getName())==-1 && findContact(con.getPhoneNumber())==-1) {
                myContacts.add(con);
                return true;
            } else {
                return false;
            }
        }

        public boolean updateContact(Contacto con, Contacto NewCon) {
            for (int j = 0; j < myContacts.size(); j++) {
                if (myContacts.get(j).equals(con)){
                myContacts.set(findContact(con), NewCon);
                return true;
                }
            }
            return false;
        }

        public boolean removeContact(Contacto con) {
            for (int j = 0; j < myContacts.size(); j++) {
                if (myContacts.get(j).getName().equalsIgnoreCase(con.getName())) {
                    myContacts.remove(con);
                    return true;
                }
            }
            return false;
        }

        private int findContact(Contacto con) {
            int index = myContacts.indexOf(con);
            if (index>=0) {
                return index;
            } else {
                return -1;
            }
        }

        private int findContact(String name) {
            for(int j=0;j<myContacts.size();j++) {
                if(myContacts.get(j).getName().equals(name))
                return j;
            }
            return -1;
        }

        public Contacto queryContacts(String name) {
            if (findContact(name)!=-1) {
                return myContacts.get(findContact(name));
            } else {
                return null;
            }
        }

        public void printContact() {
            System.out.println("Hay "+myContacts.size()+" en la lista de contactos:");
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println(i + 1 + ". " + myContacts.get(i).getName()
                        +"->"+myContacts.get(i).getPhoneNumber());
            }
        }
    }

class Main{

    private static Scanner sc= new Scanner(System.in);
    private static TelefonoMovil tel= new TelefonoMovil("",new ArrayList<>());

    public static void menu(){
        System.out.println("0 -Salir ");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar un nuevo contacto");
        System.out.println("3 - Actualizar un contacto");
        System.out.println("4 - Eliminar contacto");
        System.out.println("5 - Buscar un contacto por nombre");
        System.out.println("6 - Volver al menu");

    }

    public static void main(String[] args) {
        String name;
        String phoneNumber;
        boolean cont=true;
        int op;
        menu();

        try{

        while (cont){
            System.out.println("Elige una opción");
            op=sc.nextInt();

            switch (op){

                case 0: //Salir
                    cont=false;
                    System.out.println("Adios");

                    break;

                case 1: //Menu
                    tel.printContact();

                    break;

                case 2://Crear
                    System.out.println("Introduce un nombre:");
                    name=sc.next();
                    System.out.println("Pon tu número de teléfono");
                    phoneNumber=sc.next();
                    Contacto con = new Contacto(name, phoneNumber);

                    tel.addNewContact(con);

                    break;

                case 3://Actualizar
                    String name2;
                    String phone;

                    System.out.println("Introduce el nombre que quieras actualizar");
                    name=sc.next();
                    System.out.println(tel.queryContacts(name).getName());


                    System.out.println("Introduce el nuevo nombre");
                    name2=sc.next();
                    System.out.println("Introduce un nuevo número");
                    phone=sc.next();

                    Contacto Newcon = new Contacto(name2, phone);

                    if(tel.updateContact(tel.queryContacts(name),Newcon)){
                        System.out.println("El contacto se ha encontrado con éxito");
                    }else{
                        System.out.println("Error, este contacto no existe");
                    }
                    break;

                case 4: //Eliminar
                    System.out.println("Introduce el nombre que quieres borrar");
                    name=sc.next();
                    System.out.println(tel.queryContacts(name).getName());

                    if(tel.removeContact(tel.queryContacts(name))){
                        System.out.println("Contacto eliminado");
                    }else{
                        System.out.println("El contacto no se encuentra en la lista");
                    }

                    break;

                case 5://Buscar
                    try {


                        System.out.println("Introduce el nombre que quieres encontrar");
                        name = sc.next();
                            System.out.println("El contacto es " + tel.queryContacts(name).getName()
                                    + " y su número es " + tel.queryContacts(name).getPhoneNumber());

                        break;
                    }catch (NullPointerException n){

                        System.out.println("null");

                    }

                case 6:
                    menu();

                    break;

                default:
                    System.out.println("No se ha encontrado está opción");

                    break;


            }
        }

    }catch (InputMismatchException e){
            System.out.println("No se permiten letras, solo números");}
    }
}
