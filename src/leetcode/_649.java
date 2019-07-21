package leetcode;

public class _649 {

    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        int r = 0, d = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(c == 'R') {
                if(++r > 0) {
                    d--;
                    sb.append(c);
                    r = 0;
                }
            } else {
                if(++d > 0) {
                    r--;
                    sb.append(c);
                    d = 0;
                }
            }
        }
        if(r < 0) {
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == 'R') {
                    sb.deleteCharAt(i--);
                    if(++r == 0)
                        break;;
                }
            }
        }
        if(d < 0) {
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == 'D') {
                    sb.deleteCharAt(i--);
                    if(++d == 0)
                        break;;
                }
            }
        }
        if(r == d) return predictPartyVictory(sb.toString());
        return r < d ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        _649 test = new _649();
        System.out.println(test.predictPartyVictory("RD"));
        System.out.println(test.predictPartyVictory("RRDDD"));
        System.out.println(test.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
