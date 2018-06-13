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
        arrayEmergenze.add(new Emergenza("Francesco", "Miranda", "Via Napoli, 2", "Avellino", "Incendio", "Medio", "Incendio in appartamento dopo una fuga di gas.",40.875163,14.653834));
        arrayEmergenze.add(new Emergenza("Raffaele", "Squeglia", "Via Roma, 3", "Atriplada", "Fuga di gas", "Basso", "Fuga di gas in appartamento abitato da 6 persone.",40.920085,14.83325));
        arrayEmergenze.add(new Emergenza("Anna", "Carlino", "Traversa I San Cosma, 2", "Cervinara", "Rettile", "Basso", "Presenza di un rettile all'interno di un apppartamento.",41.0221887,14.6102369));
        arrayEmergenze.add(new Emergenza("Roberta", "Bove", "Via Misericordia, 4", "Solofra", "Frana", "Alto", "Frana in prossimità dell'albergo da Roberta.",40.8325643,14.8424337));
        arrayEmergenze.add(new Emergenza("Giuseppe", "Cristillo", "Via Malta, 3", "Baiano", "Incendio boschivo", "Alto", "Incendio boschivo nei pressi di Baiano.",40.9511972,14.6196879));
        arrayEmergenze.add(new Emergenza("Antonella", "Boccia", "Via dei Due Principati, 6", "Avellino", "Incendio", "Alto", "Incendio in condominio dovuto ad una perdita di gas all'interno di un appartamento, sono presenti inquilini nell'appartamento al 3 piano",40.9071635,14.7977274));
        arrayEmergenze.add(new Emergenza("Antonio", "De Francesco", "Via Varco, 8", "Rotondi", "Neve", "", "4 persone bloccate in auto a causa della forte nevicata avvenuta poche ore fa.",41.0452326,14.6039797));
        arrayEmergenze.add(new Emergenza("Andrea", "Cristofaro", "Via Francesco Aufiero, 10", "Sturno", "Rettile", "1", "Presenza di un rettile all'interno del ristorante Miralago.",41.0172008,15.1098751));
        arrayEmergenze.add(new Emergenza("Carmine", "Mastroianni", "Via P. Iannelli, 4", "Serino", "Incendio", "3", "Incendio in appartamento, dovuto ad una sigaretta non spenta bene.",40.855432,14.865063));
        arrayEmergenze.add(new Emergenza("Angelo", "Bollito", "Via del Convento, 5", "Taurasi", "Fuga di gas", "3", "Fuga di gas dovuta ad una bombol di gas poco sicura.",41.007335,14.958112));
        arrayEmergenze.add(new Emergenza("Carmela", "Cristillo", "Via Circumvallazione, 9", "Avellino", "Perdita chiavi", "1", "Impossibilitata ad entrare in casa, perchè non più in possesso di chiavi.",40.9157175,14.7882176));
        return arrayEmergenze;
    }

}
