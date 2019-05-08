package utils;

public class Pair<A, B> {
    private A x;
    private B y;

    public Pair(A x, B y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        int hashx = x != null ? x.hashCode() : 0;
        int hashy = y != null ? y.hashCode() : 0;

        return (hashx + hashy) * hashy + hashx;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair<?, ?> otherPair = (Pair<?, ?>) other;
            return 
            ((  this.x == otherPair.x ||
                ( this.x != null && otherPair.x != null &&
                  this.x.equals(otherPair.x))) &&
             (  this.y == otherPair.y ||
                ( this.y != null && otherPair.y != null &&
                  this.y.equals(otherPair.y))) );
        }

        return false;
    }

    public String toString()
    { 
           return "(" + x + ", " + y + ")"; 
    }

    public A getx() {
        return x;
    }

    public void setx(A x) {
        this.x = x;
    }

    public B gety() {
        return y;
    }

    public void sety(B y) {
        this.y = y;
    }
}