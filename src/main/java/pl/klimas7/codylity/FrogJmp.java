package pl.klimas7.codylity;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        int dif = Y - X;
        if (dif == D) {
            return 0;
        }
        if (dif % D == 0) {
            return dif/D;
        }
        else
            return dif/D + 1;
    }
}
