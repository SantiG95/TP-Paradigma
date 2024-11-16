package Clases;

public class RecursosCancha {
    boolean Grabacion;
    boolean Pelota;
    boolean Pecheras;

    public RecursosCancha(){
        this.Grabacion = false;
        this.Pelota = false;
        this.Pecheras = false;
    }

    public boolean getGrabacion() {
        return Grabacion;
    }

    public void setGrabacion(boolean grabacion) {
        Grabacion = grabacion;
    }

    public boolean getPelota() {
        return Pelota;
    }

    public void setPelota(boolean pelota) {
        Pelota = pelota;
    }

    public boolean getPecheras() {
        return Pecheras;
    }

    public void setPecheras(boolean pecheras) {
        Pecheras = pecheras;
    }
}
