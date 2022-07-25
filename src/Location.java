import java.util.Arrays;

public class Location {
    private String description = "";
    private String shortInfo = "";
    private Location[] locations = new Location[0];

    public Location(String description, String shortInfo) {
        this.description = description;
        this.shortInfo = shortInfo;
    }
    public void addLocation(Location location) {
        Location[] arr2 = Arrays.copyOf(locations, locations.length +1);
        arr2[locations.length] = location;
        this.locations=arr2;

    }
    public void info() {
        System.out.println("info "+description);
    }

    public void showChoice() {
        System.out.println("możesz udać się do: ");
        int index = 1;
        while (index <= locations.length) {
            if (index == locations.length){
                goToLocation(index);
                System.out.println(index +" "+ shortInfo);
                index++;
            }else {
                System.out.println("nie można przejść do lokacji "+index);
            }
        }
    }

    public Location goToLocation(int index) {
        try{if (index > 0 && index<locations.length){
            return locations[index-1];
        }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e +"\n nie można przejść do lokacji nr: "+index);
        }
        return null;
    }
    public boolean canGoToNewLocation(){
        if(locations.length > 0){
            return true;
        }else {
            return false;
        }
    }
}