package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.List;

public class ListHelperRun {
    public static void main(String[] args) {
        ListNode<String> listNode = new ListNode<>(null, null, "1");
        System.out.println(listNode.toString());

        System.out.println(ListHelper.length(listNode));

        ListHelper.addToEnd(listNode, "7");
        ListHelper.length(listNode, null);

        System.out.println(ListHelper.length(listNode));

    }
}
