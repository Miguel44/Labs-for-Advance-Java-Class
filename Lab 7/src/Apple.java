public class Apple implements GameThing, Edible {
    public String getName(){
        return "A shiny and healthy apple.";        
    }
    public String getDescription(){
        return "A bigger apple that usual, but it appears to be healthy.";
    }
    public void eat(){
        System.out.println("The apple tasted really sweet.");
        AdventureEpsilon.theRoom.removeThing(AdventureEpsilon.theApple);
    }
}
