package Date;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class NotePanel extends JPanel {
    private final JLabel c;
    private final GregorianCalendar calendar;
    private final TreeMap<String, ArrayList<String>> myMap;

    public  NotePanel(TreeMap<String, ArrayList<String>> myMap){
        setLayout(new BorderLayout());
        this.myMap = myMap;
        calendar = new GregorianCalendar();
        JLabel l = new JLabel("Today");
        l.setFont(new Font("Arial",Font.PLAIN,24));
        add(l,BorderLayout.NORTH);
        c = new JLabel("No Event");
        c.setFont(new Font("Arial",Font.PLAIN,18));
        add(c,BorderLayout.CENTER);
        currentEvent();
        Timer timer = new Timer(1000, e -> currentEvent());
        timer.start();
    }
    public void currentEvent() {
        StringBuilder key = new StringBuilder();
        Set<String> keys = myMap.keySet();
        Iterator<String> iterator = keys.iterator();
        int count = 0;
        if (keys.size() == 0) {
            c.setText("No Events");
        }
        while (iterator.hasNext()) {
            key.append(iterator.next());
            if (key.toString().equals(calendar.get(Calendar.YEAR) + " 0" + (calendar.get(Calendar.MONTH) + 1) + " 0" + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " 0" + (calendar.get(Calendar.MONTH) + 1) + " " + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + " 0" + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + " " + calendar.get(Calendar.DAY_OF_MONTH))) {
            count = myMap.get(key.toString()).size();
            }
            key.setLength(0);
        }
        if(count == 1){
         c.setText("You have one event for today");
        }
        else if(count > 1){
        c.setText("You have " + count + " events for today");
        }
    }
}
