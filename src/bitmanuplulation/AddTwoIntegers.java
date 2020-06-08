package bitmanuplulation;
//https://medium.com/swlh/algorithm-tool-kit-bit-manipulation-9e41391af90d
public class AddTwoIntegers {

        static int Add(int x, int y)
        {
            // Iterate till there is no carry
            while (y != 0)
            {
                // carry now contains common
                // set bits of x and y
                int carry = x & y;

                // Sum of bits of x and
                // y where at least one
                // of the bits is not set
                x = x ^ y;

                // Carry is shifted by
                // one so that adding it
                // to x gives the required sum
                if(carry==0)
                    break;
                y = carry << 1;
            }
            return x;
        }

        // Driver code
        public static void main(String arg[])
        {
            System.out.println(Add(40, 98));
        }
    }

