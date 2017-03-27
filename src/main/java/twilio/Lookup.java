package twilio;
import com.twilio.Twilio;
import com.twilio.rest.lookups.v1.PhoneNumber;

public class Lookup {
    public static final String ACCOUNT_SID = "AC90e27fb8d0175c79d6395820e5613cbe";
    public static final String AUTH_TOKEN = "d5e2b138b507694b0e2410fa27636118";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        //https://www.twilio.com/docs/api/lookups
        PhoneNumber number = PhoneNumber
                .fetcher(new com.twilio.type.PhoneNumber("+15108675309"))
                .setType("carrier")
                .fetch();

        System.out.println(number.getCarrier().get("name"));
        System.out.println(number.getCarrier().get("type"));
    }
}
