import java.io.*;
import java.util.*;

class UserAddSub {

    public int AddSub(int input1, int input2) {
        int N = input1;
        int opt = input2;

        int result = N;
        boolean add;

        if (opt == 1) {
            add = false; // first op after N is subtract
        } else {
            add = true;  // first op after N is add
        }

        for (int i = N - 1; i >= 1; i--) {
            if (add) {
                result += i;
            } else {
                result -= i;
            }
            add = !add; // toggle
        }

        return result;
    }

    public static void main(String[] args) {
        UserAddSub obj = new UserAddSub();

        System.out.println(obj.AddSub(6, 1)); // Example1 → 3
        System.out.println(obj.AddSub(6, 2)); // Example2 → 9
    }
}

