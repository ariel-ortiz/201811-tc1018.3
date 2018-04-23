package mx.itesm.cem.arboles;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeSet<E extends Comparable<E>>
        extends AbstractSet<E> {

    private static class Node<E> {
        private E data;
        private Node<E> izq;
        private Node<E> der;

        public Node(E data, Node<E> izq, Node<E> der) {
            this.data = data;
            this.izq = izq;
            this.der = der;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    private Node<E> root = null;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<E> preOrderList() {
        List<E> result = new LinkedList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node<E> p, List<E> result) {
        if (p != null) {
            result.add(p.data);
            preOrder(p.izq, result);
            preOrder(p.der, result);
        }
    }

    public List<E> inOrderList() {
        List<E> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node<E> p, List<E> result) {
        if (p != null) {
            inOrder(p.izq, result);
            result.add(p.data);
            inOrder(p.der, result);
        }
    }

    public List<E> postOrderList() {
        List<E> result = new LinkedList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node<E> p, List<E> result) {
        if (p != null) {
            postOrder(p.izq, result);
            postOrder(p.der, result);
            result.add(p.data);
        }
    }

    public List<E> levelOrderList() {
        List<E> result = new LinkedList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> p = queue.poll();
            if (p != null) {
                queue.offer(p.izq);
                queue.offer(p.der);
                result.add(p.data);
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            Node<E> p = root;
            while (true) {
                if (element.compareTo(p.data) == 0) {
                    return false;
                } else if (element.compareTo(p.data) < 0) {
                    if (p.izq == null) {
                        p.izq = new Node<>(element);
                        size++;
                        return true;
                    } else {
                        p = p.izq;
                    }
                } else { // element > p.data
                    if (p.der == null) {
                        p.der = new Node<>(element);
                        size++;
                        return true;
                    } else {
                        p = p.der;
                    }
                }
            }
        }
    }

    public E max() {
        if (root == null) {
            return null;
        } else {
            return max(root);
        }
    }

    private boolean isLeaf(Node<E> p) {
        return p != null && p.izq == null && p.der == null;
    }

    private E max(Node<E> p) {
        if (isLeaf(p)) {
            return p.data;
        } else {
            E maxIzq = null, maxDer = null;
            E maxChild = null;
            if (p.izq != null) {
                maxIzq = max(p.izq);
            }
            if (p.der != null) {
                maxDer = max(p.der);
            }
            if (maxIzq != null & maxDer != null) {
                if (maxIzq.compareTo(maxDer) >= 0) {
                    maxChild = maxIzq;
                } else {
                    maxChild = maxDer;
                }
            } else {
                if (maxIzq != null) {
                    maxChild = maxIzq;
                } else {
                    maxChild = maxDer;
                }
            }
            if (p.data.compareTo(maxChild) >= 0) {
                return p.data;
            } else {
                return maxChild;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeSet<Integer> tree = new BinarySearchTreeSet<>();
        tree.addAll(Arrays.asList(7, 15, 10, 5, 2, 6, 0, 18,
                12, 3, 9, 14));
        System.out.println(tree.preOrderList());
        System.out.println(tree.inOrderList());
        System.out.println(tree.postOrderList());
        System.out.println(tree.levelOrderList());
        System.out.println(tree.max());
    }
}
