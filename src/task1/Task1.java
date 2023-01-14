package task1;

import java.util.LinkedList;

public class Task1 {

    public static void main(String[] args) {

        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            LinkedList<Integer> list = new LinkedList<>();
            list.addFirst(1);
            while (true){
                System.out.print(list.getLast());
                for (int i = 0; i < m-1; i++){
                    if (list.getLast() < n){
                        list.addLast(list.getLast()+1);
                    } else {
                        list.addLast(list.getFirst());
                    }
                }
                if (list.getFirst().equals(list.getLast()))
                    break;
                list.addLast(list.getLast());
            }

            list.clear();
        } catch (Exception e){
            e.printStackTrace();
        }


    }

}
