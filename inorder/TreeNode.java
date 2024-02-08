import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public static void inorder(TreeNode root, List<Integer> lst){
        if (root == null) {
         return;
         }
         if(root.left != null){
             inorder(root.left, lst);
         }

         lst.add(root.val);

         if(root.right != null){
             inorder(root.right, lst);
         }
     }

     public static List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> lst = new ArrayList<>();
      inorder(root, lst);
      return lst;
    }

    List<List<Integer>> order = new ArrayList<>();
    public void levelOrder(TreeNode root, int i) {
        if(root == null){
            return;
        }
        else{
           if(order.size() < i+1){
             List<Integer> lst = new ArrayList<>();
               lst.add(root.val);
               order.add(lst);
           }
           else{ //add to the already present list. 
               order.get(i).add(root.val);
           }
           levelOrder(root.left, i+1);
           levelOrder(root.right, i+1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return order;
    }

    List<List<Integer>> zorder = new ArrayList<>();
    List<List<TreeNode>> treeList = new ArrayList<>();
    public List<List<Integer>> zigZagOrder(TreeNode root) {
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        List<TreeNode> ftree = new ArrayList<>();
        ftree.add(root);
        zorder.add(first);
        treeList.add(ftree);
        int i = 0; 
        while(treeList.get(i) != null){
            List<TreeNode> nextTree = new ArrayList<>();
            List<Integer> nextLst = new ArrayList<>();

            for(int j = 0; j< treeList.get(i).size(); i++){
                TreeNode current = treeList.get(i).get(j);
                if(j%2 == 0){
                nextTree.add(current.right);
                nextTree.add(current.left);
                nextLst.add(current.right.val);
                nextLst.add(current.left.val);
                }
                else{
                nextTree.add(current.left);
                nextTree.add(current.right);
                nextLst.add(current.left.val);
                nextLst.add(current.right.val);
                }
            }
            i++;
        }

                

        zorder.add(new ArrayList<>().add(root.val));
        treeList.add(new ArrayList<>().add(root));

        zigOrder(root, 0, 'L');
        return zorder;
    }



      public TreeNode buildTree(int[] preorder, int[] inorder) {
          List<Integer> preList = Arrays.asList(preorder);
          List<Integer> inList = Arrays.asList(inorder);
       // pick the first of preorder as the root.
       TreeNode root = new TreeNode(preList.get(0));
       for (int i = 1; i < preList.size(); i++){
           int current = preList.get(i);
           int index = inList.indexOf(current);
           TreeNode currentNode = new TreeNode(current);
           //check if it is Ileft child of pre[i-1].
           if(inList.indexOf(current) > inList.indexOf(preList.get(i-1))){
               root.left = currentNode;
           }
           //check if it is the parent of inorder[index -1].
           else if(i < preList.indexOf(inList.get(index-1))){
               TreeNode prev = new TreeNode(inList.get(index -1));
               current.left = prev;
           }
           //has to be the right child of index -1 in inorder.
           else{
               TreeNode prev = new TreeNode(inList.get(index -1));
               prev.right = current;
           }
      }
      return root;
     }
