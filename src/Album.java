import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String title;
   private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        songs=new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){
        for(Song s:songs){
            if(s.getName().equals(title)){
                return true;
            }
        }
        return false;
    }
    public void addSongToAlbum(String name, double duration){
        Song song=new Song(name,duration);

        if(findSong(song.getName())==true)
        {
            System.out.println("Song already present in the album");
        }
        else
        {
            songs.add(song);
            System.out.println("Song " +"\""+name+"\""+" has been added successfully");
        }
        return;
    }
    public void addToPlayListFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title))
        {
            for(Song song:songs)
            {
                if(title.equals(song.getName()))
                {
                    playlist.add(song);
                    System.out.println("Song "+"\""+title+"\""+" added to PlayList");
                }
            }
        }
        else
        {
            System.out.println("Song not present in the album");
        }
    }
    public void addToPlayListFromAlbum(int trackNo, LinkedList<Song> playlist){
            int index=trackNo-1;
            if(index>=0&&index<trackNo)
            {
                playlist.add(songs.get(index));
                System.out.println("Song "+"\""+title+"\""+" added to PlayList");
            }
            else
            {
                System.out.println("Song not present in the album");
            }
    }




}
