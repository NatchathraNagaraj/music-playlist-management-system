package music;
import java.util.Scanner;
public class Controller {
    Scanner sn = new Scanner(System.in);
    Model m = new Model() ;
    public int addSong(){
        System.out.print("Enter Song Name ");
        String song = sn.nextLine();
        System.out.print("Enter Singer ");
        String singer = sn.nextLine();
        return m.addSong(song , singer);
    }
    public void viewSong(){
        m.viewSong();
    }
    public void createPlaylist(){
        System.out.println("Enter playlist Name ");
        String playlist = sn.nextLine();
        m.createplaylist(playlist);
    }
    public void addtoPlaylist(){
        System.out.println("Enter playlist name ");
        String playlist = sn.nextLine();
        if(!m.checkExist(playlist)){
            System.out.println(" Playlist not exist ");
        }else{
        while(true){
        System.out.print("Do you need to enter song (y/n): ");
        String ch = sn.nextLine();
        if(ch.equalsIgnoreCase("n"))
         break;
        System.out.print("Enter a song - id : ");
        int song = sn.nextInt();
        sn.nextLine();
        m.addtoPlaylist(playlist, song);}
    }
    }
    public void displayPlaylist(){
        System.out.println("Enter playlist name ");
        String play = sn.nextLine();
        m.displayPlaylist(play);
    }
    int remove;
    public void deleteSong(){
        m.viewSong();
        System.out.print("Enter the song - id that is to be deleted ");
        remove = sn.nextInt();
        sn.nextLine();
        m.deleteSong(remove);
    }
    public void deleteSongInPlaylist(){
        System.out.println("Enter name of the playlist");
        String playlist = sn.nextLine();
        m.displayPlaylist(playlist);
        System.out.print("Enter the song-id to be deleted");
        int song = sn.nextInt();
        sn.nextLine();
        m.deleteSongInPlaylist(playlist, song);
    }
    public void playFromPlaylist(){
        System.out.println("Enter playlist name:");
        String playlist = sn.nextLine();
        if(!m.checkExist(playlist)){
            System.out.println("No such playlist exists");
            return;
        }
        System.out.println("Do you want to shuffle ur playlist ( y - yes / n - no )");
        sn.nextLine();
        String choice = sn.nextLine();
        if(choice == "y"){
            m.shuffle(playlist);
        }
        m.playFromPlaylist(playlist);
    }
}
