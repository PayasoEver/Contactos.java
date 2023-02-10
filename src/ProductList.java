import java.util.ArrayList;

public class ProductList {
    private ArrayList<String> productoList = new ArrayList<String>();

    public void addProduc(String item){
        productoList.add(item);
    }

    public void printPro(){
        System.out.println("Tener"+productoList.size()+"element al arrayList");
        for(int i =0; i<productoList.size();i++){
            System.out.println(productoList.get(i));
        }
    }

    public void modiList(int index, String newItem){
        productoList.set(index,newItem);
    }

    public void removeList(int index){
        String item= productoList.get(index);
        productoList.remove(item);
    }

    public void copiaList(){
        ArrayList<String> newArray=new ArrayList<String>(productoList);
    }

    public String BuscaIt(String searchItem){
        int index=productoList.indexOf(searchItem);
        if(index>=0){
            return productoList.get(index);
        }
        return null;
    }

    public boolean existeList(String searchItem){
        return productoList.contains(searchItem);
    }
}
