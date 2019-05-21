package classes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Action_Date {
   private int ind_action;
   private String action;
   private static final List<String>actions= Arrays.asList("iesire","afisare_locuinte_disponibile", "afisare_clienti","afisare_agenti",
           "tranzactie","afisare_locuinte_vandute","afisare_locuinte_interval",
           "agenti_ordonati","modif_pret_locuinta","adaugare_locuinta","adaugare_agent");


   public Action_Date(int ind_action){
       this.ind_action=ind_action;
       action_string();
   }

   //public static String getActions(){return actions.get(10); }

    private String getAction() {
        return action;
    }

    private void action_string(){

       if(this.ind_action>=0&&this.ind_action<=10){
           action=actions.get(this.ind_action);
       }

       else {
           System.out.println("Indice indisponibil");
       }
   }

   public void write_action_date_csv() throws IOException {
       CSVWriter<String> writer_action_date=new CSVWriter<>("src/ActionDate","Action_Date");
       writer_action_date.write_data(this.getAction());


   }



}

