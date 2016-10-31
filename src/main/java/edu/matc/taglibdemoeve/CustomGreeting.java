package edu.matc.taglibdemoeve;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by student on 10/26/16.
 */
public class CustomGreeting extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println(this.createMessage());
    }

    public String createMessage() {
        String halloweenMessage = "";
        String message = "";

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(c.getTime());

        if (date.equals("2016/10/31")) {

            halloweenMessage = "Happy Halloween";
        }

        if(timeOfDay >= 0 && timeOfDay < 12){
            message = "Good Morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            message = "Good Afternoon";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            message = "Good Evening";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            message = "Good Night";
        }

        if (!halloweenMessage.equals("")) {
            message = message + " " + halloweenMessage;
        }

        return message;
    }
}
