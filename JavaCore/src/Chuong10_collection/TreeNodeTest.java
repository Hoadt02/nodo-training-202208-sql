package Chuong10_collection;

import java.util.List;

public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("0");

        TreeNode<String> node1 = new TreeNode<>("1.0");
        TreeNode<String> node1_1 = new TreeNode<>("1.1");
        TreeNode<String> node1_2 = new TreeNode<>("1.2");
        TreeNode<String> node1_3 = new TreeNode<>("1.3");
        root.addChild(node1);
        root.addChild(node1_1);
        root.addChild(node1_2);
        root.addChild(node1_3);

        TreeNode<String> node2 = node1.getNextSibling();
        System.out.println("Next sibling of " + node1.getValue() + " is " + node2.getValue());

       node2.addChild("2.0.0");
       node2.addChild("2.1.0");
       node2.addChild("2.1.1");

        TreeNode<String> node3 = node2.getNextSibling();
        System.out.println("Next sibling of " + node2.getValue() + " is " + node3.getValue());

        System.out.println("check contains 2.1.1 = " + TreeNodeUtils.contains(root,"2.1.1"));

        List<String> list = root.chonLoc(value -> {
            return value.contains(".0");
        });

        System.out.println("Co tong so " + list.size() + " chua '.0.'");
        list.forEach(value ->
                        System.out.println("phan tu loc ====> " + value));
    }
}
