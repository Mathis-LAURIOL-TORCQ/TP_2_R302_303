//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SinglyListClass list = new SinglyListClass();

        System.out.println("isEmpty: " + list.isEmpty());   // true
        System.out.println("size:    " + list.size());      // 0

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);
        // list: 1 -> 2 -> 3 -> 4 -> 5

        System.out.println("isEmpty: " + list.isEmpty());   // false
        System.out.println("size:    " + list.size());      // 5
        System.out.println("first:       " + list.first());         // 1
        System.out.println("penultimate: " + list.penultimate());   // 4
        System.out.println("last:        " + list.last());          // 5

        Integer removed = list.removeFirst();
        System.out.println("removed: " + removed);          // 1
        System.out.println("first:   " + list.first());     // 2
        System.out.println("size:    " + list.size());      // 4

        System.out.println(list.toString());
    }
}