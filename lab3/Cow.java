public class Cow
{
    private int arrival;
    private int eating;

    //create a cow
    public Cow (int arrival, int eating)
    {
        this.arrival = arrival;
        this.eating = eating;
    }

    //get the arrival time
    public int getArrival()
    {
        return this.arrival;
    }

    //get the eating time
    public int getEating()
    {
        return this.eating;
    }

    //set the arrival time
    public void setArrival(int arrival)
    {
        this.arrival = arrival;
    }

    //set the eating time
    public void setEating(int eating)
    {
        this.eating = eating;
    }
}