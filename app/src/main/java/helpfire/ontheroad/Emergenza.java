package helpfire.ontheroad;

import java.util.ArrayList;

public class Emergenza {
    private String nomeSegnalatore, cognomeSegnalatore, indirizzoEmergenza, provincia, tipoEmergenza, gradoEmergenza, informazioniAggiuntive;
    public static ArrayList<Emergenza>arrayEmergenze = new ArrayList<>();

    public Emergenza(String nomeSegnalatore, String cognomeSegnalatore, String indirizzoEmergenza, String provincia, String tipoEmergenza,
                     String gradoEmergenza, String informazioniAggiuntive){
        this.nomeSegnalatore = nomeSegnalatore;
        this.cognomeSegnalatore = cognomeSegnalatore;
        this.indirizzoEmergenza = indirizzoEmergenza;
        this.provincia = provincia;
        this.tipoEmergenza = tipoEmergenza;
        this.gradoEmergenza = gradoEmergenza;
        this.informazioniAggiuntive = informazioniAggiuntive;
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


    public static ArrayList<Emergenza> creaEmergenze(){
        arrayEmergenze.add(new Emergenza("Francesco", "Miranda", "Via Napoli 2", "Avellino", "Incendio", "Medio", "Incendio in appartamento dopo una fuga di gas."));
        arrayEmergenze.add(new Emergenza("Raffaele", "Squeglia", "Via Buonarroti", "Atriplada", "Fuga di gas", "Basso", "Fuga di gas in appartamento abitato da 6 persone."));
        arrayEmergenze.add(new Emergenza("Anna", "Carlino", "Via Marco Polo 4", "Cervinara", "Rettile", "Basso", "Presenza di un rettile all'interno di un apppartamento."));
        arrayEmergenze.add(new Emergenza("Roberta", "Bove", "Via Gaglione 7", "Solofra", "Frana", "Alto", "Frana in prossimità dell'albergo da Roberta."));
        arrayEmergenze.add(new Emergenza("Giuseppe", "Cristillo", "Via Santa Maria", "Baiano", "Incendio boschivo", "Alto", "Incendio boschivo nei pressi di Baiano."));
        arrayEmergenze.add(new Emergenza("Antonella", "Boccia", "Via dei caduti", "Avellino", "Incendio", "Alto", "Incendio in condominio dovuto ad una perdita di gas all'interno di un appartamento, sono presenti inquilini nell'appartamento al 3 piano"));
        arrayEmergenze.add(new Emergenza("Antonio", "De Francesco", "Via Salerno 23", "Rotondi", "Neve", "Medio", "4 persone bloccate in auto a causa della forte nevicata avvenuta poche ore fa."));
        arrayEmergenze.add(new Emergenza("Andrea", "Cristofaro", "Via Ponteselice 8", "Sturno", "Rettile", "Basso", "Presenza di un rettile all'interno del ristorante Miralago."));
        arrayEmergenze.add(new Emergenza("Carmine", "Mastroianni", "Via Martinucci 2", "Serino", "Incendio", "Alto", "Incendio in appartamento, dovuto ad una sigaretta non spenta bene."));
        arrayEmergenze.add(new Emergenza("Angelo", "Bollito", "Via unità d'Italia 4", "Taurasi", "Fuga di gas", "Medio", "Fuga di gas dovuta ad una bombol di gas poco sicura."));
        arrayEmergenze.add(new Emergenza("Carmela", "Cristillo", "Via Bologna 20", "Avellino", "Perdita chiavi", "Basso", "Impossibilitata ad entrare in casa, perchè non più in possesso di chiavi."));
        return arrayEmergenze;
    }

}
