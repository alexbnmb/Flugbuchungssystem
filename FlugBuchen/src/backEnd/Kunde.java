package backEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Kunde implements Serializable{
private String name; 
private String vorname; 
private LocalDate geburtsdatum; 
private String land; 
private String ort; 
private String strasse; 
private String hausnummer; 
private long kundennummer; 


public Kunde (String name, String vorname, LocalDate geburtsdatum, String land, String ort, String strasse, String hausnummer, long kundennummer) {
	this.name = name; 
	this.vorname = vorname;
	this.geburtsdatum = geburtsdatum;
	this.land = land; 
	this.ort = ort; 
	this.strasse = strasse; 
	this.hausnummer = hausnummer; 
	this.kundennummer = kundennummer; 
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getVorname() {
	return vorname;
}


public void setVorname(String vorname) {
	this.vorname = vorname;
}


public LocalDate getGeburtsdatum() {
	return geburtsdatum;
}


public void setGeburtsdatum(LocalDate geburtsdatum) {
	this.geburtsdatum = geburtsdatum;
}


public String getLand() {
	return land;
}


public void setLand(String land) {
	this.land = land;
}


public String getOrt() {
	return ort;
}


public void setOrt(String ort) {
	this.ort = ort;
}


public String getStrasse() {
	return strasse;
}


public void setStrasse(String strasse) {
	this.strasse = strasse;
}


public String getHausnummer() {
	return hausnummer;
}


public void setHausnummer(String hausnummer) {
	this.hausnummer = hausnummer;
}


public long getKundennummer() {
	return kundennummer;
}


public void setKundennummer(long kundennummer) {
	this.kundennummer = kundennummer;
}






}
