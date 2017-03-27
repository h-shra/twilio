package sdk;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.IncomingPhoneNumber;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class ProgrammableSMS {

    public static final String ACCOUNT_SID = "AC90e27fb8d0175c79d6395820e5613cbe";
    public static final String AUTH_TOKEN = "d5e2b138b507694b0e2410fa27636118";
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

    public static void main(String[] args) throws TwilioRestException {

        ProgrammableSMS smsService = new ProgrammableSMS();

        String from = "8008008000";
        String to = "9009009000";
        String text = "hi.";

        //https://www.twilio.com/docs/api/rest/sending-messages
        Message sentSms = smsService.sendSmsUsingTwilioRest(from, to, text);
        System.out.println(sentSms.getSid());
    }

    private Message sendSmsUsingTwilioRest(String from, String to, String text) {
        // Build the parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("From", from));
        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("Body", text));

        MessageFactory messageFactory = this.client.getAccount().getMessageFactory();
        Message message = null;
        try {
            message = messageFactory.create(params);//endpoint : https://api.twilio.com

        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
        return message;
    }

    private void senSmsUsingTwilio(String from, String to, String text) {

       // IncomingPhoneNumber incomingPhoneNumber = this.client.getAccount().getIncomingPhoneNumber(ACCOUNT_SID);
    }


}