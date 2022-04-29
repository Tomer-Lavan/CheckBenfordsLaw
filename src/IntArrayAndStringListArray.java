import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class IntArrayAndStringListArray {
    public double[] intArr;
    public Set<String> stringArrLst[];

    IntArrayAndStringListArray(double[] a, Set<String> b[] ) {
        intArr = a;
        stringArrLst = b;
    }

    public String[][] transferToArrays() {
        String[][] ans = new String[9][];
        for(int i = 0; i< 9;i++) {
            String[] curArr = new String[this.stringArrLst[i].size()];
            Iterator iter = this.stringArrLst[i].iterator();
            int j = 0;
            while (iter.hasNext()) {
                curArr[j] = (String) iter.next();
                j++;
            }
            ans[i] = curArr;
        }
        return ans;
    }

    public void printStrList(int num) {
        Iterator iter = this.stringArrLst[num].iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
