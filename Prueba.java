public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Muro muro1 = new Muro();
        EntradaTexto entrada1 = new EntradaTexto("Pepe","Te amo , mi amol");
        entrada1.addComentario("Que bonitoooo");
        muro1.addMensaje(entrada1);
        
        
        EntradaFoto entrada2 = new EntradaFoto("Pepe","C:\\Users\\F541U\\Desktop\\Nueva carpeta\\maldito.jpg","Maldito-Costa");
        entrada2.addComentario("Temazoooo");
        muro1.addFoto(entrada2);
        muro1.mostrarMuro();
    }
    
}