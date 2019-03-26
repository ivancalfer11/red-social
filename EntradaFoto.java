import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntradaFoto {
    private String user;
    private String urlImagen;
    private String titulo;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String>comentarios;
    
    
    public EntradaFoto(String user, String urlImagen,String titulo){
        this.user=user;
        this.urlImagen=urlImagen;
        this.titulo=titulo;
        this.momentoPublicacion=LocalDateTime.now();
        this.cantidadMeGusta=0;
        this.comentarios= new ArrayList<String>();
    }
    public void meGusta(){
        cantidadMeGusta++;
    }
     public String getTiempoTranscurrido() {
        String tiempo = "";
        LocalDateTime tiempoTranscurrido = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        int segundosPubli = momentoPublicacion.getSecond();
        int segundosActual = tiempoTranscurrido.getSecond();
        int minutosPubli = momentoPublicacion.getMinute();
        int minutosActual = tiempoTranscurrido.getMinute();
        int horasPubli = momentoPublicacion.getHour();
        int horasActual = tiempoTranscurrido.getHour();
        int diasPubli = momentoPublicacion.getDayOfMonth();
        int diasActual = tiempoTranscurrido.getDayOfMonth();
        int mesesPubli = momentoPublicacion.getMonthValue();
        int mesesActual = tiempoTranscurrido.getMonthValue();
        int anosPubli = momentoPublicacion.getYear();
        int anosActual = tiempoTranscurrido.getYear();

        LocalDateTime restarFecha = tiempoTranscurrido.minusYears(2019).minusMonths(3).minusDays(25);
        LocalDateTime restarHorario = restarFecha.minusHours(horasPubli).minusMinutes(minutosPubli).minusSeconds(segundosPubli);

        if (restarHorario.getSecond() > 0) {
            tiempo = "Hace " + restarHorario.getSecond() + " segundos";
         
            if (restarHorario.getMinute() > 0) {
                tiempo = "Hace " + restarHorario.getMinute() + " minutos";
            
                if (restarHorario.getHour() > 0) {
                    tiempo = "Hace " + restarHorario.getHour() + " horas";
                 
                    if (restarHorario.getDayOfMonth() > 0) {
                        tiempo = "Hace " + restarHorario.getDayOfMonth() + " dias";
                     
                        if (restarHorario.getMonthValue() > 0) {
                            tiempo = "Hace " + restarHorario.getMonthValue() + " meses";
                         
                            if (restarHorario.getYear() > 0) {
                                tiempo = "Hace " + restarHorario.getYear() + " años";
                            }
                        }
                    }
                }
            }
        
        }
        return tiempo;
    }
    public String getUrl(){
        return urlImagen;
    }
    public String getTituloImagen(){
        return titulo;
    }
    
    public LocalDateTime getMomentoPublicacion(){
        return momentoPublicacion;
    }
    
    public void addComentario(String mensaje){
        comentarios.add(mensaje);
    }
    
    public String toString() {
        String cadenaADevolver = "";
        cadenaADevolver += "******************\n"
                + "-" + urlImagen + "-\n" + "@" + user + "\n"+ titulo + "\n"
                + getTiempoTranscurrido()+"\n"+ cantidadMeGusta + " me gusta\n";
                
        if (comentarios.isEmpty()){
            cadenaADevolver+= "Esta entrada no tiene comentarios.";
        }else{
            for(String comentario : comentarios){
                cadenaADevolver+= "---"+comentario + "\n";
            }
        }

        return cadenaADevolver;

    }
    
    
    
}
