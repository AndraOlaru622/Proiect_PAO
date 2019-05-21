package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CSVWriter<T> {

    private String file;
    private String data_type;

   public CSVWriter(String file,String data_type){this.file=file; this.data_type=data_type;}

    public void write_header() throws IOException {
       if(this.data_type.equals("Client")){
        FileWriter csvWriter = new FileWriter("src/Clienti");
            csvWriter.append("Nume");
            csvWriter.append(",");
            csvWriter.append("Prenume");
            csvWriter.append(",");
            csvWriter.append("Tip Achizitie");
            csvWriter.append(",");
            csvWriter.append("Pret");
            csvWriter.append(",");
            csvWriter.append("Agent");
            csvWriter.append("\n");

           csvWriter.flush();
            csvWriter.close();
       }
       else
           if(this.data_type.equals("Vanzare")){
               FileWriter csvWriter = new FileWriter("src/Vanzari");

               csvWriter.append("Tip Achizitie");
               csvWriter.append(",");
               csvWriter.append("Nume Cumparator");
               csvWriter.append(",");
               csvWriter.append("Prenume Cumparator");
               csvWriter.append(",");
               csvWriter.append("Pret");
               csvWriter.append(",");
               csvWriter.append("Nume Agent");
               csvWriter.append(",");
               csvWriter.append("Prenume Agent");
               csvWriter.append("\n");

               csvWriter.flush();
               csvWriter.close();
           }

         else
             if(this.data_type.equals("Action_Date")){
                // System.out.println("ffff");
                 FileWriter csvWriter=new FileWriter("src/ActionDate");
                 csvWriter.append("Nume_Actiune");
                 csvWriter.append(",");
                 csvWriter.append("Timestamp");
                 csvWriter.append(",");
                 csvWriter.append("Thread_name");
                 csvWriter.append("\n");
                 csvWriter.flush();
                 csvWriter.close();
             }



    }

    public void write_data(T ob) throws IOException{

       if(this.data_type.equals("Client")){
           System.out.println(ob.getClass());
           FileWriter csvWriter = new FileWriter("src/Clienti",true);
           Client ob_client=(Client)ob;
           csvWriter.append(ob_client.getNume());
           csvWriter.append(",");
           csvWriter.append(ob_client.getPrenume());
           csvWriter.append(",");
           csvWriter.append("\n");

           csvWriter.flush();
           csvWriter.close();}
          else
       if(this.data_type.equals("Agent")){

          // System.out.println(ob.getClass());
           FileWriter csvWriter = new FileWriter("src/Agenti",true);
           Agent ob_client=(Agent) ob;
           csvWriter.append("\n");
           csvWriter.append(ob_client.getNume());
           csvWriter.append(",");
           csvWriter.append(ob_client.getPrenume());
           //csvWriter.append(",");
          // csvWriter.append(Double.toString(ob_client.getSuma_totala_vanzari()));



           csvWriter.flush();
           csvWriter.close();}
          else
              if(this.data_type.equals("Vanzare")){
                 // System.out.println("this");
                  FileWriter csvWriter = new FileWriter("src/Vanzari",true);
                  Client ob_client=(Client)ob;
                  //System.out.println(ob_client.getNume());
                  csvWriter.append(ob_client.getAc1().get_type());
                  csvWriter.append(",");
                  csvWriter.append(ob_client.getNume());
                  csvWriter.append(",");
                  csvWriter.append(ob_client.getPrenume());
                  csvWriter.append(",");
                  csvWriter.append(Double.toString(ob_client.getAc1().getPret()));
                  csvWriter.append(",");
                  csvWriter.append(ob_client.getA1().getNume());
                  csvWriter.append(",");
                  csvWriter.append(ob_client.getA1().getPrenume());
                  csvWriter.append("\n");

                  csvWriter.flush();
                  csvWriter.close();
              }
              else
                  if (this.data_type.equals("Action_Date")){
                      FileWriter csvWriter = new FileWriter(this.file,true);
                      DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                      String data = df.format(new Date());
                      csvWriter.append(ob.toString());
                      csvWriter.append(",");
                      csvWriter.append(data);
                      csvWriter.append(",");
                      csvWriter.append(Thread.currentThread().getName());
                      csvWriter.append("\n");
                      csvWriter.flush();
                      csvWriter.close();

                  }



       }

    }





