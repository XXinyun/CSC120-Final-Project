import java.util.Scanner;
import java.util.ArrayList;

/** Human class */
public class Human{

    int steps;
    String name;
    int xCoord;
    int yCoord;
    Bag myBag;
    Room myMap;
    

    /** Constructor */
    public Human(String name){
        this.name = name;
        this.xCoord = 0;
        this.yCoord = 0;
        this.steps = 5;
        myBag = new Bag(steps);
        myMap = new Room();
        this.myMap.addMap(this.xCoord,this.yCoord);
    }


    /**
     * method for grabbing an item and will add if you don't have it already
     * @param item the item you want to grab to add into the array
     */
    public void grab(String item){
        if(myBag.items.contains(item)){
            System.out.println("\n* You already have the " + item + ". *\n");
        } else{
            myBag.items.add(item);
            System.out.println("\n" + myBag.items);
        }
       
    }

    /**
     * method for dropping an item
     * @param item the item you want to drop
     * @return item the item removed from the list
     */
    public String drop(String item){
        
        if(myBag.items.contains(item)){
            myBag.items.remove(item);
            System.out.println("\n* You dropped "+ item + ". *\n");
        } else{
            System.out.println("\n* You don't have " + item + ". \nYou have missed a chance grabbing this item. *\n");
        }
        
        return item;
    }

    /**
     * method for examinig if you have the item
     * @param item the item you want to examine
     */
    public void examine(String item){

        if (myBag.items.contains(item)){
            System.out.println("\n* Haha, you have this item, keep moving! *\n");
        }
        else{
            System.out.println("\n* Hehehe, you don't have it yet. \nYou have missed a chance grabbing this item as well. *\n");
    
        }


    }

    /**
     * method for see if it can fly and if it can will fly to the corresponding coordinates
     * @param x the x coordinate wanting to go to
     * @param y the y coordinate wanting to go to
     */
    public void fly(int x, int y){

        boolean canFly;
        if (myBag.items.contains("teleport")){
            canFly = true;
        } else{
            canFly = false;
        }       

        if(x>=-5 && x<=5 && y>=-5 && y<=5 && canFly){
            this.xCoord = x;
            this.yCoord = y;
            System.out.println("\n* A successfully flight! *\n");
        } else {
            System.out.println("\n* Invalid location *\n");
        }
    }

