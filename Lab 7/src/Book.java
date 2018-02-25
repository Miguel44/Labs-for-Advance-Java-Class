public class Book implements GameThing, Readable, Openable {
    public boolean isOpen = false; 
     public String getName()
     {
           return "A dusty old book";
     }
     public String getDescription()
     {
         if(!isOpen){
           return "This book appears to be old,dusty and closed. It's also quite heavy.";
           }
         if(isOpen){
             return "This book appears to be old and dusty. It's also open and with something inside.";
         }
         return null;
     }
     public void read()
     { 
         if(!isOpen){
             System.out.println("There is a symbol on the cover and the book is closed");
     }
         if(isOpen){
          System.out.println("It has strange unreadable words inside.");
         }
     }
     public void open()
     {
         if(!isOpen){
             System.out.println("The book opens and a cloud of dust disperse all over the room.");
             isOpen = true;
         }else{
             System.out.println("The book is already open.");
         }        
     }
     public void close()
     {
         if(isOpen){
             System.out.println("The book is closed.");
             isOpen = false;
         }else{
             System.out.println("The book is already closed.");
         }
     }
}
