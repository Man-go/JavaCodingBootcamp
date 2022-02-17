package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListHelper {

    public static <T> ListNode<T> findFirst(ListNode<T> someNode) {
        if (someNode.getPrev() == null) {
            return someNode;
        }
        ListNode<T> result = someNode.getPrev();
        while (result != null) {
            result = result.getPrev();
        }

        return result;
    }

    public static <T> ListNode<T> findLast(ListNode<T> someNode) {
        if (someNode.getNext() == null) {
            return someNode;
        }
        ListNode<T> result = someNode;
        while (result.getNext() != null) {
            result = result.getNext();
        }
        return result;
    }

    public static <T> int length(ListNode<T> someNode) {
        if (someNode == null) {
            int counter = 0;
        }
        if (someNode.getNext() == null && someNode.getPrev() == null) {
            return 1;
        }
        ListNode<T> left = someNode.getPrev();
        ListNode<T> right = someNode.getNext();
        int counter = 0;
        while (left != null) {
            counter++;
            left = left.getPrev();
        }
        while (right != null) {
            counter++;
            right = right.getNext();
        }
        return counter + 1;
    }

//    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
//
//        if (someNode == null) {
//            throw new NullPointerException();
//        }
//        ListNode<T> prev = someNode.getPrev();
//        ListNode<T> next = someNode.getNext();
//        ListNode<T> newEndNode = new ListNode<T>(null, null, newValue);
//        //Singleton Node
//        if (prev == null && next == null) {
//            someNode.setNext(newEndNode);
//            newEndNode.setPrev(someNode);
//            return newEndNode;
//        }
//        if (next != null) {
//            //else not End Node iteration of ListNode
//            while (next.getNext() != null) {
//                //Search link for the First Node
//                next = next.getNext();
//            }
//        }
//        if (next == null) {
//            next = someNode;
//        }
//        next.setNext(newEndNode);
//        newEndNode.setPrev(next);
//        return newEndNode;
//    }

    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
        if (someNode == null) {
            throw new NullPointerException();
        }
        ListNode<T> lastElement = findLast(someNode);
        ListNode<T> node = new ListNode<>(lastElement, null, newValue);
        if (lastElement != null) {
            lastElement.setNext(node);
        }
        return node;
    }
}
