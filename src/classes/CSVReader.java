package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader<T> {

    private String file;
    private String data_type;
    private List<T> data;


    public List<T> getData() {
        return data;
    }

    public CSVReader(String file, String data_type){
        this.file=file;
        this.data_type=data_type;
        this.data=new ArrayList<>();

    }

    public List<List<String>> read_csv(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = br. readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




       return records;
    }

    public void show_data(){
        List<List<String>> rec=read_csv();
        for(int i=0;i<rec.size();i++){
            System.out.println((rec.get(i)));
        }

    }

    public void convert_csv_to_objects(){

        List<List<String>> data=read_csv();

        if(this.data_type.equals("Agent")){
            for(int i=0;i<data.size();i++){
                Agent ag_aux=new Agent();

                ag_aux.setNume(data.get(i).get(0));
                ag_aux.setPrenume(data.get(i).get(1));
                // ag_aux.setSuma_totala_vanzari(Double.parseDouble(data.get(i).get(2)));
               // obiecte.add((T)ag_aux);
                this.data.add((T)ag_aux);
            }}

         else
             if(this.data_type.equals("Apartament")){
                 for(int i=0;i<data.size();i++){
                     Apartament ap_aux=new Apartament();

                     ap_aux.setPret(Double.parseDouble(data.get(i).get(0)));
                     ap_aux.setSuprafata(Double.parseDouble(data.get(i).get(1)));
                     ap_aux.setAdresa(data.get(i).get(2));
                     ap_aux.setNr_camere(Integer.parseInt(data.get(i).get(3)));
                     ap_aux.setEtaj(Integer.parseInt(data.get(i).get(4)));
                     ap_aux.setNumar(Integer.parseInt(data.get(i).get(5)));
                    // obiecte.add((T)ap_aux);
                     this.data.add((T)ap_aux);
                 }

            }
          else
              if(this.data_type.equals("Casa")){


                  for(int i=0;i<data.size();i++){
                      Casa casa_aux=new Casa();
                  casa_aux.setPret(Double.parseDouble(data.get(i).get(0)));
                  casa_aux.setSuprafata(Double.parseDouble(data.get(i).get(1)));
                  casa_aux.setNr_etaje(Integer.parseInt(data.get(i).get(3)));
                  casa_aux.setAdresa(data.get(i).get(2));
                  //obiecte.add((T)casa_aux);
                      this.data.add((T)casa_aux);
                  }
              }



    }

}




