import model.AirCompany;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        Runnable initFrame = new initFrame();
        SwingUtilities.invokeAndWait(initFrame);
    }


    public static class initFrame implements Runnable{
        @Override
        public void run() {
            AirCompany airCompany = AircompanyFactory.createAirCompany();
            new ApplicationFrame(airCompany);
        }
    }

}