    /* main for the game */
    public static void main(String args[]){

        Scanner name = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String playername = name.nextLine();
        System.out.println("Hi " + playername + "! Welcome to participate in this game made by X&A company. Now we have created a little you inside this game. \nYou are now inside an empty room.\nPlease find the KEY and EXIT to escape from the room.");
        Human player = new Human(playername);
        
        while (player.xCoord!=3||player.yCoord!=3 || !player.myBag.items.contains("Room key")){
        
            System.out.println("\n You are now at (" + player.xCoord + "," + player.yCoord + ").");
            Scanner direction = new Scanner(System.in);
            System.out.println("Which direction do you want to go? \nHere are some options: left, right, front, or back? \nYou can also see: help or map. \n ");
            String User_direction = direction.nextLine();
            String[] words = User_direction.split(" ") ;
            switch (User_direction.toLowerCase()){
                case "left": player.xCoord -=1; player.myMap.addMap(player.xCoord,player.yCoord); break;
                case "right": player.xCoord +=1; player.myMap.addMap(player.xCoord,player.yCoord); break;
                case "front": player.yCoord +=1; player.myMap.addMap(player.xCoord,player.yCoord); break;
                case "back": player.yCoord -=1; player.myMap.addMap(player.xCoord,player.yCoord); break;
                case "help": System.out.println("\n * There are unlimited steps but the key and the exit are both not far from where you started with. \n Good luck on finding the key and the EXIT. Little surprises on the way might help. * \n\n Commands available: \n grab \n examine \n drop \n left \n right \n front \n back \n map \n help \n yes/no (in response to question of -> Do you like the fairy?) \n"); break;
                case "map": player.myMap.printMap(); break;
                default : System.out.println("\n* Invalid action, ah-oh. *\n"); break;
            } 
        

            if(player.xCoord==1&&player.yCoord==2){
                player.myBag.items.add("Room key");
                System.out.println("\n* You have the key, please find out the way out. Little hint: EXIT is in your front and right. *\n");
            }

            if(player.xCoord==1&&player.yCoord==1){
                System.out.println("\n* An apple is in front of you. \nYou have some choices: grab, drop, or examine! *\n");
                Scanner behavior1 = new Scanner(System.in);
                String User_behavior1 = behavior1.nextLine();
                String[] words1 = User_behavior1.split(" ");
                switch (User_behavior1.toLowerCase()){
                    case "grab" : player.grab("apple"); System.out.println("\n* An apple a day keeps the doctor away. \nYou shocked the doctor! \nThe doctor's hint here: EXIT is in your front and right. \nPlease continue to find the key and exit. *\n"); break;
                    case "drop" : player.drop("apple"); break;
                    case "examine": player.examine("apple"); break;
                }
            }

            if(player.xCoord==-1&&player.yCoord==-1){
                System.out.println("\n* A pineapple is in front of you. \nYou have some choices: grab, drop, or examine! *\n");
                Scanner behavior1 = new Scanner(System.in);
                String User_behavior1 = behavior1.nextLine();
                String[] words1 = User_behavior1.split(" ");
                switch (User_behavior1.toLowerCase()){
                    case "grab" : player.grab("pineapple");System.out.println("\n* Do you like pinapples? We do! \nSpecial hint here: EXIT is in your front and right.\nPlease continue to find the key and exit. *\n"); break;
                    case "drop" : player.drop("pineapple"); break;
                    case "examine": player.examine("pineapple"); break;
                }
            }

            if(player.xCoord==4&&player.yCoord==4){
                System.out.println("\n* A pear is in front of you. \nYou have some choices: grab, drop, or examine!*\n");
                Scanner behavior1 = new Scanner(System.in);
                String User_behavior1 = behavior1.nextLine();
                String[] words1 = User_behavior1.split(" ");
                switch (User_behavior1.toLowerCase()){
                    case "grab" : player.grab("pear");System.out.println("\n* A juicy pear! Energy provided by generous X&A company! \nLittle hint here: EXIT is in your back and left.\nPlease continue to find the key and exit. *\n"); break;
                    case "drop" : player.drop("pear"); break;
                    case "examine": player.examine("pear"); break;
                }
            }

            if(player.xCoord==0&&player.yCoord==-2){
                System.out.println("\n* A magic fairy is in front of you, we just found her from the woods who is willing to help. \nDo you like the fairy? *\n");
                Scanner behavior1 = new Scanner(System.in);
                String User_behavior1 = behavior1.nextLine();
                String[] words1 = User_behavior1.split(" ");
                switch (User_behavior1.toLowerCase()){
                    case "yes": player.myBag.items.add("teleport"); System.out.println("\n* You've got a teleport for a chance to fly. \nGive me the new x Coornate you want to go. *\n");
                    int newxCoord = behavior1.nextInt();
                    System.out.println("\n* Give me a y Coordinate you want to go, but don't go too far, the key and the EXIT is just around where you started with. *\n");
                    int newyCoord = behavior1.nextInt();
                    player.fly(newxCoord,newyCoord); player.xCoord = newxCoord; player.yCoord = newyCoord; player.myMap.addMap(player.xCoord,player.yCoord); break;
                    case "no": System.out.println("\n* You've just rejected a great chance to fly, now guess who will need to walk? *\n"); break;
                }
            }
        
        }

         System.out.println("\n* You win!!! Yeah!!! \n HAHAHA, who knows if it is really you inside the room or what, guess what escaped from the room? *\n");
         name.close();
    
        
    }
    
}