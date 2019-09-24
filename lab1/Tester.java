public class Tester
{
    public static void main(String[] args)
    {
        List list = new List();
        print("" +list.size());
        list.add(0, 6);
        print("" + list.size());
        list.add(1, 7);
        print("" + list.size());
        print("" + list.get(0));
        print("" + list.get(1));
    }

    private static void print(String s)
    {
        System.out.println(s);
    }
}