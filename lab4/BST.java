class BST
{
    Node rt;

    BST()
    {
        this.rt = null;
    }

    public boolean insert(int x)
    {
        if (rt == null)
        {
            rt = new Node(x);
            return true;
        }
        else
        {
            Node n = rt;
            while(true)
            {
                if (x < n.v)
                {
                    if (n.l == null)
                    {
                        n.l = new Node(x);
                        return true;
                    }
                    else
                    {
                        n = n.l;
                    }
                }
                else if (x > n.v)
                {
                    if (n.r == null)
                    {
                        n.r = new Node(x);
                        return true;
                    }
                    else
                    {
                        n = n.r;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public Node find(int x)
    {
        Node n = rt;
        while(n != null)
        {
            if (x < n.v)
            {
                n = n.l;
            }
            else if (x > n.v)
            {
                n = n.r;
            }
            else
            {
                break;
            }
        }

        return n;
    }

    public boolean remove(int x)
    {
        boolean isSuc = (find(x) != null);
        rt = remove(x, rt);
        return isSuc;
    }

    private Node remove(int x, Node n)
    {
        if (n != null)
        {
            if (x < n.v)
            {
                n.l = remove(x, n.l);
            }
            else if (x > n.v)
            {
                n.r = remove(x, n.r);
            }
            else
            {
                if (n.l == null)
                {
                    n = n.r;
                }
                else
                {
                    n.v = findMax(n.l);
                    n.l = remove(n.v, n.l);
                }
            }
        }

        return n;
    }

    private int findMax(Node n)
    {
        return (n.r == null) ? n.v : findMax(n.r);
    }

    public void preOrder_iterator(Node n)
    {
        traverse(-1);
        System.out.println();
    }

    public void inOrder_iterator(Node n)
    {
        traverse(0);
        System.out.println();
    }

    public void postOrder_iterator(Node n)
    {
        traverse(1);
        System.out.println();
    }

    private void traverse(int order)
    {
        traverse(rt, order);
    }

    private void traverse(Node n, int order)
    {
        if (n != null)
        {
            switch (order)
            {
                case (-1):
                    print(n);
                    System.out.print(' ');
                    traverse(n.l, order);
                    traverse(n.r, order);
                    break;
                case (0):
                    traverse(n.l, order);
                    print(n);
                    System.out.print(' ');
                    traverse(n.r, order);
                    break;
                case (1):
                    traverse(n.l, order);
                    traverse(n.r, order);
                    print(n);
                    System.out.print(' ');
                    break;
            }
        }
    }

    private void print(Node n)
    {
        if (n != null)
        {
            System.out.print(n.v);
        }
    }

    public int kthSmallest(Node n, int k)
    {
        int arr[] = new int[32];
        order(rt, arr, 0);
        return arr[k - 1];
    }

    private int order(Node n, int[] arr, int size)
    {
        if (n == null)
        {
            return size;
        }
        size = order(n.l, arr, size);
        arr[size] = n.v;
        size++;
        size = order(n.r, arr, size);

        return size;
    }

    private int height(Node n)
    {
        if (n == null)
        {
            return 0;
        }
        int ld = height(n.l);
        int rd = height(n.r);
        return ((ld < rd) ? rd : ld) + 1;
    }

    public int FindTreeDeep(Node n)
    {
        return height(n);
    }

    public int closestValue(Node n, double x)
    {
        int closest = -1;

        while(n != null)
        {
            closest = (Math.abs(closest - x) < Math.abs(n.v - x)) ? closest : n.v;
            if (x < n.v)
            {
                n = n.l;
            }
            else if (x > n.v)
            {
                n = n.r;
            }
            else
            {
                break;
            }
        }

        return closest;
    }

    void print()
    {
        traverse(rt, -1);
        System.out.println();
        traverse(rt, 0);
        System.out.println();
        traverse(rt, 1);
        System.out.println();
        System.out.println("---");
    }
}