import java.util.ArrayList;

public class Airport {
    ArrayList<Plane> storage = new ArrayList<Plane>();
    Weather weather = new Weather();

    public String land(Plane plane){
        if (weather.isSunny()){
        storage.add(plane);
        return "Plane has landed";}
        else {
            return "Plane can't land";
        }
    }

    public String takeOff(Plane plane){
        if (weather.isSunny()) {
            storage.remove(plane);
            return "Plane has taken off!";
        } else {
            return "Plane can't take off";
        }
    }




}
