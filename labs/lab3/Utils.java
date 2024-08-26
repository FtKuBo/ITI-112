public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     * 
     * @author Mehdi Semmar
     * @param in   an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of
     *         words
     *         found in 'what' have been replaced by the corresponding word from
     *         'with'.
     */

    public static String[] findAndReplace(String[] in, String[] what, String[] with) {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if the pre-conditions are satistified

        // Testing pre-conditions
        // testing if any of the array is null
        if (in == null || what == null || with == null) {
            valid = false;
        }
        // if non of the array is null we check if the components of the array are null
        else {
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null) {
                    valid = false;
                }
            }
            for (int i = 0; i < what.length; i++) {
                if (what[i] == null) {
                    valid = false;
                }
            }
            for (int i = 0; i < with.length; i++) {
                if (with[i] == null) {
                    valid = false;
                }
            }
            // we check if the length of the query and the replacements are the same
            // the valid condition is here to make sure to not overwrite a not respected
            // condition
            valid = what.length == with.length && valid;
        }

        if (valid) {
            out = new String[in.length];
            // we go throught the what array and if we find a match with the in array
            // we do the changes with the with array at the same pos
            for (int i = 0; i < what.length; i++) {
                for (int y = 0; y < in.length; y++) {
                    if (in[y].equals(what[i]) && out[y] == null) {
                        out[y] = with[i];
                    }
                }
            }
            // if there are some components that didn't get replaced we just put the in
            // component at that index
            for (int i = 0; i < out.length; i++) {
                if (out[i] == null) {
                    out[i] = in[i];
                }
            }
        }
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.
        return out;
    }
}