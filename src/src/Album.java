import java.util.*;
class Album{
    String nombre;
    String artista;
    ArrayList<Cancion> canciones = new ArrayList<>();
    public Album(String nombre,String artista){
        this.nombre=nombre;
        this.artista=artista;
    }
    public static Cancion createCancion(String titulo,double duracion){
        return new Cancion(titulo,duracion);
    }
    private int findSong(String titulo){
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitulo().equals(titulo)){
                return i;
            }
        }
        return -1;
    }
    public boolean addNewSong(String cancion,double duracion){
        if (findSong(cancion) == -1){
            canciones.add(createCancion(cancion,duracion));
            return true;
        }
        else{
            System.out.println("Esta cancion ya está añadida.");
            return false;
        }
    }
    public boolean addToPlayList (int num, LinkedList<Cancion> lista){
        ListIterator<Cancion> it = lista.listIterator();
        if (num>=0 && num< canciones.size()){
            it.add(canciones.get(num));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String titulo,LinkedList<Cancion> lista){
        ListIterator<Cancion> it = lista.listIterator();
        if (findSong(titulo) >=0 && findSong(titulo) < canciones.size()){
            it.add(canciones.get(findSong(titulo)));
            return true;
        }
        return false;
}
}