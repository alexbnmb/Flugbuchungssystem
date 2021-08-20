package backEnd;

import java.io.Serializable;

public class Flugzeug implements Serializable {
public String icao;
public String iata;
public int startrollstrecke;
public int landerollstrecke;
public int sitzplaetze1;
public int sitzplaetze2;
public String sitzanordnung;
public int sitzreihen;
public int sitzspalten;

public Flugzeug(String icao, String iata, int startrollstrecke, int landerollstrecke, int sitzplaetze1, int sitzplaetze2, String sitzanordnung, int sitzreihen, int sitzspalten) {
	this.icao = icao;
	this.iata = iata;
	this.startrollstrecke = startrollstrecke;
	this.landerollstrecke = landerollstrecke;
	this.sitzplaetze1 = sitzplaetze1;
	this.sitzplaetze2 = sitzplaetze2;
	this.sitzanordnung = sitzanordnung;
	this.sitzreihen = sitzreihen;
	this.sitzspalten = sitzspalten;
}

public String getIcao() {
	return icao;
}

public void setIcao(String icao) {
	this.icao = icao;
}

public String getIata() {
	return iata;
}

public void setIata(String iata) {
	this.iata = iata;
}

public int getStartrollstrecke() {
	return startrollstrecke;
}

public void setStartrollstrecke(int startrollstrecke) {
	this.startrollstrecke = startrollstrecke;
}

public int getLanderollstrecke() {
	return landerollstrecke;
}

public void setLanderollstrecke(int landerollstrecke) {
	this.landerollstrecke = landerollstrecke;
}

public int getSitzplaetze1() {
	return sitzplaetze1;
}

public void setSitzplaetze1(int sitzplaetze1) {
	this.sitzplaetze1 = sitzplaetze1;
}

public int getSitzplaetze2() {
	return sitzplaetze2;
}

public void setSitzplaetze2(int sitzplaetze2) {
	this.sitzplaetze2 = sitzplaetze2;
}

public String getSitzanordnung() {
	return sitzanordnung;
}

public void setSitzanordnung(String sitzanordnung) {
	this.sitzanordnung = sitzanordnung;
}

public int getSitzreihen() {
	return sitzreihen;
}

public void setSitzreihen(int sitzreihen) {
	this.sitzreihen = sitzreihen;
}

public int getSitzspalten() {
	return sitzspalten;
}

public void setSitzspalten(int sitzspalten) {
	this.sitzspalten = sitzspalten;
}

}
