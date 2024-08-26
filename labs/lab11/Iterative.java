public class Iterative {

    public static BitList complement(BitList in) {
        String btlStr = "";
        try {
            while (true) {
                int bite = (in.removeFirst() + 1) % 2;
                btlStr = bite + btlStr;
            }
        } catch (Exception e) {
            if (btlStr == "") {
                throw new IllegalArgumentException();
            }
            return new BitList(btlStr);
        }

    }

    public static BitList or(BitList a, BitList b) {
        String btlStr = "";
        try {
            while (true) {
                int biteA = a.removeFirst();
                int biteB = b.removeFirst();
                if (biteA == 1 || biteB == 1) {
                    btlStr = 1 + btlStr;
                } else {
                    btlStr = 0 + btlStr;
                }
            }
        } catch (Exception e) {
            int bTest = 3;
            try {
                bTest = b.removeFirst();
            } catch (Exception exc) {
            }
            if (btlStr == "" || bTest != 3) {
                throw new IllegalArgumentException();
            }
            return new BitList(btlStr);
        }
    }

    public static BitList and(BitList a, BitList b) {
        String btlStr = "";
        try {
            while (true) {
                int biteA = a.removeFirst();
                int biteB = b.removeFirst();
                btlStr = biteA * biteB + btlStr;
            }
        } catch (Exception e) {
            int bTest = 3;
            try {
                bTest = b.removeFirst();
            } catch (Exception exc) {
            }
            if (btlStr == "" || bTest != 3) {
                throw new IllegalArgumentException();
            }
            return new BitList(btlStr);
        }
    }

    public static BitList xor(BitList a, BitList b) {

        String btlStr = "";
        try {
            while (true) {
                int biteA = a.removeFirst();
                int biteB = b.removeFirst();
                btlStr = (biteA + biteB) % 2 + btlStr;
            }
        } catch (Exception e) {
            int bTest = 3;
            try {
                bTest = b.removeFirst();
            } catch (Exception exc) {
            }
            if (btlStr == "" || bTest != 3) {
                throw new IllegalArgumentException();
            }
            return new BitList(btlStr);
        }
    }
}