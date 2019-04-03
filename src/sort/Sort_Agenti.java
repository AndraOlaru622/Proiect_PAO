package sort;

import classes.Agent;

import java.util.Comparator;

public class Sort_Agenti implements Comparator<Agent> {
    public int compare(Agent a, Agent b)
    {
        if(b.getSuma_totala_vanzari()>a.getSuma_totala_vanzari())
            return 1;
        return -1;

    }
}
