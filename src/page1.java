

import classes.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("Duplicates")
class page1 extends JFrame {


    static JFrame f_home;
    static JFrame f_afisare;
    static JFrame f_modificari;
    static JFrame f_vanzare;
    static JFrame f_agenti;
    static JFrame f_locuinte;
    static JFrame f_clienti;
    static JFrame f_add_agent;
    static JFrame f_add_locuinta;
    static JFrame f_add_casa;
    static JFrame f_add_apartament;



    // JButton
    static JButton b, b1, b2;
    static JButton af_agenti,af_locuinte,af_clienti,home_button;

    // label to diaplay text
    static JLabel l;


    // main class
    public static void main(String[] args)
    {
        try{
        // create a new frame to stor text field and button
       //HOME

            home_button=new JButton("   Home  ");
            home_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_home.show();
                    f_vanzare.hide();
                }
            });



        f_home = new JFrame("panel");
        // create a label to display text
        l = new JLabel("Agentie Imodibiliara");
        l.setAlignmentX(0.5f);
        // create a new buttons
        b = new JButton(" Afisari");
        b1 = new JButton("Modificari");
        b2 = new JButton("Vanzare");
        b.setAlignmentX(0.5f);
        b1.setAlignmentX(0.5f);
        b2.setAlignmentX(0.5f);
        b1.setMargin(new Insets(5,50,5,50));
        b2.setMargin(new Insets(5,50,5,50));
        b.setMargin(new Insets(5,50,5,50));
        // create a panel to add buttons and textfield and a layou
        JPanel p = new JPanel();
        // set Box Layout
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        // add buttons and textfield to panel
        JPanel sp1=new JPanel();
        p.add(l);
        p.add(Box.createRigidArea(new Dimension(0, 30)));
        p.add(b);
        p.add(Box.createRigidArea(new Dimension(0, 7)));
        p.add(b1);
        p.add(Box.createRigidArea(new Dimension(0, 7)));
        p.add(b2);
        p.add(Box.createRigidArea(new Dimension(0, 7)));
        // setbackground of panel
        p.setBackground(Color.black);

        // add panel to frame
        f_home.add(p);

        // set the size of frame
        f_home.setSize(300, 400);

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                f_home.hide();
                f_afisare.show();

            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f_home.hide();
                f_modificari.show();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f_home.hide();
                f_vanzare.show();
            }
        });

      //fin HOME



      //AFISARE
        f_afisare = new JFrame("panel");
        f_afisare.setBackground(Color.red);
        f_afisare.setSize(300,400);
        JPanel p1 = new JPanel();
        // set Box Layout
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setBackground(Color.red);

        p1.add(Box.createRigidArea(new Dimension(0, 30)));
        af_agenti = new JButton(" Afisare Agenti");
        af_clienti = new JButton("Afisare Clienti");
        af_locuinte = new JButton("Afisare Locuinte");
            af_agenti.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_afisare.hide();
                    f_agenti.show();
                }
            });

            af_clienti.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_afisare.hide();
                    f_clienti.show();
                }
            });

            af_locuinte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_afisare.hide();
                    f_locuinte.show();
                }
            });
        af_agenti.setAlignmentX(0.5f);
        af_clienti.setAlignmentX(0.5f);
        af_locuinte.setAlignmentX(0.5f);
        af_agenti.setMargin(new Insets(0,50,0,50));
        af_clienti.setMargin(new Insets(0,50,0,50));
        af_locuinte.setMargin(new Insets(0,50,0,50));
        p1.add(af_agenti);
        p1.add(Box.createRigidArea(new Dimension(0, 10)));
        p1.add(af_clienti);
        p1.add(Box.createRigidArea(new Dimension(0, 10)));
        p1.add(af_locuinte);
        p1.add(Box.createRigidArea(new Dimension(0, 10)));


        f_afisare.add(p1);


       // f_afisare.show();


            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "000000@222222");
            Service s = new Service(conn);
            DB_Read DB=new DB_Read(conn);
            s.setAgenti(DB.Read_Agenti());
            List<Casa> lista_case=DB.Read_Case();
            List<Apartament> lista_ap=DB.Read_Apartamente();
            for(int i=0;i<lista_case.size();i++)
                s.add_locuinta(lista_case.get(i));
            for(int i=0;i<lista_ap.size();i++)
                s.add_locuinta(lista_ap.get(i));
            s.setClienti(DB.Read_Clienti());
            System.out.println(s.getClienti().size());


            //AFISARE AGENTI
            f_agenti=new JFrame();
            f_agenti.setSize(300,400);
            JPanel p2= new JPanel();
            JLabel label_a = new JLabel("Agenti",SwingConstants.CENTER);

            p2.add(label_a);
            p2.add(Box.createRigidArea(new Dimension(0, 20)));
            p2.setBackground(Color.blue);

            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));




            for(int i=0;i<s.getAgenti().size();i++){
                String ind_loc="Indice: "+Integer.toString(i+1)+"                                             ";
                String af_agent="Nume: "+s.getAgenti().get(i).getNume();
                String af_agent1="Prenume: "+s.getAgenti().get(i).getPrenume();
                String af_agent2="Suma totala vanzari: "+s.getAgenti().get(i).getSuma_totala_vanzari();
                JPanel pane2 = new JPanel();
                pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
                pane2.setSize(100,100);
                JLabel jl=new JLabel(ind_loc);
                JLabel jlabe = new JLabel(af_agent);
                JLabel jlabe1 = new JLabel(af_agent1);
                JLabel jlabe2 = new JLabel(af_agent2);
                pane2.setBackground(Color.black);
                pane2.add(jl);
                pane2.add(jlabe);
                pane2.add(jlabe1);
                pane2.add(jlabe2);


                p2.add(pane2);
                p2.add(Box.createRigidArea(new Dimension(0, 10)));

                 //fin AFISARE AGENTI









            }

            JButton home_button1=new JButton("   Home   ");
            home_button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_home.show();
                    f_agenti.hide();
                }
            });



              p2.add(home_button1);
            JScrollPane scroller3 = new JScrollPane(p2);
            // p_clienti.add(scroller,BorderLayout.CENTER);
            f_agenti.add(scroller3);




           // f_agenti.add(p2);
           // f_agenti.show();


            f_locuinte=new JFrame();
            f_locuinte.setSize(300,400);
            JPanel p_locuinte= new JPanel();
            JLabel label_loc = new JLabel("Locuinte",SwingConstants.CENTER);
            p_locuinte.add(label_loc);
            p_locuinte.add(Box.createRigidArea(new Dimension(0, 15)));
            for(int i=0;i<s.getLocuinte_disponibile().size();i++){
            String ind_loc="Indice: "+Integer.toString(i+1)+"                                                              ";
            String af_loc="Tip: "+s.getLocuinte_disponibile().get(i).get_Type();
            String af_loc1="Pret: "+s.getLocuinte_disponibile().get(i).getPret();
            String af_loc2="Adresa: "+(s.getLocuinte_disponibile().get(i)).get_Adresa();

            JPanel pane_loc_ob = new JPanel();
            pane_loc_ob.setLayout(new BoxLayout(pane_loc_ob, BoxLayout.Y_AXIS));
            pane_loc_ob.setSize(100,100);
            JLabel jl=new JLabel(ind_loc);
            JLabel jlabe = new JLabel(af_loc);
            JLabel jlabe1 = new JLabel(af_loc1);
            JLabel jlabe2 = new JLabel(af_loc2);
            pane_loc_ob.setBackground(Color.black);
            pane_loc_ob.add(jl);
            pane_loc_ob.add(jlabe);
            pane_loc_ob.add(jlabe1);
            pane_loc_ob.add(jlabe2);

            p_locuinte.add(pane_loc_ob);
            p_locuinte.add(Box.createRigidArea(new Dimension(0, 10)));
            }
           p_locuinte.add(Box.createRigidArea(new Dimension(0, 20)));
           p_locuinte.setBackground(Color.orange);
            p_locuinte.setLayout(new BoxLayout(p_locuinte, BoxLayout.Y_AXIS));



            JButton home_button2=new JButton("   Home   ");
            home_button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_home.show();
                    f_locuinte.hide();
                }
            });

            p_locuinte.add(home_button2);
            JScrollPane scroller2 = new JScrollPane(p_locuinte);
            // p_clienti.add(scroller,BorderLayout.CENTER);
            f_locuinte.add(scroller2);
            //f_locuinte.add(p_locuinte);
            // f_locuinte.show();

         /*   for(int i=0;i<s.getLocuinte_disponibile().size();i++){

                String af_loc="Tip: "+s.getLocuinte_disponibile().get(i).get_Type();
                String af_loc1="Pret: "+s.getLocuinte_disponibile().get(i).getPret();
                String af_loc2="Adresa: "+(s.getLocuinte_disponibile().get(i)).get_Adresa();

                JPanel pane_loc_ob = new JPanel();
                pane_loc_ob.setLayout(new BoxLayout(pane_loc_ob, BoxLayout.Y_AXIS));
                pane_loc_ob.setSize(100,100);
                JLabel jlabe = new JLabel(af_loc);
                JLabel jlabe1 = new JLabel(af_loc1);
                JLabel jlabe2 = new JLabel(af_loc2);
                pane_loc_ob.setBackground(Color.black);
                pane_loc_ob.add(jlabe);
                pane_loc_ob.add(jlabe1);
                pane_loc_ob.add(jlabe2);

                 p_locuinte.add(pane_loc_ob);
                p_locuinte.add(Box.createRigidArea(new Dimension(0, 10)));
            }
*/

            f_clienti=new JFrame();
            f_clienti.setSize(300,400);

          //  JScrollPane p_clienti = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           JPanel p_clienti= new JPanel();

            JLabel label_cl = new JLabel("Clienti",SwingConstants.CENTER);
            p_clienti.setLayout(new BoxLayout(p_clienti, BoxLayout.Y_AXIS));
            p_clienti.add(label_cl);
            p_clienti.add(home_button);
            p_clienti.add(Box.createRigidArea(new Dimension(0, 20)));
            p_clienti.setBackground(Color.orange);



            for(int i=0;i<s.getClienti().size();i++){
                String af_cl="Nume: "+s.getClienti().get(i).getNume();
                String af_cl1="Prenume: "+s.getClienti().get(i).getPrenume();


                JPanel pane_cl_ob = new JPanel();
                pane_cl_ob.setLayout(new BoxLayout(pane_cl_ob, BoxLayout.Y_AXIS));
                pane_cl_ob.setSize(100,100);
                JLabel jlabe = new JLabel(af_cl);
                JLabel jlabe1 = new JLabel(af_cl1);
                pane_cl_ob.setBackground(Color.black);
                pane_cl_ob.add(jlabe);
                pane_cl_ob.add(jlabe1);


                p_clienti.add(pane_cl_ob);
                p_clienti.add(Box.createRigidArea(new Dimension(0, 10)));

            }


            JButton home_button3=new JButton("   Home   ");
            home_button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_home.show();
                    f_clienti.hide();
                }
            });

            p_clienti.add(home_button3);



            JScrollPane scroller1 = new JScrollPane(p_clienti);
           // p_clienti.add(scroller,BorderLayout.CENTER);
            f_clienti.add(scroller1);
           // f_clienti.add(p_clienti);
           // f_clienti.show();










            f_vanzare=new JFrame();
            f_vanzare.setSize(300,400);
            f_vanzare.setBackground(Color.black);

            JPanel pane_vanzare=new JPanel();
            pane_vanzare.setSize(300,250);
            pane_vanzare.setBackground(Color.black);

            JPanel pane_space=new JPanel();
            pane_space.setLayout(new BoxLayout(pane_space,BoxLayout.X_AXIS));
            pane_space.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space.setSize(300,30);

            pane_space.setBackground(Color.black);
            pane_space.add(Box.createRigidArea(new Dimension(300, 15)));
            pane_vanzare.add(pane_space);

            JPanel pane_nume=new JPanel();

            pane_nume.setLayout(new BoxLayout(pane_nume,BoxLayout.X_AXIS));
            pane_nume.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_nume.setSize(300,30);

            pane_nume.setBackground(Color.black);
            JLabel nume_label=new JLabel("Nume client:       ");
            JTextField nume_text=new JTextField();
            pane_nume.add(nume_label);
            nume_text.setSize(100,30);
            pane_nume.add(nume_text);

            JPanel pane_prenume=new JPanel();
            pane_prenume.setSize(300,30);
            pane_prenume.setBackground(Color.black);
            pane_prenume.setLayout(new BoxLayout(pane_prenume,BoxLayout.X_AXIS));
            pane_prenume.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_prenume.setSize(300,30);
            pane_prenume.setBackground(Color.black);
            JLabel prenume_label=new JLabel("Prenume client: ");
            prenume_label.setSize(100,30);
            JTextField prenume_text=new JTextField();
            pane_prenume.add(prenume_label);
            prenume_text.setSize(100,30);
            pane_prenume.add(prenume_text);

            JPanel pane_agent=new JPanel();
            pane_agent.setSize(300,30);
            pane_agent.setBackground(Color.black);
            pane_agent.setLayout(new BoxLayout(pane_agent,BoxLayout.X_AXIS));
            pane_agent.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_agent.setSize(300,30);
            pane_agent.setBackground(Color.black);
            JLabel agent_label=new JLabel("Indice agent:       ");
            agent_label.setSize(100,30);
            JTextField agent_text=new JTextField();
            pane_agent.add(agent_label);
            agent_text.setSize(100,30);
            pane_agent.add(agent_text);

            JPanel pane_loc=new JPanel();
            pane_loc.setSize(300,30);
            pane_loc.setBackground(Color.black);
            pane_loc.setLayout(new BoxLayout(pane_loc,BoxLayout.X_AXIS));
            pane_loc.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_loc.setSize(300,30);
            pane_loc.setBackground(Color.black);
            JLabel locuinta_label=new JLabel("Indice locuinta:   ");
            locuinta_label.setSize(100,30);
            JTextField locuinta_text=new JTextField();
            pane_loc.add(locuinta_label);
            locuinta_text.setSize(100,30);
            pane_loc.add(locuinta_text);

            JPanel pane_tip=new JPanel();
            pane_tip.setSize(300,30);
            pane_tip.setBackground(Color.black);
            pane_tip.setLayout(new BoxLayout(pane_tip,BoxLayout.X_AXIS));
            pane_tip.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_tip.setSize(300,30);
            pane_tip.setBackground(Color.black);
            JLabel tip_label=new JLabel("Tip achizitie:        ");
            tip_label.setSize(100,30);
            JTextField tip_text=new JTextField();
            pane_tip.add(tip_label);
            tip_text.setSize(100,30);
            pane_tip.add(tip_text);



            JPanel pane_space1=new JPanel();
            pane_space1.setLayout(new BoxLayout(pane_space1,BoxLayout.X_AXIS));
            pane_space1.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space1.setSize(300,30);

            pane_space1.setBackground(Color.black);
            pane_space1.add(Box.createRigidArea(new Dimension(300, 10)));





            JPanel pane_submit=new JPanel();
            pane_submit.setSize(300,30);
            pane_submit.setBackground(Color.black);
            pane_submit.setLayout(new BoxLayout(pane_submit,BoxLayout.X_AXIS));
            pane_submit.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_submit.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton submit_button=new JButton("  Submit ");

            submit_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nume=nume_text.getText();
                    String prenume=prenume_text.getText();
                    String agent=agent_text.getText();
                    String locuinta=locuinta_text.getText();
                    String tip=tip_text.getText();
                    Integer ind_agent=Integer.parseInt(agent);
                    Integer ind_locuinta=Integer.parseInt(locuinta);

                    Client new_client=new Client();
                    new_client.setNume(nume);
                    new_client.setPrenume(prenume);
                    new_client.setA1(s.getAgenti().get(ind_agent-1));
                    new_client.setLoc(s.getLocuinte_disponibile().get(ind_locuinta-1));

                    s.getClienti().add(new_client);
                    DB_Write write_cl=new DB_Write(conn);
                    try {
                        write_cl.Write_Client(s.getClienti().size()-1,ind_agent,new_client);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    Double update_suma=s.getAgenti().get(ind_agent-1).getSuma_totala_vanzari()+s.getLocuinte_disponibile().get(ind_locuinta-1).getPret();
                    s.getAgenti().get(ind_agent-1).setSuma_totala_vanzari(update_suma);

                    DB_Alter alter_agent=new DB_Alter(conn);
                    try {
                        alter_agent.Alter_Agent(ind_agent,update_suma);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    DB_Delete delete_loc=new DB_Delete(conn);
                    try {
                        delete_loc.Delete_Locuinta(s.getLocuinte_disponibile().get(ind_locuinta-1));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    DB_Write write_tranz=new DB_Write(conn);
                    write_tranz.Write_Tranzactie(s.getLocuinte_disponibile().get(ind_locuinta-1).get_Type(),
                            tip,s.getLocuinte_disponibile().get(ind_locuinta-1).getPret(),nume,s.getAgenti().get(ind_agent-1).getNume());

                    System.out.println(nume);
                }
            }


        );

            submit_button.setSize(100,30);
            pane_submit.add(submit_button);


            pane_vanzare.setLayout(new BoxLayout(pane_vanzare,BoxLayout.Y_AXIS));
            pane_vanzare.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_vanzare.add(pane_nume);
            pane_vanzare.add(pane_prenume);
            pane_vanzare.add(pane_agent);
            pane_vanzare.add(pane_loc);
            pane_vanzare.add(pane_tip);
            pane_vanzare.add(pane_space1);
            pane_vanzare.add(pane_submit);




            JPanel af=new JPanel();
            af.setSize(300,100);
            af.setBackground(Color.black);
            JPanel pane_af_agenti=new JPanel();
            pane_af_agenti.setSize(300,30);
            pane_af_agenti.setBackground(Color.black);
            pane_af_agenti.setLayout(new BoxLayout(pane_af_agenti,BoxLayout.X_AXIS));
            pane_af_agenti.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_af_agenti.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton agenti_button=new JButton("  Agenti  ");

            agenti_button.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    f_agenti.show();
                                                }
                                            }


            );

            agenti_button.setSize(100,30);
            pane_af_agenti.add(agenti_button);


             pane_vanzare.add(pane_af_agenti);


            JPanel pane_af_locuinte=new JPanel();
            pane_af_locuinte.setSize(300,30);
            pane_af_locuinte.setBackground(Color.black);
            pane_af_locuinte.setLayout(new BoxLayout(pane_af_locuinte,BoxLayout.X_AXIS));
            pane_af_locuinte.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_af_locuinte.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton locuinte_button=new JButton("Locuinte");

            locuinte_button.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    f_locuinte.show();
                                                }
                                            }


            );
            pane_af_locuinte.add(locuinte_button);

            locuinte_button.setSize(150,30);

             pane_vanzare.add(pane_af_locuinte);





            JPanel pane_back=new JPanel();
            pane_back.setSize(300,30);
            pane_back.setBackground(Color.black);
            pane_back.setLayout(new BoxLayout(pane_back,BoxLayout.X_AXIS));
            pane_back.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_back.add(Box.createRigidArea(new Dimension(100, 30)));


            pane_back.add(home_button);
            pane_vanzare.add(pane_back);


            f_vanzare.add(pane_vanzare);
            f_vanzare.add(af);
           // f_vanzare.show();



            f_modificari = new JFrame("panel");
            f_modificari.setBackground(Color.red);
            f_modificari.setSize(300,400);
            JPanel p_add = new JPanel();
            // set Box Layout
            p_add.setLayout(new BoxLayout(p_add, BoxLayout.Y_AXIS));
            p_add.setBackground(Color.red);

            p1.add(Box.createRigidArea(new Dimension(0, 30)));
            JButton add_agenti = new JButton(" Adaugare Agent");
            JButton add_locuinte = new JButton("Adaugare Locuinta");


            add_agenti.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_add_agent.show();
                }
            });

            add_locuinte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_add_locuinta.show();
                }
            });

            add_agenti.setAlignmentX(0.5f);
            add_locuinte.setAlignmentX(0.5f);
            add_agenti.setMargin(new Insets(5,50,5,50));
            add_locuinte.setMargin(new Insets(5,50,5,50));

            p_add.add(Box.createRigidArea(new Dimension(300, 20)));
            p_add.add(add_agenti);
            p_add.add(Box.createRigidArea(new Dimension(300, 10)));
            p_add.add(add_locuinte);

            f_modificari.add(p_add);




            f_add_agent=new JFrame();
            f_add_agent.setSize(300,400);
            f_add_agent.setBackground(Color.black);

            JPanel pane_ad_ag=new JPanel();
            pane_ad_ag.setSize(300,250);
            pane_ad_ag.setBackground(Color.black);

            JPanel pane_space_ag=new JPanel();
            pane_space_ag.setLayout(new BoxLayout(pane_space_ag,BoxLayout.X_AXIS));
            pane_space_ag.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space_ag.setSize(300,30);

            pane_space_ag.setBackground(Color.black);
            pane_space_ag.add(Box.createRigidArea(new Dimension(300, 15)));
            pane_ad_ag.add(pane_space_ag);

            JPanel pane_nume_ag=new JPanel();

            pane_nume_ag.setLayout(new BoxLayout(pane_nume_ag,BoxLayout.X_AXIS));
            pane_nume_ag.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_nume_ag.setSize(300,30);

            pane_nume_ag.setBackground(Color.black);
            JLabel nume_label_ag=new JLabel("Nume agent:       ");
            JTextField nume_text_ag=new JTextField();
            pane_nume_ag.add(nume_label_ag);
            nume_text_ag.setSize(100,30);
            pane_nume_ag.add(nume_text_ag);

            JPanel pane_prenume_ag=new JPanel();
            pane_prenume_ag.setSize(300,30);
            pane_prenume_ag.setBackground(Color.black);
            pane_prenume_ag.setLayout(new BoxLayout(pane_prenume_ag,BoxLayout.X_AXIS));
            pane_prenume_ag.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_prenume_ag.setSize(300,30);
            pane_prenume_ag.setBackground(Color.black);
            JLabel prenume_label_ag=new JLabel("Prenume agent: ");
            prenume_label_ag.setSize(100,30);
            JTextField prenume_text_ag=new JTextField();
            pane_prenume_ag.add(prenume_label_ag);
            prenume_text_ag.setSize(100,30);
            pane_prenume_ag.add(prenume_text_ag);




            JPanel pane_space2=new JPanel();
            pane_space2.setLayout(new BoxLayout(pane_space2,BoxLayout.X_AXIS));
            pane_space2.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space2.setSize(300,30);

            pane_space2.setBackground(Color.black);
            pane_space2.add(Box.createRigidArea(new Dimension(300, 10)));





            JPanel pane_submit_ag=new JPanel();
            pane_submit_ag.setSize(300,30);
            pane_submit_ag.setBackground(Color.black);
            pane_submit_ag.setLayout(new BoxLayout(pane_submit_ag,BoxLayout.X_AXIS));
            pane_submit_ag.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_submit_ag.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton submit_button_ag=new JButton("  Adaugare ");

            submit_button_ag.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nume_agent=nume_text_ag.getText();
                    String prenume_agent=prenume_text_ag.getText();
                    Agent new_agent=new Agent(nume_agent,prenume_agent);

                    s.add_agent(new_agent);
                    int indice=s.getAgenti().size();
                    DB_Write write_ag=new DB_Write(conn);
                    write_ag.Write_Agent(indice,new_agent);

                }
            });


            JButton home_button4=new JButton("     Home     ");
            home_button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_home.show();
                    f_add_agent.hide();
                }
            });







            pane_ad_ag.setSize(300,150);
            JPanel pane_aux=new JPanel();
            pane_aux.setSize(300,250);
            pane_aux.setBackground(Color.black);
            pane_ad_ag.setLayout(new BoxLayout(pane_ad_ag,BoxLayout.Y_AXIS));
            pane_ad_ag.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_ad_ag.add(pane_space1);
            pane_ad_ag.add(pane_nume_ag);
            pane_ad_ag.add(pane_prenume_ag);
            pane_ad_ag.add(pane_space2);
            pane_ad_ag.add(submit_button_ag);
            pane_ad_ag.add(home_button4);

            f_add_agent.add(pane_ad_ag);
            f_add_agent.add(pane_aux);
         //   f_add_agent.show();




            f_add_locuinta = new JFrame("panel");
            f_add_locuinta.setBackground(Color.red);
            f_add_locuinta.setSize(300,400);
            JPanel p6 = new JPanel();
            // set Box Layout
            p6.setLayout(new BoxLayout(p6, BoxLayout.Y_AXIS));
            p6.setBackground(Color.red);

            p6.add(Box.createRigidArea(new Dimension(0, 30)));
            JButton ad_ap = new JButton(" Adaucare Casa");
            JButton ad_casa = new JButton("Adaugare Apartament");

            ad_ap.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_add_locuinta.hide();
                    f_add_casa.show();
                }
            });

            ad_casa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f_add_locuinta.hide();
                    f_add_apartament.show();
                }
            });


            ad_ap.setAlignmentX(0.5f);
            ad_casa.setAlignmentX(0.5f);

            ad_ap.setMargin(new Insets(0,50,0,50));
            ad_casa.setMargin(new Insets(0,50,0,50));

            p6.add(ad_casa);
            p6.add(Box.createRigidArea(new Dimension(0, 10)));
            p6.add(ad_ap);
            p6.add(Box.createRigidArea(new Dimension(0, 10)));


            f_add_locuinta.add(p6);

            //de facut adaugare casa si apartament
            f_add_casa=new JFrame();
            f_add_casa.setSize(300,400);
            f_add_casa.setBackground(Color.black);

            JPanel pane_vanzare_casa=new JPanel();
            pane_vanzare_casa.setSize(300,250);
            pane_vanzare_casa.setBackground(Color.black);

            JPanel pane_space_1=new JPanel();
            pane_space_1.setLayout(new BoxLayout(pane_space_1,BoxLayout.X_AXIS));
            pane_space_1.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space_1.setSize(300,30);

            pane_space_1.setBackground(Color.black);
            pane_space_1.add(Box.createRigidArea(new Dimension(300, 15)));
            pane_vanzare_casa.add(pane_space_1);

            JPanel pane_pret_casa=new JPanel();

            pane_pret_casa.setLayout(new BoxLayout(pane_pret_casa,BoxLayout.X_AXIS));
            pane_pret_casa.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_pret_casa.setSize(300,30);

            pane_pret_casa.setBackground(Color.black);
            JLabel pret_casa_label=new JLabel("Pret:                 ");
            JTextField pret_text=new JTextField();
            pane_pret_casa.add(pret_casa_label);
            pret_text.setSize(100,30);
            pane_pret_casa.add(pret_text);

            JPanel pane_suprafata_casa=new JPanel();
            pane_suprafata_casa.setSize(300,30);
            pane_suprafata_casa.setBackground(Color.black);
            pane_suprafata_casa.setLayout(new BoxLayout(pane_suprafata_casa,BoxLayout.X_AXIS));
            pane_suprafata_casa.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_suprafata_casa.setSize(300,30);
            pane_suprafata_casa.setBackground(Color.black);
            JLabel sup_casa_label=new JLabel("Suprafata:      ");
            sup_casa_label.setSize(100,30);
            JTextField sup_casa_text=new JTextField();
            pane_suprafata_casa.add(sup_casa_label);
            sup_casa_text.setSize(100,30);
            pane_suprafata_casa.add(sup_casa_text);

            JPanel pane_adresa_casa=new JPanel();
            pane_adresa_casa.setSize(300,30);
            pane_adresa_casa.setBackground(Color.black);
            pane_adresa_casa.setLayout(new BoxLayout(pane_adresa_casa,BoxLayout.X_AXIS));
            pane_adresa_casa.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_adresa_casa.setSize(300,30);
            pane_adresa_casa.setBackground(Color.black);
            JLabel ad_casa_label=new JLabel("Adresa:          ");
            ad_casa_label.setSize(100,30);
            JTextField ad_casa_text=new JTextField();
            pane_adresa_casa.add(ad_casa_label);
            ad_casa_text.setSize(100,30);
            pane_adresa_casa.add(ad_casa_text);

            JPanel pane_nret=new JPanel();
            pane_nret.setSize(300,30);
            pane_nret.setBackground(Color.black);
            pane_nret.setLayout(new BoxLayout(pane_nret,BoxLayout.X_AXIS));
            pane_nret.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_nret.setSize(300,30);
            pane_nret.setBackground(Color.black);
            JLabel nret_label=new JLabel("Numar etaje: ");
            nret_label.setSize(100,30);
            JTextField nret_text=new JTextField();
            pane_nret.add(nret_label);
            nret_text.setSize(100,30);
            pane_nret.add(nret_text);



            JPanel pane_space12=new JPanel();
            pane_space12.setLayout(new BoxLayout(pane_space12,BoxLayout.X_AXIS));
            pane_space12.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space12.setSize(300,30);

            pane_space12.setBackground(Color.black);
            pane_space12.add(Box.createRigidArea(new Dimension(300, 10)));





            JPanel pane_add_casa=new JPanel();
            pane_add_casa.setSize(300,30);
            pane_add_casa.setBackground(Color.black);
            pane_add_casa.setLayout(new BoxLayout(pane_add_casa,BoxLayout.X_AXIS));
            pane_add_casa.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_add_casa.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton add_casa_button=new JButton("  Adaugare ");

            add_casa_button.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e)  {
                                                    Double pret=Double.parseDouble(pret_text.getText());
                                                    Double suprafata=Double.parseDouble(sup_casa_text.getText());
                                                    String adresa=ad_casa_text.getText();
                                                    Integer nr_et=Integer.parseInt(nret_text.getText());


                                                    Casa new_casa=new Casa();
                                                    new_casa.setPret(pret);
                                                    new_casa.setSuprafata(suprafata);
                                                    new_casa.setAdresa(adresa);
                                                    new_casa.setNr_etaje(nr_et);

                                                    s.add_locuinta(new_casa);


                                                    DB_Write write_casa=new DB_Write(conn);
                                                    write_casa.Write_Casa(new_casa);

                                                }
                                            }


            );

            add_casa_button.setSize(100,30);
            pane_add_casa.add(add_casa_button);

            JPanel home_b=new JPanel();
            home_b.setSize(300,30);
            home_b.setBackground(Color.black);
            home_b.setLayout(new BoxLayout(home_b,BoxLayout.X_AXIS));
            home_b.setAlignmentX(Component.LEFT_ALIGNMENT);
            home_b.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton home_but=new JButton("     Home     ");
            home_but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pane_vanzare_casa.hide();
                    f_home.show();
                }
            });

            home_b.add(home_but);





            pane_vanzare_casa.setSize(300,150);
            pane_vanzare_casa.setLayout(new BoxLayout(pane_vanzare_casa,BoxLayout.Y_AXIS));
            pane_vanzare_casa.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_vanzare_casa.add(pane_pret_casa);
            pane_vanzare_casa.add(pane_suprafata_casa);
            pane_vanzare_casa.add(pane_adresa_casa);
            pane_vanzare_casa.add(pane_nret);
            //pane_vanzare_casa.add(pane_space1);
            pane_vanzare_casa.add(pane_adresa_casa);
            pane_vanzare_casa.add(pane_add_casa);
            pane_vanzare_casa.add(home_b);

            JPanel pane_aux_casa=new JPanel();
            pane_aux_casa.setSize(300,100);
            pane_aux_casa.setBackground(Color.black);

           f_add_casa.add(pane_vanzare_casa);
           f_add_casa.add(pane_aux_casa);
          // f_add_casa.show();




           f_add_apartament=new JFrame();
            f_add_apartament.setSize(300,400);
            f_add_apartament.setBackground(Color.black);

            JPanel pane_vanzare_ap=new JPanel();
            pane_vanzare_ap.setSize(300,300);
            pane_vanzare_ap.setBackground(Color.black);

            JPanel pane_space_11=new JPanel();
            pane_space_11.setLayout(new BoxLayout(pane_space_11,BoxLayout.X_AXIS));
            pane_space_11.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space_11.setSize(300,30);

            pane_space_11.setBackground(Color.black);
            pane_space_11.add(Box.createRigidArea(new Dimension(300, 15)));
            pane_vanzare_ap.add(pane_space_11);

            JPanel pane_pret_ap=new JPanel();

            pane_pret_ap.setLayout(new BoxLayout(pane_pret_ap,BoxLayout.X_AXIS));
            pane_pret_ap.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_pret_ap.setSize(300,30);

            pane_pret_ap.setBackground(Color.black);
            JLabel pret_ap_label=new JLabel("Pret:                      ");
            JTextField pret_ap_text=new JTextField();
            pane_pret_ap.add(pret_ap_label);
            pret_ap_text.setSize(100,30);
            pane_pret_ap.add(pret_ap_text);

            JPanel pane_suprafata_ap=new JPanel();
            pane_suprafata_ap.setSize(300,30);
            pane_suprafata_ap.setBackground(Color.black);
            pane_suprafata_ap.setLayout(new BoxLayout(pane_suprafata_ap,BoxLayout.X_AXIS));
            pane_suprafata_ap.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_suprafata_ap.setSize(300,30);
            pane_suprafata_ap.setBackground(Color.black);
            JLabel sup_ap_label=new JLabel("Suprafata:           ");
            sup_ap_label.setSize(100,30);
            JTextField sup_ap_text=new JTextField();
            pane_suprafata_ap.add(sup_ap_label);
            sup_ap_text.setSize(100,30);
            pane_suprafata_ap.add(sup_ap_text);

            JPanel pane_adresa_ap=new JPanel();
            pane_adresa_ap.setSize(300,30);
            pane_adresa_ap.setBackground(Color.black);
            pane_adresa_ap.setLayout(new BoxLayout(pane_adresa_ap,BoxLayout.X_AXIS));
            pane_adresa_ap.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_adresa_ap.setSize(300,30);
            pane_adresa_ap.setBackground(Color.black);
            JLabel ad_ap_label=new JLabel("Adresa:                ");
            ad_ap_label.setSize(100,30);
            JTextField ad_ap_text=new JTextField();
            pane_adresa_ap.add(ad_ap_label);
            ad_ap_text.setSize(100,30);
            pane_adresa_ap.add(ad_ap_text);

            JPanel pane_nrcam=new JPanel();
            pane_nrcam.setSize(300,30);
            pane_nrcam.setBackground(Color.black);
            pane_nrcam.setLayout(new BoxLayout(pane_nrcam,BoxLayout.X_AXIS));
            pane_nrcam.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_nrcam.setSize(300,30);
            pane_nrcam.setBackground(Color.black);
            JLabel nrcam_label=new JLabel("Numar camere: ");
            nrcam_label.setSize(100,30);
            JTextField nrcam_text=new JTextField();
            pane_nrcam.add(nrcam_label);
            nrcam_text.setSize(100,30);
            pane_nrcam.add(nrcam_text);


            JPanel pane_etaj=new JPanel();
            pane_etaj.setSize(300,30);
            pane_etaj.setBackground(Color.black);
            pane_etaj.setLayout(new BoxLayout(pane_etaj,BoxLayout.X_AXIS));
            pane_etaj.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_etaj.setSize(300,30);
            pane_etaj.setBackground(Color.black);
            JLabel etaj_label=new JLabel("Etaj:                       ");
            nrcam_label.setSize(100,30);
            JTextField etaj_text=new JTextField();
            pane_etaj.add(etaj_label);
            etaj_text.setSize(100,30);
            pane_etaj.add(etaj_text);



            JPanel pane_numar=new JPanel();
            pane_numar.setSize(300,30);
            pane_numar.setBackground(Color.black);
            pane_numar.setLayout(new BoxLayout(pane_numar,BoxLayout.X_AXIS));
            pane_numar.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_numar.setSize(300,30);
            pane_numar.setBackground(Color.black);
            JLabel numar_label=new JLabel("Numar:                 ");
            numar_label.setSize(100,30);
            JTextField numar_text=new JTextField();
            pane_numar.add(numar_label);
            numar_text.setSize(100,30);
            pane_numar.add(numar_text);






            JPanel pane_space13=new JPanel();
            pane_space13.setLayout(new BoxLayout(pane_space13,BoxLayout.X_AXIS));
            pane_space13.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_space13.setSize(300,30);

            pane_space13.setBackground(Color.black);
            pane_space13.add(Box.createRigidArea(new Dimension(300, 10)));





            JPanel pane_add_ap=new JPanel();
            pane_add_ap.setSize(300,30);
            pane_add_ap.setBackground(Color.black);
            pane_add_ap.setLayout(new BoxLayout(pane_add_ap,BoxLayout.X_AXIS));
            pane_add_ap.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_add_ap.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton add_ap_button=new JButton("  Adaugare ");

            add_ap_button.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e)  {

                                                    //System.out.println("dfdfa");
                                                    Double pret=Double.parseDouble(pret_ap_text.getText());
                                                    //System.out.println("dfdfa");
                                                    Double suprafata=Double.parseDouble(sup_ap_text.getText());
                                                    //System.out.println("dfdfa");
                                                    String adresa=ad_ap_text.getText();
                                                    //System.out.println("dfdfa");
                                                    Integer nr_cam=Integer.parseInt(nrcam_text.getText());
                                                    Integer etaj=Integer.parseInt(etaj_text.getText());
                                                    Integer numar=Integer.parseInt(numar_text.getText());



                                                    Apartament new_ap=new Apartament();
                                                    new_ap.setPret(pret);
                                                    new_ap.setSuprafata(suprafata);
                                                    new_ap.setAdresa(adresa);
                                                    new_ap.setNr_camere(nr_cam);
                                                    new_ap.setEtaj(etaj);
                                                    new_ap.setNumar(numar);


                                                    s.add_locuinta(new_ap);


                                                    DB_Write write_Apartament=new DB_Write(conn);
                                                    write_Apartament.Write_Apartament(new_ap);

                                                }
                                            }


            );

            add_ap_button.setSize(100,30);
            pane_add_ap.add(add_ap_button);

            JPanel home_bb=new JPanel();
            home_bb.setSize(300,30);
            home_bb.setBackground(Color.black);
            home_bb.setLayout(new BoxLayout(home_bb,BoxLayout.X_AXIS));
            home_bb.setAlignmentX(Component.LEFT_ALIGNMENT);
            home_bb.add(Box.createRigidArea(new Dimension(100, 30)));
            JButton home_but1=new JButton("     Home     ");
            home_but1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pane_vanzare_ap.hide();
                    f_home.show();
                }
            });

            home_bb.add(home_but1);





            pane_vanzare_ap.setSize(300,200);
            pane_vanzare_ap.setLayout(new BoxLayout(pane_vanzare_ap,BoxLayout.Y_AXIS));
            pane_vanzare_ap.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane_vanzare_ap.add(pane_pret_ap);
            pane_vanzare_ap.add(pane_suprafata_ap);
            pane_vanzare_ap.add(pane_adresa_ap);
            pane_vanzare_ap.add(pane_nrcam);
            pane_vanzare_ap.add(pane_etaj);
            pane_vanzare_ap.add(pane_numar);
            pane_vanzare_ap.add(pane_add_ap);
            pane_vanzare_ap.add(home_bb);

            JPanel pane_aux_ap=new JPanel();
            pane_aux_ap.setSize(300,100);
            pane_aux_ap.setBackground(Color.black);

            f_add_apartament.add(pane_vanzare_ap);
            f_add_apartament.add(pane_aux_ap);
           // f_add_apartament.show();















        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }





















       f_home.show();
        //f_afisare.show();
    }
}