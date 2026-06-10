import java.util.*;

class Nod{
    Nod left;
    Nod right;
    int data;
    Nod(int data){
        this.data=data;
        left = right=null;
    }
}
public class Breadthsearch {
    Nod root;
    Breadthsearch(){
        root=null;
    }
    public void insert(int data){

        root= insertdata(root,data);
    }
    public Nod insertdata(Nod root,int data){
        if(root==null) root= new Nod(data);
        else if( data<root.data) root.left=insertdata(root.left,data);
        else if(data>root.data)root.right=insertdata(root.right,data);
        return root;
    }
   public void Bfs(Nod node){
        if(root==null) return ;
        Queue<Nod>que= new LinkedList<>();
        que.add(node);
        while(!que.isEmpty()){
            Nod temp= que.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)que.add(temp.left) ;
            if(temp.right!=null)que.add(temp.right);
            }
        }

    public static void main(String[] args) {
        Breadthsearch search= new Breadthsearch();
        Scanner src= new Scanner(System.in);
        int  num= src.nextInt();
        List<Integer>li= new ArrayList<>();
        for(int i=0;i<num;i++){
            int data=src.nextInt();
            li.add(data);
        }
        for(int i=0;i< li.size();i++){
            search.insert(li.get(i));

            }
        search.Bfs(search.root);

    }

}
