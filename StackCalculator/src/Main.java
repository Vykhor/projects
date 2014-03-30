/**
 * Created by VVykhor on 24.03.2014.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Start");
            Processor p = new Processor();
            p.setFile("source.txt");
            p.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
