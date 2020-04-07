import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Deque<Integer> que = new LinkedList<Integer>();
        List<Integer> tempArray = new ArrayList<Integer>();
        int subArraySize = 0;
        int uniqueSize = 0;

        //User input
        try
        {
            System.out.println("Number of integer in the set");
            int intNumber = in.nextInt();

            System.out.println("Size of the subArray to consider");
            subArraySize = in.nextInt();

            for(int i = 0; i < intNumber; i++){
                int seq = i + 1;
                System.out.println("enter number " + seq);
                while (!in.hasNextInt()){
                    System.out.println("enter a number for " + seq + " !");
                    in.next();
                }
                que.add(in.nextInt());
            }
        }catch(Exception e)
        {
            System.out.println("Issues with user input");
        }

        //
        try
        {
            while(que.peekFirst() != null)
            {
                //add the subArraySize to an Array and remove them from the Deque
                for(int q=0; q < subArraySize; q++)
                {
                    int add4rm = que.getFirst();
                    tempArray.add(add4rm);
                    que.removeFirst();
                }

                //Find the unique elements and add them to a HashMap
                HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
                for (int i = 0; i < tempArray.size(); i++) {
                    hm.put(tempArray.get(i), i);
                }

                //Find the highest element and assign it to uniqueSize
                if(uniqueSize < hm.size())
                {
                    uniqueSize = hm.size();
                }
                tempArray.clear();
            }

        }catch (Exception e)
        {
            System.out.println("Issues running elements in the que (Remainder elements)");
        }

        System.out.println("");
        System.out.println(uniqueSize);
    }

}
