import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

   static  LinkedList<Song> playList=new LinkedList<>();
    public static void main(String[] args) {

       Album a1=new Album("Thaman", "SS Thaman");
       Album a2=new Album("DSP","Devi Sri Prasad");

       a1.addSongToAlbum("thee thalapathy",4.55);
       a1.addSongToAlbum("Bham Akhanda",4.44);
       a1.addSongToAlbum("thar maar thakkar maar",5.53);

       a2.addSongToAlbum("ey bidda edhi naa adda",6.55);
       a2.addSongToAlbum("poonakaalu loading",5.55);
       a2.addSongToAlbum("Srivalli",5.45);

     a1.addToPlayListFromAlbum(2,playList);
     a1.addToPlayListFromAlbum("Bham Akhanda",playList);
     a2.addToPlayListFromAlbum(2,playList);
     a2.addToPlayListFromAlbum("poonakaalu loading",playList);

     play(playList);
    }
    public static void play(LinkedList<Song> playList){
        ListIterator<Song> itr=playList.listIterator();
        Scanner sc=new Scanner(System.in);

        boolean isForward=false;
        if(playList.size()>0)
        {
            System.out.println(itr.next());
            isForward=true;
        }
        else
        {
            System.out.println("Your PlayList is Empty");
        }

        printMenu();
        boolean quit=false;
        while(!quit)
        {
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(itr.hasNext())
                    {
                        if(isForward==false)
                        {
                            itr.next();
                            isForward=true;
                        }
                        System.out.println(itr.next());
                    }
                    else
                    {
                        System.out.println("There is No next Song to play");
                    }
                    break;
                case 2:
                    if(itr.hasPrevious())
                    {
                        if(isForward==true)
                        {
                            itr.previous();
                            isForward=false;
                        }
                        System.out.println(itr.previous());
                    }
                    else
                    {
                        System.out.println("There is No previous Song to play");
                    }
                    break;
                case 3:
                    if(isForward==true)
                    {
                        System.out.println(itr.previous());
                        isForward=false;
                    }
                    else
                    {
                        System.out.println(itr.next());
                        isForward=true;
                    }
                    break;
                case 4:
                    if(playList.size()>0)
                    {
                        for (Song song : playList)
                        {
                            System.out.println(song);
                        }
                    }else
                    {
                        System.out.println("There is no songs in your playList");
                    }
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }



    }
    public static void printMenu() {

        System.out.println("1 - Play the next song");
        System.out.println("2 - Play the previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Print all the songs");
        System.out.println("5 - Print the playMenu again");
        System.out.println("6 - Remove the song");
        System.out.println("7 - EXIT");
        System.out.println("");
        System.out.println("Enter Your Choice");
    }
}