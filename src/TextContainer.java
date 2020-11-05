import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "file.txt")
public class TextContainer {
    private String text = "text";

    @Saver
    public void save(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
