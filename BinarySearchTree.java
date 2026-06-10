class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.data = val;
        left = right = null;
    }
}
public class BinarySearchTree {
    TreeNode root;
    BinarySearchTree(){
        root=null;
    }
    //=========INSERTION IN BST
    public void insert(int data){
       root= insertdata(root,data);
    }
    public TreeNode insertdata(TreeNode root,int data){
        if(root==null) root= new TreeNode(data);
        else if( data<root.data) root.left=insertdata(root.left,data);
        else if(data>root.data)root.right=insertdata(root.right,data);
        return root;
    }
    //----------------DELETION IN BST--------
    public void deleteop(int data){
        root=deletekey(root,data);
    }
    public TreeNode deletekey(TreeNode node,int key){
        if(root== null)return null;
        else if (key<node.data) node.left=deletekey(node.left,key);
        else if(key>node.data) node.right= deletekey(node.right,key);
        else {
            if (node.right==null) return node.left;
            else if(node.left==null)return node.right;
            else {
                node.data= findScuccesor(node.right);
                node.right=deletekey(node.right,node.data);
                }
            }
        return node;
        }

        public int findScuccesor(TreeNode node){
        int succeor=-1;  // find the succesor from right subtree
        TreeNode temp = node;
        while(temp!=null){
            succeor=temp.data;
            temp= temp.left;
        }
        return succeor;
        }
//------------INORDER TRAVERSAL---
    public void inordertraversal(TreeNode node){
        if(node!=null){
            inordertraversal(node.left);
            System.out.print(node.data+"->");
            inordertraversal(node.right);
        }
    }
    //====MAIN FUNCTION
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(3);
        bst.insert(5);
        bst.insert(30);
        bst.insert(11);
        System.out.println("inorder traversal");
        bst.inordertraversal(bst.root);
        bst.deleteop(10);
        System.out.println("delete op");
        bst.inordertraversal(bst.root);

    }

}
