package files;

public class Payload {

    public static String courceprice() {

        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}\n" +
                "]\n" +
                "}";
    }

    public static String createbooking(String Fname , String Lname , Integer Tprice, boolean Dpaid, String chekindate, String checkoutdate, String aneeds)
    {
        String payload="{\n" +
                "    \"firstname\" : \""+Fname+"\",\n" +
                "    \"lastname\" : \""+Lname+"\",\n" +
                "    \"totalprice\" : "+Tprice+",\n" +
                "    \"depositpaid\" : "+Dpaid+",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \""+chekindate+"\",\n" +
                "        \"checkout\" : \""+checkoutdate+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \""+aneeds+"\"\n" +
                "}";
        return payload;
    }
}
