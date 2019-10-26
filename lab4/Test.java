class Test
{
    public static void main(String[] args)
    {
        //Create BST
        int[] arr = new int[]{2,1,3,4,14,8,9,5,12};
        BST bst = new BST();
        for(int i=0;i<arr.length;i++)
        {
            bst.insert(arr[i]);
        }
        Node rt=bst.rt;
        //Test BST functions
        System.out.println((bst.find(4)==null) ? "null": "find:"+bst.find(4).v);
        bst.inOrder_iterator(rt);
        bst.preOrder_iterator(rt);
        System.out.println();
        
        //Insert
        System.out.println((bst.find(7)==null) ? "null" : "find:"+bst.find(7).v);
        bst.insert(7);
        System.out.println((bst.find(7)==null)? "null" : "find:"+bst.find(7).v);

        bst.inOrder_iterator(rt);
        bst.postOrder_iterator(rt);
        bst.preOrder_iterator(rt);
        //Delete
        bst.remove(8);
        bst.remove(4);
        System.out.println();
        bst.inOrder_iterator(rt);
        //Other functions
        System.out.println("The depth of the tree:"+bst.FindTreeDeep(rt));  System.out.println(bst.kthSmallest(rt,3));
        System.out.println(bst.closestValue(rt,6.5));
    }
}