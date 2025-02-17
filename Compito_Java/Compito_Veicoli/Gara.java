

import java.util.ArrayList;
import java.util.Collections;

public class Gara {
    private ArrayList<Veicolo> lista;

    public Gara() {
        this.lista = new ArrayList();
    }

    public Gara(ArrayList<Veicolo> l) {
        if (l == null) {
            this.lista = new ArrayList();
        } else {
            this.lista = l;
        }

    }

    public boolean containsTarga(String targa) {
        return this.indexOf(targa) != -1;
    }

    public int indexOf(String targa) {
        for(int i = 0; i < this.lista.size(); ++i) {
            if (((Veicolo)this.lista.get(i)).getTarga().trim().equalsIgnoreCase(targa.trim())) {
                return i;
            }
        }

        return -1;
    }

    public void aggiungi(Veicolo v) {
        if (!this.containsTarga(v.getTarga())) {
            this.lista.add(v);
        }

    }

    public String toString() {
        String res = "";

        for(Veicolo vei : this.lista) {
            res = res + String.valueOf(vei) + "\n";
        }

        return res;
    }

    public void cambiaStato(String targa, int move) {
        int pos = this.indexOf(targa);
        if (pos != -1) {
            if (move < 0) {
                ((Veicolo)this.lista.get(pos)).decelera(-move);
            } else {
                ((Veicolo)this.lista.get(pos)).accelera(move);
            }

        }
    }

    public float velocityAverage() {
        float avg = 0.0F;

        for(Veicolo v : this.lista) {
            avg += (float)v.getVelocity();
        }

        return avg / (float)this.lista.size();
    }

    public int stopped() {
        int nrFermi = 0;

        for(Veicolo v : this.lista) {
            if (v.isFermo()) {
                ++nrFermi;
            }
        }

        return nrFermi;
    }

    public void graduatoria() {
        Collections.sort(this.lista);
    }

    public ArrayList<Veicolo> distanzaMin() {
        int min = 0;
        ArrayList<Veicolo> ultimi = new ArrayList();
        this.graduatoria();

        int i;
        for(i = this.lista.size() - 1; i >= 0 && (min = ((Veicolo)this.lista.get(i)).getDistanza()) == 0; --i) {
        }

        for(int j = i; j >= 0 && min == ((Veicolo)this.lista.get(j)).getDistanza(); --j) {
            ultimi.add((Veicolo)this.lista.get(j));
        }

        return ultimi;
    }

    public ArrayList<Veicolo> vincitori() {
        ArrayList<Veicolo> primi = new ArrayList();
        this.graduatoria();
        int i = 0;

        for(int max = ((Veicolo)this.lista.get(i)).getDistanza(); i < this.lista.size() - 1 && max == ((Veicolo)this.lista.get(i)).getDistanza(); ++i) {
            primi.add((Veicolo)this.lista.get(i));
        }

        return primi;
    }
}
