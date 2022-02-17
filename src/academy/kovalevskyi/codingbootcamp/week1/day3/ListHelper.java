package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListHelper {

    public static <T> ListNode<T> findFirst(ListNode<T> someNode) {
        ListNode<T> result = someNode;
        while (result.getPrev() != null) {
            result = result.getPrev();
        }
        return result;
    }

    public static <T> ListNode<T> findLast(ListNode<T> someNode) {
        ListNode<T> result = someNode;
        while (result.getNext() != null) {
            result = result.getNext();
        }
        return result;
    }

    public static <T> int length(ListNode<T> someNode) {
        if (someNode == null) {
            return 0;
        }

        int counter = 1;
        ListNode<T> firstListNode = findFirst(someNode);

        while (firstListNode.getNext() != null) {
            firstListNode = firstListNode.getNext();
            counter++;
        }
        return counter;
    }

    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
        if (someNode == null) {
            return new ListNode<>(null, null, newValue);
        }

        ListNode<T> lastElement = findLast(someNode);
        ListNode<T> node = new ListNode<>(lastElement, null, newValue);
        lastElement.setNext(node);
        return node;
    }
}
