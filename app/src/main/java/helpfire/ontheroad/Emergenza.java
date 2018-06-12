package helpfire.ontheroad;

import java.util.ArrayList;

public class Emergenza {
    private String nomeSegnalatore, cognomeSegnalatore, indirizzoEmergenza, provincia, tipoEmergenza, gradoEmergenza, informazioniAggiuntive;
    private double latitudine, longitudine;
    public static ArrayList<Emergenza>arrayEmergenze = new ArrayList<>();

    public Emergenza(String nomeSegnalatore, String cognomeSegnalatore, String indirizzoEmergenza, String provincia, String tipoEmergenza,
                     String gradoEmergenza, String informazioniAggiuntive, double latitudine, double longitudine){
        this.nomeSegnalatore = nomeSegnalatore;
        this.cognomeSegnalatore = cognomeSegnalatore;
        this.indirizzoEmergenza = indirizzoEmergenza;
        this.provincia = provincia;
        this.tipoEmergenza = tipoEmergenza;
        this.gradoEmergenza = gradoEmergenza;
        this.informazioniAggiuntive = informazioniAggiuntive;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public Emergenza(){
        creaEmergenze();
    }

    @Override
    public String toString() {
        return "Emergenza{" +
                "nomeSegnalatore='" + nomeSegnalatore + '\'' +
                ", cognomeSegnalatore='" + cognomeSegnalatore + '\'' +
                ", indirizzoEmergenza='" + indirizzoEmergenza + '\'' +
                ", provincia='" + provincia + '\'' +
                ", tipoEmergenza='" + tipoEmergenza + '\'' +
                ", gradoEmergenza='" + gradoEmergenza + '\'' +
                ", informazioniAggiuntive='" + informazioniAggiuntive + '\'' +
                ", latitudine=" + latitudine +
                ", longitudine=" + longitudine +
                '}';
    }

    public String getNomeSegnalatore() {
        return nomeSegnalatore;
    }


    public String getCognomeSegnalatore() {
        return cognomeSegnalatore;
    }


    public String getIndirizzoEmergenza() {
        return indirizzoEmergenza;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTipoEmergenza() {
        return tipoEmergenza;
    }


    public String getGradoEmergenza() {
        return gradoEmergenza;
    }


    public String getInformazioniAggiuntive() {
        return informazioniAggiuntive;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public static ArrayList<Emergenza> creaEmergenze(){
        arrayEmergenze.add(new Emergenza("Francesco", "Miranda", "Via Napoli 2", "Avellino", "Incendio", "Medio", "Incendio in appartamento dopo una fuga di gas.",40.914388,14.7906121));
        arrayEmergenze.add(new Emergenza("Raffaele", "Squeglia", "Via Buonarroti", "Atriplada", "Fuga di gas", "Basso", "Fuga di gas in appartamento abitato da 6 persone.",40.9169098,14.8307735));
        arrayEmergenze.add(new Emergenza("Anna", "Carlino", "Via Marco Polo 4", "Cervinara", "Rettile", "Basso", "Presenza di un rettile all'interno di un apppartamento.",41.0209101,14.6208904));
        arrayEmergenze.add(new Emergenza("Roberta", "Bove", "Via Gaglione 7", "Solofra", "Frana", "Alto", "Frana in prossimità dell'albergo da Roberta.",40.832547,14.8456309));
        arrayEmergenze.add(new Emergenza("Giuseppe", "Cristillo", "Via Santa Maria", "Baiano", "Incendio boschivo", "Alto", "Incendio boschivo nei pressi di Baiano.",40.9516927,14.6190866));
        arrayEmergenze.add(new Emergenza("Antonella", "Boccia", "Via dei caduti", "Avellino", "Incendio", "Alto", "Incendio in condominio dovuto ad una perdita di gas all'interno di un appartamento, sono presenti inquilini nell'appartamento al 3 piano",40.914388,14.7906121));
        arrayEmergenze.add(new Emergenza("Antonio", "De Francesco", "Via Salerno 23", "Rotondi", "Neve", "", "4 persone bloccate in auto a causa della forte nevicata avvenuta poche ore fa.",41.0306925,14.5964761));
        arrayEmergenze.add(new Emergenza("Andrea", "Cristofaro", "Via Ponteselice 8", "Sturno", "Rettile", "1", "Presenza di un rettile all'interno del ristorante Miralago.",41.021776,15.1094593));
        arrayEmergenze.add(new Emergenza("Carmine", "Mastroianni", "Via Martinucci 2", "Serino", "Incendio", "3", "Incendio in appartamento, dovuto ad una sigaretta non spenta bene.",40.8381588,14.9038451));
        arrayEmergenze.add(new Emergenza("Angelo", "Bollito", "Via unità d'Italia 4", "Taurasi", "Fuga di gas", "3", "Fuga di gas dovuta ad una bombol di gas poco sicura.",41.0125228,14.9680914));
        arrayEmergenze.add(new Emergenza("Carmela", "Cristillo", "Via Bologna 20", "Avellino", "Perdita chiavi", "1", "Impossibilitata ad entrare in casa, perchè non più in possesso di chiavi.",40.914388,14.7906121));
        return arrayEmergenze;
    }

}
