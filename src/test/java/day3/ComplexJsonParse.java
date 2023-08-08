package day3;

import io.restassured.path.json.JsonPath;
import files.Payload;
public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath js= new JsonPath(Payload.courceprice());

        int size=js.getInt("courses.size()");

        System.out.println(size);

        int pamount=js.getInt("dashboard.purchaseAmount");

        System.out.println(pamount);

        String title=js.get("courses[0].title");
        System.out.println(title);

        for (int i=0;i<size;i++){

            String title1=js.get("courses["+i+"].title");
            System.out.println(title1);

        }
    }
}
