package backEnd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import frontEnd.FlugSuchenGUI;
import javafx.scene.control.Button;



public class Serialisieren {

	public ArrayList<Flug> fluegeErstellen() {
		
		ArrayList<Flug> arrFluegeGesamt = new ArrayList<Flug>(); 
	//--- ERSTELLUNG SÄMTLICHER DATEN --- 	
		LocalDate date1  = LocalDate.of(2021, 8, 20);
		LocalDate date2  = LocalDate.of(2021, 8, 25);
		LocalDate date3  = LocalDate.of(2021, 9, 03);
		LocalDate date4  = LocalDate.of(2021, 9, 07); 
		LocalDate date5  = LocalDate.of(2021, 9, 12);
		LocalDate date6  = LocalDate.of(2021, 9, 18);
		LocalDate date7  = LocalDate.of(2021, 9, 21);
		LocalDate date8  = LocalDate.of(2021, 9, 25);
		LocalDate date9  = LocalDate.of(2021, 9, 28);
		LocalDate date10  = LocalDate.of(2021, 10, 01);
	
	//--- ERSTELLUNG SÄMTLICHER FLUGZEUGE --- 		
		Flugzeug flugzeug1 = new Flugzeug("22820923", "12180901", 3, 4, 212, 112, "geradlinig", 4, 60);
		Flugzeug flugzeug2 = new Flugzeug("92634864", "91268416", 6, 8, 423, 212, "geradlinig", 6, 40);
		Flugzeug flugzeug3 = new Flugzeug("74182438", "37328958", 4, 6, 457, 387, "geradlinig", 7, 35);
		Flugzeug flugzeug4 = new Flugzeug("91824891", "23184619", 2, 5, 157, 109, "geradlinig", 3, 45);
		
	//--- ERSTELLUNG SÄMTLICHER FLÜGE --- 	
		Flug flug1 = new Flug(24249, date1, "08:30", "16:30", "08:00", "A2", "Berlin", "New York", flugzeug1, 80.99);
		Flug flug2 = new Flug(19412, date2, "07:30", "17:40", "07:00", "B4", "München", "Kingston", flugzeug2, 134.99);
		Flug flug3 = new Flug(51241, date3, "09:15", "13:10", "08:45", "C3", "Leipzig", "London", flugzeug3, 81.99);
		Flug flug4 = new Flug(12782, date3, "09:15", "13:10", "08:45", "C3", "Leipzig", "London", flugzeug4, 84.99);
		Flug flug5 = new Flug(39922, date1, "05:15", "10:10", "04:45", "C3", "Berlin", "New York", flugzeug4, 84.99);
		Flug flug6 = new Flug(65922, date4, "06:15", "11:10", "05:45", "D3", "Berlin", "New York", flugzeug2, 74.99);
		Flug flug7 = new Flug(34929, date5, "11:45", "17:30", "11:15", "E1", "München", "Kingston", flugzeug1, 125.99); 
		Flug flug8 = new Flug(31369, date5, "10:45", "16:30", "10:15", "B1", "München", "Kingston", flugzeug2, 125.99); 
		Flug flug9 = new Flug(71243, date6, "08:15", "12:10", "07:45", "C3", "Leipzig", "London", flugzeug4, 81.99);
		Flug flug10 = new Flug(01347, date7, "06:30", "14:30", "06:00", "A2", "Berlin", "New York", flugzeug1, 80.99);
		Flug flug11 = new Flug(34928, date8, "09:15", "13:10", "08:45", "C3", "Leipzig", "London", flugzeug4, 84.99);
		Flug flug12 = new Flug(72932, date9, "05:30", "15:40", "05:00", "B4", "München", "Kingston", flugzeug1, 134.99);
		Flug flug13 = new Flug(63912, date10, "10:15", "15:10", "09:45", "C3", "Berlin", "New York", flugzeug2, 84.99);
		Flug flug14 = new Flug(34928, date6, "09:15", "13:10", "08:45", "C3", "Leipzig", "London", flugzeug4, 84.99);
		Flug flug15 = new Flug(72932, date3, "05:30", "15:40", "57:00", "B4", "München", "Kingston", flugzeug1, 134.99);
		Flug flug16 = new Flug(63912, date4, "10:15", "15:10", "09:45", "C3", "Berlin", "New York", flugzeug2, 84.99);
		
		arrFluegeGesamt.add(flug1);
		arrFluegeGesamt.add(flug2); 
		arrFluegeGesamt.add(flug3);
		arrFluegeGesamt.add(flug4); 
		arrFluegeGesamt.add(flug5); 
		arrFluegeGesamt.add(flug6); 
		arrFluegeGesamt.add(flug7);
		arrFluegeGesamt.add(flug8);
		arrFluegeGesamt.add(flug9);
		arrFluegeGesamt.add(flug10);
		arrFluegeGesamt.add(flug11);
		arrFluegeGesamt.add(flug12);
		arrFluegeGesamt.add(flug13);
		arrFluegeGesamt.add(flug14);
		arrFluegeGesamt.add(flug15);
		arrFluegeGesamt.add(flug16);
		
		return arrFluegeGesamt; 
		
	}
	
	
	//--- SERIALISIERUNG SÄMTLICHER FLÜGE --- 
	public void fluegeSerialisieren(ArrayList<Flug> arrFluege) {
		try {
			FileOutputStream fo = new FileOutputStream("Fluege.txt");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(arrFluege);
			out.close();
			
			int length = arrFluege.size(); 
			
			FileOutputStream fo2 = new FileOutputStream("ArrayFluegeLaenge.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(fo2);
			out2.writeObject(length);
			out2.close();
			
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}
	
	//--- AUSLESEN SÄMTLICHER FLÜGE ---
	public ArrayList<Flug> fluegeAuslesen () {
		try {

			FileInputStream fs2 = new FileInputStream("Fluege.txt");
			ObjectInputStream in2 = new ObjectInputStream(fs2);
			ArrayList<Flug> fluegeGesamt = (ArrayList<Flug>)in2.readObject();
			in2.close(); 
				
			
			return fluegeGesamt; 
			
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			return null; 
			
		}
	
	
	//--- SERIALISIERUNG SÄMTLICHER TICKETS ---
	public void ticketsSerialisieren(ArrayList<Ticket> arrTickets) {
		try {
			FileOutputStream fo = new FileOutputStream("Tickets.dat");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(arrTickets);
			out.close();
			
			int length = arrTickets.size(); 
			
			FileOutputStream fo2 = new FileOutputStream("ArrayTicketsLaenge.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(fo2);
			out2.writeObject(length);
			out2.close();
			
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}
	
	//--- AUSLESEN SÄMTLICHER TICKETS ---
	public ArrayList<Ticket> ticketsAuslesen () {
		try {
		
			FileInputStream fs2 = new FileInputStream("Tickets.dat");
			ObjectInputStream in2 = new ObjectInputStream(fs2);
			ArrayList<Ticket> ticketsGesamt = (ArrayList<Ticket>)in2.readObject();
			in2.close(); 
			
			return ticketsGesamt; 
			
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			return null; 
			
		}
	
	//--- SERIALISIERUNG SÄMTLICHER KUNDEN ---
	public void kundenSerialisieren(ArrayList<Kunde> arrKunden) {
		try {
			FileOutputStream fo = new FileOutputStream("Kunden.dat");
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(arrKunden);
			out.close();
			
			int length = arrKunden.size(); 
			
			FileOutputStream fo2 = new FileOutputStream("ArrayKundenLaenge.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(fo2);
			out2.writeObject(length);
			out2.close();
			
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}
	
	//--- AUSLESEN SÄMTLICHER KUNDEN ---
	public ArrayList<Kunde> kundenAuslesen () {
		try {
//			FileInputStream fs = new FileInputStream("ArrayKundenLaenge.dat");
//			ObjectInputStream in = new ObjectInputStream(fs);
//			int kundenAnzahl = (int)in.readObject();
//			in.close();
			
			
			FileInputStream fs2 = new FileInputStream("Kunden.dat");
			ObjectInputStream in2 = new ObjectInputStream(fs2);
			ArrayList<Kunde> kundenGesamt = (ArrayList<Kunde>)in2.readObject();
			in2.close(); 
				
			
			return kundenGesamt; 
			
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			return null; 
			
		}
	}
	

