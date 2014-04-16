import org.apache.log4j.*;
/**
 * Created by VVykhor on 24.03.2014.
 */
public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BasicConfigurator.configure();
            logger.debug("Start");
            Processor p = new Processor();
            p.setFile("source.txt");
            p.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
