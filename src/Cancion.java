import java.util.*;

public class Cancion {
    private String titulo;
    private double duracion;

    public Cancion(String titulo, double duracion){
        this.duracion=duracion;
        this.titulo=titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "titulo: "+titulo +"\t"+"duración: "+ duracion;
    }
}

class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista){
        this.artista=artista;
        this.nombre=nombre;
        canciones=new ArrayList<Cancion>();
    }
    public String getNombre() {
        return nombre;
    }
    public String getArtista() {
        return artista;
    }

    public boolean addSong(String titulo, double duracion){
        if(findSong(titulo)==null){
            canciones.add(new Cancion(titulo,duracion));
            return true;
        }else {
            return false;
        }
    }

    public void printSong() {
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(i + 1 + ". " + canciones.get(i).toString());
        }
        System.out.println("--------");
    }

    private   Cancion findSong (String titulo){
        for(int i=0;i< canciones.size();i++){
            if(canciones.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addToPlayList (int numpis, LinkedList<Cancion> listaRepro){
            if(numpis<canciones.size()) {
                listaRepro.add(this.canciones.get(numpis));
                return true;
            }else
                return false;
    }

    public boolean addToPlayList(String titulo,LinkedList<Cancion> listaRepro){
        for(int j=0;j< canciones.size();j++) {
            if(findSong(titulo)!=null) {
                listaRepro.add(findSong(titulo));
                return true;
            }
        }
        return false;
    }

}


