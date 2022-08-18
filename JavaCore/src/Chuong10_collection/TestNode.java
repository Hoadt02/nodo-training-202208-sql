package Chuong10_collection;

public class TestNode {
    private static void test(Node<?> node){
        while(node != null){
            System.out.println("value is " + node.getValue() + "''");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        example2();
    }

    private static void example2() {
        Node<Integer> root2;
        root2 = new Node<>(99,
                    new Node<>(23,
                        new Node<>(11)));
        test(root2);
    }

    private static void example1() {
        Node<String> root = new Node<>("Step 1");
        Node<String> node1 = new Node<>("Step 2");
        root.next = node1;

        test(root);
    }
}
