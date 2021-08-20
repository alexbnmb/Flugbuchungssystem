package backEnd;

import java.io.Serializable;

public class Ticket implements Serializable{
private long ticketnummer;
private int klasse;
private String sitzplatz;
private Kunde kunde;
private Flug flug;

public Ticket (long ticketnummer, int klasse, String sitzplatz, Kunde kunde, Flug flug) {
	this.ticketnummer = ticketnummer; 
	this.klasse = klasse; 
	this.sitzplatz = sitzplatz;
	this.kunde = kunde;
	this.flug = flug;
}

public long getTicketnummer() {
	return ticketnummer;
}

public void setTicketnummer(long ticketnummer) {
	this.ticketnummer = ticketnummer;
}

public int getKlasse() {
	return klasse;
}

public void setKlasse(int klasse) {
	this.klasse = klasse;
}

public String getSitzplatz() {
	return sitzplatz;
}

public void setSitzplatz(String sitzplatz) {
	this.sitzplatz = sitzplatz;
}

public Kunde getKunde() {
	return kunde;
}

public void setKunde(Kunde kunde) {
	this.kunde = kunde;
}

public Flug getFlug() {
	return flug;
}

public void setFlug(Flug flug) {
	this.flug = flug;
}

}
