import java.util.*;

public class EventSimulator
{
    int k;
    ArrayList<Cow> arrivalLine;
    BinaryHeap bh;

    //create an event simulator
    //k determine how many cows can eat grass at the same time
    //arrivalLine is the input stream, sorted by arrival time
    public EventSimulator(int k, ArrayList<Cow> arrivalLine)
    {
        this.k = k;
        this.arrivalLine = arrivalLine;
        this.bh = new BinaryHeap(k);
    }

    //set the arrival line
    public void setArrivalLine(ArrayList<Cow> arrivalLine)
    {
        this.arrivalLine = arrivalLine;
    }

    //start simulation
    public void simulate()
    {
        for (Cow cow: arrivalLine)
        {
            try
            {
                int arrival = cow.getArrival();
                int leave = cow.getArrival() + cow.getEating();
                bh.insert(leave);

                System.out.printf("%d o'clock: cow which arrived at %d o'clock starts eating grass and will leave at %d o'clock\n",
                                  arrival, arrival, leave);
            }
            catch (Exception e)
            {
                // bh is full
                try
                {
                    int time = bh.deleteMin();
                    
                    int arrival = cow.getArrival();
                    int leave = time + cow.getEating();
                    bh.insert(leave);

                    System.out.printf("%d o'clock: cow which arrived at %d o'clock starts eating grass and will leave at %d o'clock\n",
                                    time, arrival, leave);
                }
                catch (Exception ee){System.out.println("EE");};
            }
        }
    }
}