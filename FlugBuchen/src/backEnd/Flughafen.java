package backEnd;

public class Flughafen {
public String ort;
public String name;
public String iata;
public String icao;
public String gates;
public int[] rollbahnen;

public Flughafen (String ort, String name, String iata, String icao, String gates, int[] rollbahnen){
	this.ort = ort;
	this.name = name; 
	this.iata = iata; 
	this.icao = icao; 
	this.gates = gates; 
	this.rollbahnen = rollbahnen; 
}

public String getOrt() {
	return ort;
}

public void setOrt(String ort) {
	this.ort = ort;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getIata() {
	return iata;
}

public void setIata(String iata) {
	this.iata = iata;
}

public String getIcao() {
	return icao;
}

public void setIcao(String icao) {
	this.icao = icao;
}

public String getGates() {
	return gates;
}

public void setGates(String gates) {
	this.gates = gates;
}

public int[] getRollbahnen() {
	return rollbahnen;
}

public void setRollbahnen(int[] rollbahnen) {
	this.rollbahnen = rollbahnen;
}

}
