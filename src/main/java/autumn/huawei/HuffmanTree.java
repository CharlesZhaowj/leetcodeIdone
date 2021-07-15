package autumn.huawei;

import java.util.*;


/*
import java.util.HashMap;
import java.util.Scanner;

class HuffNode {
    HuffNode left;
    HuffNode right;
    String currentvalue;
    int weight;


}

public class JianYiMiMaJi {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] ascii = new int[120];
        int hufftime = 0;
        for(int i = 0; i < s.length(); i++) {

        }
    }
}
*/

/*
        list.add(new Node("d",4));
        list.add(new Node("c",3));
        list.add(new Node("b",2));
        list.add(new Node("a",1));
        */

/**
 * abbcccdddd
 */
class Node implements Comparable<Node>{
    String data;
    int weigth;
    Node left;
    Node right;

    public Node(String data, int weigth) {
        this.data = data;
        this.weigth = weigth;
        left = null;
        right = null;
    }

    public int compareTo(Node node) {
        if(node.weigth>weigth)
            return 1;
        if(node.weigth<weigth)
            return -1;
        else {
            int cnt1 = 0;
            int cnt2 = 0;
            if(node.left != null) cnt1++;
            if(node.right != null) cnt1++;
            if(this.left != null) cnt2++;
            if(this.right != null) cnt2++;
            if(cnt1 > cnt2){
                return 1;
            } else if(cnt1 < cnt2) {
                return -1;
            } else {
                return 0;
            }
        }

    }
}

public class HuffmanTree {
    private void createTree(List<Node> list){
        while(list.size()>1){
            Collections.sort(list);
            Node left = list.get(list.size()-1);
            Node right = list.get(list.size()-2);
            Node parent = new Node(null,left.weigth +right.weigth);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
    }

    public static void huffman(Node root,String code,Map map){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            map.put(root.data, code);
            return;
        }
        code+="0";
        huffman(root.left,code,map);
        code=code.substring(0, code.length()-1);
        code+="1";
        huffman(root.right,code,map);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] chars = new int[256];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = 0;
        }
        for(int i = 0; i < line.length(); i++) {
            chars[line.charAt(i)]++;
        }
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] > 0) {
                list.add(new Node(""+(char)i, chars[i]));
            }
        }
        HuffmanTree tree =new HuffmanTree();
        tree.createTree(list);
        Node root = list.get(0);
        String code="";
        Map map=new HashMap();
        huffman(root, code, map);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < line.length(); i++) {
            sb.append(map.get(""+line.charAt(i)));
        }
        System.out.println(sb.toString());
    }
}


