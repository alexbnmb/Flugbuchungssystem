package backEnd;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.scene.control.Button;

public class Flug implements Serializable{
public long flugnummer; 
public LocalDate datum; 
public String startzeit; 
public String landezeit; 
public String boardingzeit; 
public String gate; 
public String startflughafen;
public String zielflughafen; 
public Flugzeug flugzeug; 
public double preis; 



public Flug (long flugnummer, LocalDate datum, String startzeit, String landezeit, String boardingzeit, String gate, String startflughafen, String zielflughafen, Flugzeug flugzeug, double preis) {
	this.flugnummer = flugnummer; 
	this.datum = datum; 
	this.startzeit = startzeit; 
	this.landezeit = landezeit; 
	this.boardingzeit = boardingzeit; 
	this.gate = gate; 
	this.startflughafen = startflughafen; 
	this.zielflughafen = zielflughafen; 
	this.flugzeug = flugzeug; 
	this.preis = preis; 
	
}







public long getFlugnummer() {
	return flugnummer;
}

public void setFlugnummer(long flugnummer) {
	this.flugnummer = flugnummer;
}

public LocalDate getDatum() {
	return datum;
}

public void setDatum(LocalDate datum) {
	this.datum = datum;
}

public String getStartzeit() {
	return startzeit;
}

public void setStartzeit(String startzeit) {
	this.startzeit = startzeit;
}

public String getLandezeit() {
	return landezeit;
}

public void setLandezeit(String landezeit) {
	this.landezeit = landezeit;
}

public String getBoardingzeit() {
	return boardingzeit;
}

public void setBoardingzeit(String boardingzeit) {
	this.boardingzeit = boardingzeit;
}

public String getGate() {
	return gate;
}

public void setGate(String gate) {
	this.gate = gate;
}

public String getStartflughafen() {
	return startflughafen;
}

public void setStartflughafen(String startflughafen) {
	this.startflughafen = startflughafen;
}

public String getZielflughafen() {
	return zielflughafen;
}

public void setZielflughafen(String zielflughafen) {
	this.zielflughafen = zielflughafen;
}

public Flugzeug getFlugzeug() {
	return flugzeug;
}

public void setFlugzeug(Flugzeug flugzeug) {
	this.flugzeug = flugzeug;
}

public double getPreis() {
	return preis;
}

public void setPreis(float preis) {
	this.preis = preis;
}


}


