import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Location forest = new Location("Jesteś w lesie.", "las");
        Location cave = new Location("Jesteś w jaskini", "jaskinia");
        Location dragon = new Location("Przed Toba smok", "drzwi do skarbca");
        Location death = new Location("Smok zionie ogniem, prosto na Ciebie.", "walka");
        Location run = new Location("Uciekasz przed smokiem, za Tobą morze ognia, ale udaje Ci się uciec.", "ucieczka");
        Location city = new Location("Jesteś w mieście", "miasto");
        Location shop = new Location("Sklep z bronią białą", "sklep");
        forest.addLocation(cave);
        forest.addLocation(city);
        cave.addLocation(forest);
        cave.addLocation(dragon);
        dragon.addLocation(death);
        dragon.addLocation(run);
        city.addLocation(forest);
        city.addLocation(shop);
        shop.addLocation(city);
        Location currentLocation = forest;
        while (true){
            currentLocation.info();
            if(currentLocation.canGoToNewLocation()){
                currentLocation.showChoice();
                Scanner scanner = new Scanner(System.in);
                int index = 0;
                try{index = scanner.nextInt();
                    currentLocation.goToLocation(index);
                }catch (Exception e){
                    System.out.println(e);
                }
            }else {
                System.out.println("koniec gry");
                break;
            }

        }

    }
}