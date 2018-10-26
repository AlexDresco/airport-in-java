import java.util.Random;


class Weather {

        String[] states = {"Sunny", "Rainy", "Cloudy"};
        Random random = new Random();
        int index = random.nextInt(states.length);
        String state = states[index];

    public boolean isSunny(){
        return state.equals("Sunny");
    }
}
