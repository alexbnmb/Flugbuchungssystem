package frontEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

import backEnd.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;


import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;


public class FlugSuchenGUI extends Application{
	
	
	//--- ERSTELLUNG UND INITIALISIERUNG BENÖTIGTER JAVAFX-ELEMNTE ---
	Stage window; 
	Scene flugSuchen, flugAuswaehlen, ticketEingabe, sitzplatzReservierungScene, warenkorbScene, orderConfirmationScene; 
	Button suchen = new Button("Suchen");
	Button zurueck = new Button("Zurück"); 
	TextField startort = new TextField(); 	
	TextField zielort = new TextField(); 
	Label labelStart = new Label("Start: "); 
	Label labelZiel = new Label("Ziel: "); 
	Label labelDatum = new Label("Datum: "); 
	DatePicker datum = new DatePicker(); 
	
	Serialisieren serialisieren = new Serialisieren(); 
	ArrayList<Flug> fluegeGesamt = new ArrayList<Flug>();
	ArrayList<Ticket> ticketsGesamt = new ArrayList<Ticket>();
	ArrayList<Kunde> kundenGesamt = new ArrayList<Kunde>();
	ArrayList<Ticket> warenkorb = new ArrayList<Ticket>();
	TableView<Flug> table = new TableView(); 
	
	TextField vorname = new TextField(); 
	Label labelVorname = new Label("Vorname: "); 
	TextField nachname = new TextField(); 
	Label labelNachname = new Label("Nachname: "); 
	DatePicker geburtsdatum = new DatePicker(); 
	Label labelGeburtsdatum = new Label("Geburtsdatum: "); 
	TextField land = new TextField(); 
	Label labelLand = new Label("Nationalität: "); 
	TextField ort = new TextField(); 
	Label labelOrt = new Label("Ort: "); 
	TextField strasse = new TextField(); 
	Label labelStrasse = new Label("Straße: "); 
	TextField hausnummer = new TextField(); 
	Label labelHausnummer = new Label("Hausnummer: "); 
	Button sitzplatzAuswaehlen = new Button("Auswählen"); 
	Label sitzplatzAnzeigen = new Label("Sitzplatz: "); 
	Label labelReservieren = new Label("Sitzplatz reservieren: "); 
	Button zurueck2 = new Button("Zurück"); 
	Text ticketAuswahl = new Text(); 
	Button inWarenkorbVerschieben = new Button("In den Warenkorb");
	
	Button[] buttonsSitzplatz = new Button[60]; 
	String[] StringZahlen = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	Label [] zahlenSitzplatz = new Label[10]; 
	
	Button sitzplatzGefunden = new Button("Auswählen"); 
	
	Button weiteresTicket = new Button("weitere Buchung");
	Button bezahlen = new Button("Bezahlen");
	
	Flug aktuellerFlug;
	long ticketcounter;
	
	boolean ersterDurchlauf = true; 
	boolean ersterDurchlaufGesamtpreis = true; 
	
	Label gesamtPreis = new Label();
	
	Label abgeschlossenText = new Label("Vielen Dank für Ihre Bestellung. \n Die Bestellbestätigung finden Sie in der Console."); 
	Button closeWindow = new Button("Fenster schließen"); 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		

		
		//Erstellen, Serialisieren und Auslesen der Flüge 
		 fluegeGesamt = serialisieren.fluegeErstellen(); 
		 serialisieren.fluegeSerialisieren(fluegeGesamt);
		 fluegeGesamt = serialisieren.fluegeAuslesen(); 
		 

		 
		window = primaryStage; 
		window.setTitle("Flugbuchungssystem");
		
		
		
	//--- ERSTELLUNG DER BENÖTIGTEN LAYOUTS + EINFÜGEN DER ELEMENTE ---
		
