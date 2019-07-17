package get.delivery.receipt;
import static spark.Spark.*;
import com.cedarsoftware.util.io.JsonWriter;

public class App {

    public static void main(String[] args) throws Exception {
        port(3000);

        get("/webhooks/delivery-receipt", (req, res) -> {
            System.out.println("DLR received via GET");
            for (String param : req.queryParams()) {
                System.out.printf("%s: %s\n", param, req.queryParams(param));
            }
            res.status(204);
            return "";
        });

        post("/webhooks/delivery-receipt", (req, res) -> {
            if (req.contentType().startsWith("application/x-www-form-urlencoded")) {
                System.out.println("DLR received via POST");
                for (String param : req.queryParams()) {
                    System.out.printf("%s: %s\n", param, req.queryParams(param));
                }
            } else {
                System.out.println("DLR received via POST-JSON");
                String prettyJson = JsonWriter.formatJson(req.body());
                System.out.println(prettyJson);
            }

            res.status(204);
            return "";
        });
    }
}