package music;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
class Song{
    String singer;
    String song;
    Song(String song , String singer){
        this.song = song;
        this.singer = singer;
    }
}
public class Model {
    int next = 0;
    private HashMap<Integer  , Song > songs = new HashMap<>();
    public int addSong( String song, String singer){
        songs.put(next++ , new Song(song , singer));
        return next-1;
    }
    public void viewSong(){
        System.out.println("Songs present in the general list ");
        for(HashMap.Entry<Integer,Song> entry : songs.entrySet()) {
            Song p = entry.getValue();
            System.out.println("Id:" + entry.getKey());
            System.out.println("Song : "+p.song);
            System.out.println("Singer : "+p.singer);
        }
    }
    private HashMap<String,ArrayList<Integer>> playlists = new LinkedHashMap<>();
    public void createplaylist(String playlist){
        if(!playlists.containsKey(playlist)){
            playlists.put(playlist, new ArrayList<>());
            System.out.println("Playlist "+playlist+" has been created successfully!!");
        }
       else{
        System.out.println("Playlist with this name already exists");
       }
    }
    public boolean checkExist(String playlist){
        return playlists.containsKey(playlist);
    }
    public void addtoPlaylist(String playlist , int id ){
        if(!songs.containsKey(id)){
            System.out.println("No song of such id exits ");
            return;
        }
        if(playlists.containsKey(playlist)){
            ArrayList<Integer> pl = playlists.get(playlist);
            pl.add(id);
            playlists.put(playlist , pl );
        }
        System.out.println("Song Added Successfully");
    }
    public void displayPlaylist(String play ){
        ArrayList<Integer> ls = playlists.get(play);
        if(ls==null){
            System.out.println("Empty Playlist");
            return ;
        }
        System.out.println("Displaying Songs from the playlist "+play);
        System.out.println("Current song count in the playlist "+ls.size());
        for(int songid : ls ){
            Song p = songs.get(songid);
            String song = p.song;
            String singer = p.singer;
            System.out.println("ID:" +songid);
            System.out.println("Song : "+song);
            System.out.println("Singer : "+singer);
        }
        System.out.println("End of the playlist...!");
    }
    public void deleteSong(int id ){
        if(songs.containsKey(id)){
            Song p = songs.get(id);
            System.out.println("Song of id "+id+" is deleted Successfully");
            System.out.println("Song : " +p.song);
            System.out.println("Singer : " +p.singer);
            songs.remove(id);
            for(ArrayList<Integer> list : playlists.values()){
            list.remove(Integer.valueOf(id));
        }
        }
        else{
            System.out.println("No such songs Exist ");
        }
    }
    public void deleteSongInPlaylist(String playlist , int song ){
        if(!playlists.containsKey(playlist)){
            System.out.println("No such Playlist exists ");
            return;
        }
        ArrayList<Integer>songss = playlists.get(playlist);
        if(songss.remove(Integer.valueOf(song))){
            System.out.println("Song deleted Successfully");
        }
        else{
            System.out.println("No such song Exist ");
        }
    }
    public void playFromPlaylist(String playlist){
        if(!playlists.containsKey(playlist)){
            System.out.println("No playlist with the name "+playlist+ "exists");
            return;
        }
        ArrayList<Integer> ls = playlists.get(playlist);
        for( int id : ls ){
            Song p = songs.get(id);
            System.out.println("Playing.."+p.song);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("Exception occured");
            }
        }
    }
    public void shuffle(String playlist){
        ArrayList<Integer>ls = playlists.get(playlist);
        Collections.shuffle(ls, new Random(3));
    }
}
