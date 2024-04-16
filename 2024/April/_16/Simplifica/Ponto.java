package April._16.Simplifica;
/**
 *
 * @author Marcelo Cohen
 */
public class Ponto {
    public double x;
    public double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public double distancia(Ponto outro) {
        return Math.sqrt(Math.pow(x-outro.x,2)+Math.pow(y-outro.y,2));
    }

}
