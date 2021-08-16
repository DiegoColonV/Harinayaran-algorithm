package harinarayan;

import java.util.ArrayList;


public class Nodo {
    
    public int peso;
    public String nombre;
    public Nodo[] descendientes;
    public int npeso;
    public boolean mat;
    public ArrayList<Integer> cambiarh = new ArrayList<>();

    public Nodo(int peso, String nombre, Nodo[] descendientes, boolean mat) {
        this.peso = peso;
        this.nombre = nombre;
        this.descendientes = descendientes;
        this.mat = mat;
    }  
    
}
