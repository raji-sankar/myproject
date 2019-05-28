package clr;


/**
 *
 * Rabin-Karp algorithm for substring match
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints
 * all occurrences of pat[] in txt[]. You may assume that n > m.
 * Examples:
 *
 * Input:  txt[] = "THIS IS A TEST TEXT"
 *         pat[] = "TEST"
 * Output: Pattern found at index 10
 *
 * Input:  txt[] =  "AABAACAADAABAABA"
 *         pat[] =  "AABA"
 * Output: Pattern found at index 0
 *         Pattern found at index 9
 *         Pattern found at index 12
 */

public class PatternMatch {

    public final static int d = 256;

    public static void search(String text, String pattern, int q){
        int startIndex = -1;
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();
        int p = 0;
        int t = 0;
        int h = 1;
        int m = pat.length;
        int n = txt.length;
        int j = 0;

        for (int i = 0; i < m-1; i++)
            h = (h*d)%q;

        System.out.println("h = " + h);

        // Calculate the hash value of pattern and first
        // window of text
        for (int i = 0; i < m; i++) {
            p = (d*p + pattern.charAt(i))%q;
            t = (d*t + text.charAt(i))%q;
        }
        System.out.println("p = " + p);
        System.out.println("t = " + t);

        for(int i=0; i <= (n - m); i++ ){
            if (p == t){
                for(j=0; j < m; j++){
                    if(text.charAt(i+j) != pattern.charAt(j)){
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }
            if ( i < n-m ) {
                t = (d*(t - text.charAt(i)*h) + text.charAt(i+m))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
                System.out.println("t = " + t);
            }
        }


    }

    public static int calculateHash(char[] chars, int mod){
        int hash = 0;

        for(int i=0; i < chars.length; i++){
            hash += Math.pow(31, chars.length -i -1) * chars[i];
        }
        return hash % mod;
    }

    public static void main(String[] args) {
        search("THIS IS A TEST TEXT", "TEST", 101);
    }
}
