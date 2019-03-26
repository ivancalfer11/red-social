import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

public class EntradaTexto {

    private String user;
    private String mensaje;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    public EntradaTexto(String user, String mensaje) {
        this.user = user;
        this.mensaje = mensaje;
        this.cantidadMeGusta = 0;
        this.momentoPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<String>();

    }

    public void meGusta() {
        cantidadMeGusta++;
    }

    public void addComentario(String comentario) {
        comentarios.add(comentario);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getMomentoPublicacion() {

        return momentoPublicacion;
    }

    public void setMomentoPublicacion(LocalDateTime momentoPublicacion) {
        this.momentoPublicacion = momentoPublicacion;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(int cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
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

    public String toString() {
        String cadenaADevolver = "";
        cadenaADevolver += "******************\n"
                + "-" + mensaje + "-\n" + "@" + user + "\n"
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
