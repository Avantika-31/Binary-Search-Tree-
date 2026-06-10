class Node {
    int data;
    Node left;
    Node right;
    Node(int val ){
        data=val;
        left=right=null;
    }

}
public class BinaryTree {
    Node root;
    BinaryTree(){
        root= null;
    }
    public void inorder(Node node){
        if(node!= null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }
    public void preorder(Node node){
        if(node!=null){
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postorder(Node node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
    public static void main(String[]args){
        BinaryTree tree= new BinaryTree();
        tree.root= new Node(10);
        tree.root.left= new Node(20);
        tree.root.right= new Node(30);
        tree.root.left.left= new Node(40);
       tree. preorder( tree.root);
        tree. inorder( tree.root);
        tree. postorder( tree.root);
    }
}
