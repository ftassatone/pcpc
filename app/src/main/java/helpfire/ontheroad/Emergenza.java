package helpfire.ontheroad;

import android.util.Log;

import java.util.ArrayList;

public class Emergenza {
    private String nomeSegnalatore, cognomeSegnalatore, indirizzoEmergenza, provincia, tipoEmergenza, gradoEmergenza, informazioniAggiuntive;
    public ArrayList<Emergenza>arrayEmergenze = new ArrayList<>();

    public Emergenza(String nomeSegnalatore, String cognomeSegnalatore, String indirizzoEmergenza, String provincia, String tipoEmergenza,
                     String gradoEmergenza, String informazioniAggiuntive){
        nomeSegnalatore = this.nomeSegnalatore;
        cognomeSegnalatore = this.cognomeSegnalatore;
        indirizzoEmergenza = this.indirizzoEmergenza;
        provincia = this.provincia;
        tipoEmergenza = this.tipoEmergenza;
        gradoEmergenza = this.gradoEmergenza;
        informazioniAggiuntive = this.informazioniAggiuntive;
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

    public ArrayList<Emergenza> creaEmergenze(){
        Emergenza newEm = new Emergenza("Francesco", "Miranda", "Via Napoli 2", "Avellino", "Incendio", "2", "Incendio in appartamento dopo una fuga di gas.");
        Log.d("LOG", "newEm "+newEm);
        Emergenza newEm1 = new Emergenza("Raffaele", "Squeglia", "Via Buonarroti", "Atriplada", "Fuga di gas", "1", "Fuga di gas in appartamento abitato da 6 persone.");
        Emergenza newEm2 = new Emergenza("Anna", "Carlino", "Via Marco Polo 4", "Cervinara", "Rettile", "1", "Presenza di un rettile all'interno di un apppartamento.");
        Emergenza newEm3 = new Emergenza("Roberta", "Bove", "Via Gaglione 7", "Solofra", "Frana", "3", "Frana in prossimità dell'albergo da Roberta.");
        Emergenza newEm4 = new Emergenza("Giuseppe", "Cristillo", "Via Santa Maria", "Baiano", "Incendio boschivo", "3", "Incendio boschivo nei pressi di Baiano.");
        Emergenza newEm5 = new Emergenza("Antonella", "Boccia", "Via dei caduti", "Avellino", "Incendio", "3", "Incendio in condominio dovuto ad una perdita di gas all'interno di un appartamento, sono presenti inquilini nell'appartamento al 3 piano");
        Emergenza newEm6 = new Emergenza("Antonio", "De Francesco", "Via Salerno 23", "Rotondi", "Neve", "2", "4 persone bloccate in auto a causa della forte nevicata avvenuta poche ore fa.");
        Emergenza newEm7 = new Emergenza("Andrea", "Cristofaro", "Via Ponteselice 8", "Sturnp", "Rettile", "1", "Presenza di un rettile all'interno del ristorante Miralago.");
        Emergenza newEm8 = new Emergenza("Carmine", "Mastroianni", "Via Martinucci 2", "Serino", "Incendio", "3", "Incendio in appartamento, dovuto ad una sigaretta non spenta bene.");
        Emergenza newEm9 = new Emergenza("Angelo", "Bollito", "Via unità d'Italia 4", "Taurasi", "Fuga di gas", "3", "Fuga di gas dovuta ad una bombol di gas poco sicura.");
        Emergenza newEm10 = new Emergenza("Carmela", "Cristillo", "Via Bologna 20", "Avellino", "Perdita chiavi", "1", "Impossibilitata ad entrare in casa, perchè non più in possesso di chiavi.");

        arrayEmergenze.add(newEm);
        arrayEmergenze.add(newEm1);
        arrayEmergenze.add(newEm2);
        arrayEmergenze.add(newEm3);
        arrayEmergenze.add(newEm4);
        arrayEmergenze.add(newEm5);
        arrayEmergenze.add(newEm6);
        arrayEmergenze.add(newEm7);
        arrayEmergenze.add(newEm8);
        arrayEmergenze.add(newEm9);
        arrayEmergenze.add(newEm10);
        Log.d("LOG", arrayEmergenze.toString());
        return arrayEmergenze;
    }

}
