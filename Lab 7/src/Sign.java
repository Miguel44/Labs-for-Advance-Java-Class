public class Sign implements GameThing, Readable, Edible
{
    public String getName()
    {
        return "A chocolate sign";
    }
    public String getDescription()
    {
        return "This is a small sweet chocolate sign. There seems to be some partially faded writing in it.";
    }
    public void read()
    {
          System.out.println("You can see the following message: \"John was here!\"");
    }
    public void eat()
    {
        System.out.println(" The sign doesn't taste like chocolate. It taste like wood.");
        AdventureEpsilon.theRoom.removeThing(AdventureEpsilon.theSign);
    }
}