		GridPane grid = new GridPane(); 
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(10, 10, 10, 10));
		 
		 grid.add(labelStart, 0, 0);
		 grid.add(startort, 1, 0);
		 grid.add(labelZiel, 0, 1);
		 grid.add(zielort, 1, 1);
		 grid.add(labelDatum, 0, 2);
		 grid.add(datum, 1, 2);
		 grid.add(suchen, 2, 2);
		 
		 
		 GridPane gridTable = new GridPane(); 
		 gridTable.setHgap(10);
		 gridTable.setVgap(10);
		 gridTable.setPadding(new Insets(10, 10, 10, 10));
		 
		 
		 gridTable.add(table, 0, 0);
		 gridTable.add(zurueck, 0, 1);
		 
		 
		 GridPane gridTicketDatenEingabe = new GridPane(); 
		 gridTicketDatenEingabe.setHgap(10);
		 gridTicketDatenEingabe.setVgap(10);
		 gridTicketDatenEingabe.setPadding(new Insets(10, 10, 10, 10));
		 
		 
		 gridTicketDatenEingabe.add(labelVorname, 0, 1);
		 gridTicketDatenEingabe.add(vorname, 1, 1);
		 gridTicketDatenEingabe.add(labelNachname, 2, 1);
		 gridTicketDatenEingabe.add(nachname, 3, 1, 2, 1);
		 gridTicketDatenEingabe.add(labelGeburtsdatum, 0, 2);
		 gridTicketDatenEingabe.add(geburtsdatum, 1, 2);
		 gridTicketDatenEingabe.add(labelLand, 2, 2);
		 gridTicketDatenEingabe.add(land, 3, 2, 2, 1);
		 gridTicketDatenEingabe.add(labelOrt, 0, 3);
		 gridTicketDatenEingabe.add(ort, 1, 3);
		 gridTicketDatenEingabe.add(labelStrasse, 2, 3);
		 gridTicketDatenEingabe.add(strasse, 3, 3, 2, 1);
		 gridTicketDatenEingabe.add(labelHausnummer, 0, 4);
		 gridTicketDatenEingabe.add(hausnummer, 1, 4);
		 gridTicketDatenEingabe.add(labelReservieren, 2, 4);
		 gridTicketDatenEingabe.add(sitzplatzAuswaehlen, 3, 4);
		 gridTicketDatenEingabe.add(sitzplatzAnzeigen, 4, 4);
		 gridTicketDatenEingabe.add(zurueck2, 0, 5);
		 gridTicketDatenEingabe.add(ticketAuswahl, 0, 0, 4, 1);
		 
		 gridTicketDatenEingabe.add(inWarenkorbVerschieben, 3, 5, 2, 1);
		 ticketAuswahl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		 ticketAuswahl.setWrappingWidth(window.getWidth());
		 ticketAuswahl.setTextAlignment(TextAlignment.JUSTIFY); 
		
		 GridPane gridWarenkorb = new GridPane(); 
		 gridWarenkorb.setHgap(10);
		 gridWarenkorb.setVgap(10);
		 gridWarenkorb.setPadding(new Insets(10, 10, 10, 10));
		 
		 
		 //EventListener für Button "sitzplatzAuswaehlen"
		 sitzplatzAuswaehlen.setOnAction(e -> {
				
			 Stage sitzplatzReservierungStage = new Stage(); 
			 
			 sitzplatzReservierungStage.setScene(sitzplatzReservierungScene); 
			 sitzplatzReservierungStage.show(); 

		 });
		 
		
		
		 GridPane sitzplatzReservierung = new GridPane(); 
		 sitzplatzReservierung.setHgap(10);
		 sitzplatzReservierung.setVgap(10);
		 sitzplatzReservierung.setPadding(new Insets(10, 10, 10, 10));
		 
		 
		 BorderPane bestellungAbgeschlossen= new BorderPane();
		 HBox hbox = new HBox();
		 hbox.setPadding(new Insets(15));
		 hbox.getChildren().add(closeWindow); 
		 bestellungAbgeschlossen.setCenter(abgeschlossenText);
		 bestellungAbgeschlossen.setBottom(hbox);
		 
		 
		 //Zuordnung einer Button-ID für jeden Button der Sitzplatzreservierung 
		 for (int i = 0; i < buttonsSitzplatz.length; i++) {
			 Button button = new Button(); 			 
			 button.setId(""+i);
			 
			 
			//EventListener für Buttons der Sitzplatzreservierung 
			 button.setOnAction(e -> {
	
				 
	//---SITZPLATZAUSWAHL--- 
				 
				 	//Prüfung, ob Sitzplatz schon vergeben ist 
				 if (buttonsSitzplatz[Integer.parseInt(button.getId())] == null) {
					 sitzplatzAnzeigen.setText("Sitzplatz schon vergeben"); 
					 
					 
					 
				 } else {
				
					 //Wenn Sitzplatz noch verfügbar ist und ausgewählt wird, wird dieser daraufhin als "vergeben" gekennzeichnet 
				 if(Integer.parseInt(button.getId()) < 10) {
					 
					int reihe = Integer.parseInt(button.getId()) + 1;
					sitzplatzAnzeigen.setText("Sitzplatz: A" + reihe); 
					
					this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
					
					
				 }
				 
				 if(Integer.parseInt(button.getId()) >= 10 && Integer.parseInt(button.getId()) < 20) {
					 
						int reihe = Integer.parseInt(button.getId()) - 9;
						sitzplatzAnzeigen.setText("Sitzplatz: B" + reihe); 
						
						this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
						
					 }
				 
				 if(Integer.parseInt(button.getId()) >= 20 && Integer.parseInt(button.getId()) < 30) {
					 
						int reihe = Integer.parseInt(button.getId()) - 19;
						sitzplatzAnzeigen.setText("Sitzplatz: C" + reihe); 
						
						this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
						
					 }
				 
				 if(Integer.parseInt(button.getId()) >= 30 && Integer.parseInt(button.getId()) < 40) {
					 
						int reihe = Integer.parseInt(button.getId()) - 29;
						sitzplatzAnzeigen.setText("Sitzplatz: D" + reihe); 
						
						this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
						
					 }
				 
				 if(Integer.parseInt(button.getId()) >= 40 && Integer.parseInt(button.getId()) < 50) {
					 
						int reihe = Integer.parseInt(button.getId()) - 39;
						sitzplatzAnzeigen.setText("Sitzplatz: E" + reihe); 
						
						this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
						
					 }
				 
				 if(Integer.parseInt(button.getId()) >= 50 && Integer.parseInt(button.getId()) < 60) {
					 
						int reihe = Integer.parseInt(button.getId()) - 49;
						sitzplatzAnzeigen.setText("Sitzplatz: F" + reihe); 
						
						this.buttonsSitzplatz[Integer.parseInt(button.getId())] = null; 
						
					 }
				 
				 
					Stage closeReservierung = (Stage) button.getScene().getWindow();
					closeReservierung.close();
				 
				 }
			 });
			 
			 //Speicherung der Buttons im Array "buttonsSitzplatz"
			 buttonsSitzplatz[i] = button;
			 
		 }
		 
		//Einfügen der Buttons ins Layout "sitzplatzReservierung" 
		 for (int i = 0; i < zahlenSitzplatz.length; i++) {
			 Label label = new Label(StringZahlen[i]); 
			 zahlenSitzplatz[i] = label; 
			 
		 }
		 
		 
		 for (int x = 0; x < 7; x++) {
			 
			 for(int y = 0; y < 10; y++) {
				 
				 if (x == 3) {
					 sitzplatzReservierung.add(zahlenSitzplatz[y], x, y);
				 } else {
					 
					 if(x > 3) {
				
				 sitzplatzReservierung.add(buttonsSitzplatz[(x * 10 + y) - 10], x, y);
				 
					 } else {
						 
						 sitzplatzReservierung.add(buttonsSitzplatz[x * 10 + y], x, y);
					 }
				 }
				 
			 }
			 
			 
		 }
		 
		 
	
	//--- ERSTELLUNG DER FLUGTABELLE ---	 
		 table.setEditable(true);
		 
		 	TableColumn colFlugnummer = new TableColumn("Flugnummer");
		 	  colFlugnummer.setCellValueFactory(new PropertyValueFactory<>("Flugnummer"));
		 	  
		 	TableColumn colStartflughafen = new TableColumn("Von");
		 	colStartflughafen.setCellValueFactory(new PropertyValueFactory<>("Startflughafen"));
		 	
		 	TableColumn colZielflughafen = new TableColumn("Nach");
		 	colZielflughafen.setCellValueFactory(new PropertyValueFactory<>("Zielflughafen"));
		 	
		 	TableColumn colDatum = new TableColumn("Datum");
		 	colDatum.setCellValueFactory(new PropertyValueFactory<>("Datum"));
		 	
		 	TableColumn colBoardingzeit = new TableColumn("Boarding");
		 	colBoardingzeit.setCellValueFactory(new PropertyValueFactory<>("Boardingzeit"));
		 	
		 	TableColumn colStartzeit = new TableColumn("Abflug");
		 	colStartzeit.setCellValueFactory(new PropertyValueFactory<>("Startzeit"));
		 	
		 	TableColumn colLandezeit = new TableColumn("Ankunft");
		 	colLandezeit.setCellValueFactory(new PropertyValueFactory<>("Landezeit"));
		 	
		 	TableColumn colPreis= new TableColumn("Preis");
		 	colPreis.setCellValueFactory(new PropertyValueFactory<>("Preis"));
		 	
		 	TableColumn<Flug, Void> colBtn = new TableColumn("Buchen");

	       
	      
	        
	        
		 	
		 
		 	 table.getColumns().addAll(colFlugnummer, colStartflughafen, colZielflughafen,colDatum,colBoardingzeit, colStartzeit, colLandezeit, colPreis, colBtn);
		
		 
		
		 	 //EventListener für Button "suchen"
		 suchen.setOnAction(e -> {
			 
			 //Prüfung, ob alle Daten zur Suche eingegeben worden sind 
			 if(startort.getText() != null && !startort.getText().isEmpty()
						&& zielort.getText() != null && !zielort.getText().isEmpty()
						&& datum.getValue() != null
						){
				
				 table.getItems().clear();
				 	for (int i = 0; i < fluegeGesamt.size(); i++) {
				 		
				 		//Prüfung, ob Flüge existieren, welche den Suchdaten entsprechen 
				 			if (startort.getText().toString().equals(fluegeGesamt.get(i).startflughafen.toString()) && 
				 					zielort.getText().toString().equals(fluegeGesamt.get(i).zielflughafen.toString()) && 
				 					datum.getValue().equals(fluegeGesamt.get(i).datum)) {
 	
	//--- AUFLISTUNG ALLER ZUTREFFENDER FLÜGE IN TABELLE ---
				 				
				 				 Callback<TableColumn<Flug, Void>, TableCell<Flug, Void>> cellFactory = new Callback<TableColumn<Flug, Void>, TableCell<Flug, Void>>() {
				 		            @Override
				 		            public TableCell<Flug, Void> call(final TableColumn<Flug, Void> param) {
				 		                final TableCell<Flug, Void> cell = new TableCell<Flug, Void>() {
				 		                	
				 		                    private final Button btn = new Button("Buchen");
				 		                 

				 		                    {
				 		                    	 btn.setOnAction((ActionEvent event) -> {
				 		                            Flug data = getTableView().getItems().get(getIndex());
				 		                          
				 		                            
				 		                           ticketAuswahl.setText("Flug Nr. " + data.flugnummer + " von " + data.startflughafen + " nach " + data.zielflughafen);
				 		                           aktuellerFlug = data;
				 		                           window.setScene(ticketEingabe);
				 		                            
				 		                        });
				 		                    }

				 		                    @Override
				 		                    public void updateItem(Void item, boolean empty) {
				 		                        super.updateItem(item, empty);
				 		                        if (empty) {
				 		                            setGraphic(null);
				 		                        } else {
				 		                            setGraphic(btn);
				 		                        }
				 		                    }
				 		                };
				 		                return cell;
				 		            }
				 		        };

				 		        colBtn.setCellFactory(cellFactory);

				 				
				 				table.getItems().add(new Flug(fluegeGesamt.get(i).flugnummer, fluegeGesamt.get(i).datum, fluegeGesamt.get(i).startzeit, fluegeGesamt.get(i).landezeit, fluegeGesamt.get(i).boardingzeit, fluegeGesamt.get(i).gate, fluegeGesamt.get(i).startflughafen, fluegeGesamt.get(i).zielflughafen, fluegeGesamt.get(i).flugzeug, fluegeGesamt.get(i).preis));
				 			}
						}
				 
				 	window.setScene(flugAuswaehlen);
			 }
			 
		 });
		 
		 zurueck.setOnAction(e -> window.setScene(flugSuchen));
		 
	 	 //EventListener für Button "zurueck2"
		 zurueck2.setOnAction(e -> {
			 
			 window.setScene(flugAuswaehlen); 
			 table.refresh();
		 });
		 
		//EventListener für Button "inWarenkorbVerschieben"
		 inWarenkorbVerschieben.setOnAction(e -> {
			 
			 //Prüfung, ob alle erforderlichen Daten eingegeben worden sind 
			 if (nachname.getText() != null && vorname.getText() != null && geburtsdatum.getValue() != null && land.getText() != null 
					 && ort.getText() != null && strasse.getText() != null && hausnummer.getText() != null && sitzplatzAnzeigen.getText() != "Sitzplatz: ") {
			 
			 boolean existierenderKunde = false;
			 
			 //Prüfung, ob der Kunde bereits registriert ist + Verschiebung des Tickets in Warenkorb
			 if(kundenGesamt != null) for(int i = 0; i < kundenGesamt.size(); i++) {
				 if(kundenGesamt.get(i).getVorname() == vorname.getText() && kundenGesamt.get(i).getName() == nachname.getText()
						 && kundenGesamt.get(i).getGeburtsdatum() == geburtsdatum.getValue()
						 && kundenGesamt.get(i).getLand() == land.getText() && kundenGesamt.get(i).getOrt() == ort.getText()
						 && kundenGesamt.get(i).getStrasse() == strasse.getText() && kundenGesamt.get(i).getHausnummer() == hausnummer.getText()) {
					Ticket ticket = new Ticket(ticketcounter+1, 2, sitzplatzAnzeigen.getText(), kundenGesamt.get(i), aktuellerFlug);
					ticketcounter++;
					warenkorb.add(ticket);
					existierenderKunde = true;
					break;
				 }
			 }
			 
			 //Erstellung eines Objekts Kunde, falls dieser erstmalig ein Ticket bucht + Verschiebung des Tickets in Warenkorb
			 if(existierenderKunde == false){
				 Kunde kunde = new Kunde(nachname.getText(), vorname.getText(), geburtsdatum.getValue(), land.getText(), ort.getText(), strasse.getText(), hausnummer.getText(), 1 );
					kundenGesamt.add(kunde);
					Ticket ticket = new Ticket(ticketcounter+1, 2, sitzplatzAnzeigen.getText(), kunde, aktuellerFlug);
					ticketcounter++;
					warenkorb.add(ticket);
			 }
			 double gesamtpreis = 0;
			 
			 if (warenkorb.size() < 5) {
			
			 
				 //Einfügen der Informationen des ausgewählten Tickets in WarenkorbScene
			 for(int i = 0; i < warenkorb.size(); i++) {
				 Label strecke = new Label(warenkorb.get(i).getFlug().getStartflughafen() + " " + warenkorb.get(i).getFlug().getStartzeit() + " -> " + warenkorb.get(i).getFlug().getZielflughafen() + " " + warenkorb.get(i).getFlug().getLandezeit() + "\n");
				 Label preis = new Label(Double.toString(warenkorb.get(i).getFlug().getPreis()) + "€");
				 gridWarenkorb.add(strecke, 0, i, 3, 1);
				 gridWarenkorb.add(preis, 4, i, 1, 1);
				 gesamtpreis += warenkorb.get(i).getFlug().getPreis();
			 }
			
			 	//Prüfung, ob erstes Ticket gebucht wird (Erforderlich für Gesamtpreisermittlung und Anzeigen des Tickets) 
			 if (ersterDurchlaufGesamtpreis == true) {
			 gridWarenkorb.add(gesamtPreis, 5, 0, 1, 1);
			 ersterDurchlaufGesamtpreis = false; 
			 }
			 gesamtPreis.setText("Gesamtpreis: " + Double.toString(Math.round(gesamtpreis*100.0)/100.0) + "€");
			
			
			
			if(ersterDurchlauf == true) {
			 gridWarenkorb.add(weiteresTicket, 0, warenkorb.size()+3, 1, 1);
			 gridWarenkorb.add(bezahlen, 5, warenkorb.size()+3, 1, 1);
			 
			 ersterDurchlauf = false; 
			}
			
			 } 
			 window.setScene(warenkorbScene);
			 }
		 });
		 
		//EventListener für Button "bezahlen"
		bezahlen.setOnAction(e -> {
			ticketsGesamt.addAll(warenkorb);
			
		});
		
		//EventListener für Button "weiteresTicket"
		weiteresTicket.setOnAction(e -> {
			window.setScene(flugSuchen);
		});
		
		
		//EventListener für Button "bezahlen"
		bezahlen.setOnAction(e -> {
			
	//--- AUSGABE DER BESTELLBESTÄTIGUNG IN DER KONSOLE --- 
			System.out.println("Bestellbestätigung \n"); 
			
			System.out.println("Vorname: " + vorname.getText()); 
			System.out.println("Nachname: " + nachname.getText());
			System.out.println("Geburtsdatum: " + geburtsdatum.getValue());
			System.out.println("Nationalität: " + land.getText()); 
			System.out.println("Ort: " + ort.getText()); 
			System.out.println("Straße: " + strasse.getText()); 
			System.out.println("Hausnummer: " + hausnummer.getText()); 
			System.out.println(""); 
			
			 for(int i = 0; i < warenkorb.size(); i++) {
			
			
				System.out.println("----------------------------------------"); 
				System.out.println("Flugnummer: " + warenkorb.get(i).getFlug().getFlugnummer()); 
				System.out.println("Von: " + warenkorb.get(i).getFlug().getStartflughafen()); 
				System.out.println("Nach: " + warenkorb.get(i).getFlug().getZielflughafen()); 
				System.out.println("Datum: " + warenkorb.get(i).getFlug().getDatum()); 
				System.out.println("Boarding: " + warenkorb.get(i).getFlug().getBoardingzeit()); 
				System.out.println("Abflug: " + warenkorb.get(i).getFlug().getStartzeit()); 
				System.out.println("Ankunft: " + warenkorb.get(i).getFlug().getLandezeit()); 
				System.out.println(warenkorb.get(i).getSitzplatz()); 
				System.out.println("Preis: " + warenkorb.get(i).getFlug().getPreis() + "€"); 
				System.out.println("----------------------------------------"); 
			
			 }
			 
			 window.setScene(orderConfirmationScene);
		}); 
		
		//Programm beenden 
		closeWindow.setOnAction(e -> {
			Platform.exit();
		});		
		
		
	//--- ERSTELLUNG SÄMTLICHER SCENES --- 
		flugSuchen = new Scene(grid, 320, 123);
		flugAuswaehlen = new Scene(gridTable, 600, 300); 
		ticketEingabe = new Scene(gridTicketDatenEingabe, 600, 230); 
		sitzplatzReservierungScene = new Scene(sitzplatzReservierung, 200, 370); 
		warenkorbScene = new Scene(gridWarenkorb, 380, 170);
		orderConfirmationScene = new Scene(bestellungAbgeschlossen, 300, 200); 
		
		window.setScene(flugSuchen);
		window.show();
	}

	@Override
	public void stop(){ // Methode wird am Ende des Programmes aufgerufen. Daher hier die Serialisierung der Daten
	    if(fluegeGesamt != null) serialisieren.fluegeSerialisieren(fluegeGesamt);
	    if(ticketsGesamt != null) serialisieren.ticketsSerialisieren(ticketsGesamt);
	    if(kundenGesamt != null) serialisieren.kundenSerialisieren(kundenGesamt);
	}
}
