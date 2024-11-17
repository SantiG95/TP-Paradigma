package logica.Clases;

import java.io.Serializable;

public class RecursosCancha implements Serializable {
    boolean grabacion;
    boolean pelota;
    boolean pecheras;

    public RecursosCancha(){
        this.grabacion = false;
        this.pelota = false;
        this.pecheras = false;
    }

    public boolean getGrabacion() {
        return grabacion;
    }

    public void setGrabacion(boolean grabacion) {
        this.grabacion = grabacion;
    }

    public boolean getPelota() {
        return pelota;
    }

    public void setPelota(boolean pelota) {
        this.pelota = pelota;
    }

    public boolean getPecheras() {
        return pecheras;
    }

    public void setPecheras(boolean pecheras) {
        this.pecheras = pecheras;
    }
}
