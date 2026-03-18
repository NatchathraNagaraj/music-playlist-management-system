package music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Model m = new Model();
        view v = new view();
        Controller con = new Controller();
        Scanner sn = new Scanner(System.in);
        while(true){
            v.show();
            int choice = sn.nextInt();
            switch (choice) {
                case 1:
                    int n = con.addSong();
                    System.out.println("Song Id is : " + n);
                    break;
                case 2:
                    con.viewSong();
                    break;
                case 3:
                    con.deleteSong();
                    sn.nextLine();
                    break;
                case 4:
                    con.createPlaylist();
                    break;
                case 5:
                    con.addtoPlaylist();
                    break;
                case 6:
                    v.deleteSongInPlaylist();
                    con.deleteSongInPlaylist();
                    break;
                case 7:
                    con.displayPlaylist();
                    break;
                case 8:
                    con.playFromPlaylist();
                    break;
                case 9:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
