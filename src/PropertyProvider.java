import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {
    public static final Properties PROPS;

    static {
        PROPS = new Properties();
        try{
            PROPS.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
