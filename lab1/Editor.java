import java.util.Scanner;

public class Editor
{
    static List list;
    static int cursor;

    public static void main(String[] args)
    {
        list = new List();
        
        cursor = -1;

        while (true)
        {
            String s = displayList();
            System.out.println(s);
            int[] op = readOp();
            boolean isValid = edit(op);
            if (!isValid)
            {
                System.out.println("Invalid");
            }
        }
    }

    private static String displayList()
    {
        String s = "List:\t{";

        int size = list.size();
        
        for (int i = 0; i < size; i++)
        {
            // display the cursor
            if (cursor == i)
            {
                s += "[";
            }

            // display the number
            s += list.get(i);

            // display the cursor
            if (cursor == i)
            {
                s += "]";
            }

            s += " ";
        }

        s += "}\n";

        return s;
    }

    private static int[] readOp()
    {
        int[] op = new int[2];

        Scanner scan = new Scanner(System.in);
        String inst = scan.next();
        switch (inst.charAt(0))
        {
            case 'I':
                op[0] = OP.INSERT;
                break;
            case 'L':
                op[0] = OP.LEFT;
                break;
            case 'R':
                op[0] = OP.RIGHT;
                break;
            case 'D':
                op[0] = OP.DELETE;
                break;
            case 'Q':
                op[0] = OP.MAXSUM;
                break;
            default:
                op[0] = OP.DEFAULT;
                break;
        }

        if (op[0] == 0 || op[0] == 4)
        {
            op[1] = scan.nextInt();
        }
        else
        {
            op[1] = -1;
        }

        return op;
    }

    private static boolean edit(int[] op)
    {
        boolean isValid = true;

        switch (op[0])
        {
            case OP.INSERT:
                // insert x after cursor
                try
                {
                    list.add(cursor + 1, op[1]);
                    cursor++;
                }
                catch (Exception e)
                {
                    isValid = false;
                }
                break;
            case OP.LEFT:
                // move the cursor left unless it's at the first element
                isValid = (cursor > 0);
                if (isValid)
                {
                    cursor--;
                }
                break;
            case OP.RIGHT:
                // move the cursor right unless it's at the last element
                isValid = (cursor >= 0) && (cursor < list.size() - 1);
                if (isValid)
                {
                    cursor++;
                }
                break;
            case OP.DELETE:
                // delete the element before the cursor
                try
                {
                    list.remove(cursor);
                    if (cursor >= list.size())
                    {
                        cursor--;
                    }
                }
                catch (Exception e)
                {
                    isValid = false;
                }
                break;
            case OP.MAXSUM:
                // output max(Sum(a1, a2, ..., ai)) where 1 <= i <= k
                isValid = (op[1] >= 1) && (op[1] <= list.size());
                if (isValid)
                {
                    int maxSum = maxSum(op[1]);
                    System.out.println("maxSum:\t" + maxSum);
                }
                break;
            default:
                // do nothing
                isValid = false;
                break;
        }

        return isValid;
    }

    private static int maxSum(int k)
    {
        int sum = list.get(0);
        int maxSum = sum; // should not be initialized with 0, or negative integers may bring an error

        for (int i = 2; i <= k; i++)
        {
            sum += list.get(i - 1);
            if (sum > maxSum)
            {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}