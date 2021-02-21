public class BST {
    private Node root= null;
    private Node createNode(int num){
        Node nde= new Node(num);
        return nde;
    }
    /*public void insert(int num){
        Node node= createNode(num);
        if(root==null){
            root= node;
        }
        else {
            Node temp= root;
            while(true){
                if(node.num>temp.num){
                    if(temp.right==null){       //Here be careful about temp and temp.child|| Node should be linked properly. Here the temp is some another reference and not a node.
                        temp.right= node;
                        break;
                    }
                    else{
                        temp= temp.right;
                    }
                }
                else{
                    if(temp.left==null){
                        temp.left= node;
                        break;
                    }
                    else{
                        temp= temp.left;
                    }
                }
            }
        }
    }*/
    public void insert(int num){
        if(root==null){
            root= new Node(num);
        }
        else{
            root.insert(num);
        }
    }
    public int getMax(){
        Node temp= root;
        while(temp.right!=null){
            temp= temp.right;
        }
        return temp.data;
    }
    public int getMin(){
        Node temp= root;
        while(temp.left!=null){
            temp= temp.left;
        }
        return temp.data;
    }
    public Node getNum(int num){
        return root.getNum(num);
    }
    private boolean singleChild(int num){
        Node node= getNum(num);
        if(node.left==null||node.right==null){
            return true;
        }
        else{
            return false;
        }
    }
    public void inOrder(){
        root.inOrderTraversal();
    }
    public void preOrder(){
        root.preOrderTraversal();
    }
    public void postOrder(){
        root.postOrderTraversal();
    }
    public void delete(int num){
        if(singleChild(num)){
            root.deleteSingle(num);
        }
        else{
            Node nodeD= root.getNum(num);
            Node nodeR= nodeD.right.getMin();
            nodeD.data= nodeR.data;
            nodeD.right.deleteSingle(nodeR.data);
        }
    }
}
