package harinarayan;

import java.util.ArrayList;
    

    public class Harinarayan {

    public static void main(String[] args) {
        
        Nodo e = new Nodo(34, "e", new Nodo[]{}, false);
        Nodo f = new Nodo(49, "f", new Nodo[]{}, false);
        Nodo t = new Nodo(10, "t", new Nodo[]{}, false);
        Nodo o = new Nodo(5, "o", new Nodo[]{}, false);
        Nodo ef = new Nodo(585, "ef", new Nodo[]{e, f}, false);
        Nodo et = new Nodo(286, "et", new Nodo[]{e, t}, false);
        Nodo eo = new Nodo(166, "eo", new Nodo[]{e, o}, false);
        Nodo ft = new Nodo(460, "ft", new Nodo[]{f, t}, false);
        Nodo fo = new Nodo(245, "fo", new Nodo[]{f, o}, false);
        Nodo to = new Nodo(36, "to", new Nodo[]{t, o}, false);
        Nodo eft = new Nodo(3827, "eft", new Nodo[]{ef, et, ft, e, f, t}, false);
        Nodo feo = new Nodo(2687, "feo", new Nodo[]{ef, eo, fo, e, f, o}, false);
        Nodo eto = new Nodo(791, "eto", new Nodo[]{et, eo, to, e, t, o}, false);
        Nodo fto = new Nodo(1134, "fto", new Nodo[]{ft, fo, to, f, t, o}, false);
        
        Nodo[] nodos = {eft,feo,eto,fto,ef,et,eo,ft,fo,to,e,f,t,o};
        
        for (int i = 0; i < nodos.length; i++) {
            nodos[i].npeso = 7929;
        }
        
        int ben = 0;
        int materializar = 0;
        int max = 0;
        
        String S = "efto";
        
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < nodos.length; i++) {
                if (!nodos[i].mat) {
                    ben = ben + (nodos[i].npeso - nodos[i].peso);
                    for (int j = 0; j < nodos[i].descendientes.length; j++) {
                        if(nodos[i].peso < nodos[i].descendientes[j].npeso){
                            ben = ben + (nodos[i].descendientes[j].npeso - nodos[i].peso);
                            nodos[i].cambiarh.add(j);
                        }
                    }
                    if(ben > max){
                        max = ben;
                        materializar = i;
                    }
                    System.out.println("Beneficio de materializar \"" + nodos[i].nombre +"\":");
                    System.out.println(ben);
                }
                ben = 0;
            }
            nodos[materializar].mat = true;
            for (int i = 0; i < nodos[materializar].cambiarh.size(); i++) {
                nodos[materializar].descendientes[nodos[materializar].cambiarh.get(i)].npeso = nodos[materializar].peso;
            }
            max = 0;
            System.out.println("Se eligió materializar "+ nodos[materializar].nombre);
            S = S + ", " + nodos[materializar].nombre;
            System.out.println("S = {"+S+"}");
        }
        
    }
    
}
