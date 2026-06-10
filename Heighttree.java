import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NOde{
    NOde left;
    NOde right;
    int data;
    NOde( int data){
        this.data= data;
        left = right= null;
    }
}
public class Heighttree {
    NOde root;
    Heighttree(){
     root=null;
    }
    public void insert(int data){
        root= insertdataa(root,data);
    }
    public NOde insertdataa(NOde root,int data) {
        if (root == null) root = new NOde(data);
        else if (data < root.data) root.left = insertdataa(root.left, data);
        else if (data > root.data) root.right = insertdataa(root.right, data);
        return root;
    }
    public int levelorder(NOde node){
        if(node==null)return 0;
        int left = levelorder(node.left);
        int right= levelorder(node.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
         Heighttree tree = new Heighttree();
        Scanner src = new Scanner(System.in);
        int num = src.nextInt();
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int data = src.nextInt();
            li.add(data);
        }
        for (int i = 0; i < li.size(); i++) {
            tree.insert(li.get(i));
        }
        System.out.println("Height = " + tree.levelorder(tree.root));
    }
}
