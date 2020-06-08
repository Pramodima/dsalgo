package greedyAndInvariant;

import java.util.ArrayList;
import java.util.List;
//Boyer-Moorie method
//This method will only work  if majority element will exceed > n/2 in size means more than half.
public class MajorityElementInASequence {

    public static String getMajorityElements(List<String> sequence){
        int count=0;
        String active="";
        for(String var:sequence){
            if(count==0) {
                active = var;
                ++count;
            }
          else  if(var.equals(active))
              ++count;

          else if(!var.equals(active))
              --count;

        }
return active;
            }

    public static void main(String[] args) {
        List<String> sequence=new ArrayList<>();
        sequence.add("b");sequence.add("a");sequence.add("c");sequence.add("a");sequence.add("a");sequence.add("b");sequence.add("a");sequence.add("a");sequence.add("c");sequence.add("a");
        System.out.println(MajorityElementInASequence.getMajorityElements(sequence));
    }
}
   // Since we spend 0(1) time per entry, the time complexity is0(n). The additional space
  //   complexity is0(1).