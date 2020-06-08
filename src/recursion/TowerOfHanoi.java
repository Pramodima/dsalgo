package recursion;
//http://javabypatel.blogspot.com/2015/12/tower-of-hanoi.html

public class TowerOfHanoi {

    public void moveDisks(int n, String start, String auxiliary, String end) {
        if (n == 1) {

            // When n==1, it means we are left with only one disk, so directly move it from source to destination.
            System.out.println(start + " -> " + end);

        } else {

            // Move (n-1 disk) from Source Peg to Auxiliary Peg
            moveDisks(n - 1, start, end, auxiliary);

            //Move last nth disk to Destination Peg.
            System.out.println(start + " -> " + end);

            //Move (n-1 disk) from Auxiliary Peg to Destination Peg.
            moveDisks(n - 1, auxiliary, start, end);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.moveDisks(3, "source peg", "helper peg", "destination peg");
    }
}
