
 

import java.util.ArrayList;

public class Muro {
    
    private ArrayList<EntradaTexto>mensajes;
    private ArrayList<EntradaFoto> fotos;
    
    public Muro(){
       this.mensajes=new ArrayList<EntradaTexto>(); 
       this.fotos=new ArrayList<EntradaFoto>(); 
    }
    
    public void addFoto(EntradaFoto foto){
        fotos.add(foto);
    }
    
    public void addMensaje(EntradaTexto mensaje){
        mensajes.add(mensaje);
    }
    
    public void mostrarMuro(){
        for(EntradaTexto mensaje: mensajes){
           System.out.println( mensaje.toString());
        }
        for (EntradaFoto foto :fotos){
            System.out.println(foto.toString());
        }
    }
    
}
