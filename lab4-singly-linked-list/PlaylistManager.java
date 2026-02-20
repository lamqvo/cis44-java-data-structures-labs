import java.util.Scanner;

public class PlaylistManager {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        while (true){
            menu();
            String choice = scanner.nextLine().trim();
            System.out.println("Selected: " + choice);
            switch (choice){
                case "1": {
                    System.out.println("Full Playlist");
                    playlist.displayPlaylist();
                    break;
                }
                case "2": {
                    System.out.println("Add Song To Playlist");
                    System.out.println("Enter Song Title: ");
                    String songTitle = scanner.nextLine();
                    System.out.println("Enter Artist Name: ");
                    String artistName = scanner.nextLine();
                    Song song = new Song(songTitle, artistName);
                    playlist.addSong(song);
                    break;
                }
                case "3": {
                    System.out.println("Remove Song From Playlist");
                    System.out.println("Enter Song Title: ");
                    String songTitle = scanner.nextLine();
                    playlist.removeSong(songTitle);
                    break;
                }
                case "4": {
                    System.out.println("Play Song From Playlist");
                    playlist.playNext();
                    break;
                }
                case "5": {
                    System.out.println("Quit");
                    return;
                }
                default: {
                    System.out.println("Invalid option!");
                    break;
                }
            }
        }
    }

    /**
     * Method to print the Playlist Manager menu
     */
    private static void menu(){
        System.out.println("Select options from the Playlist Manager");
        System.out.println("1. Display Playlist");
        System.out.println("2. Add Song To Playlist");
        System.out.println("3. Remove Song From Playlist");
        System.out.println("4. Play");
        System.out.println("5. Quit");
    }
}
