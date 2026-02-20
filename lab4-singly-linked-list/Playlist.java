// Playlist class that uses a Singly Linked List to manage a collection of Song objects.
public class Playlist {
    private static class Node{
        Song song;      // Song stores in this node
        Node next;      // reference to next node
        // construct node
        Node(Song song){
            this.song = song;       // initialize song
            this.next = null;       // initialize next reference
        }
//        public Song getSong(){ return song;}
//        public Node getNext(){ return next;}
//        public void setNext(Node n){ next = n;}
    }

    private Node head = null;           // first node reference
    private Node tail = null;           // last node reference
    private Node currentNode = null;    // current node reference
    private int size = 0;               // size of the playlist

    // construct empty playlist
    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    /**
     * Method to adds a song to the end of the playlist.
     * @param song song with title, artist
     */
    public void addSong(Song song) {
        // check if song title is null or empty
        if (song.getTitle() == null || song.getTitle().trim().isEmpty()){
            System.out.println("Song is null or empty!");
            return;
        }
        // check if song artist is null or empty
        if (song.getArtist() == null || song.getArtist().isEmpty()){
            System.out.println("Artist is null or empty!");
            return;
        }
        Node newNode = new Node(song);  // new node object
        if (head ==  null){                 // if head is null
            head = newNode;                     // points head to new added node
            tail = newNode;                     // points tail to new added node
            currentNode = head;                 // set current node points to head
        } else{                             // if head is not null
            tail.next = newNode;                // point next of tail to new added node
            tail = newNode;                     // set tail points to new added node
        }
        size++;                         // increase the size of the list by 1
        System.out.println("Added song: " + song + " to the  playlist");
    }

    /**
     * Method to removes the first occurrence of a song with the given title.
     * Handle two cases: removing the head and removing from elsewhere.
     * Also update the tail if the last song is removed.
     * @param title song title
     */
    public void removeSong(String title) {
        if (title == null || title.isEmpty()) {                 // Check if song title is null or empty
            System.out.println("Title is null or empty!");
            return;
        }
        if (head == null){                                      // Check if head is null
            System.out.println("Playlist is empty!");
            return;
        }
        // Case1: removing head (if removed song matches head)
        if (head.song.getTitle().equalsIgnoreCase(title.trim())){   // if head matches the song to be removed
            Song removedSong = head.song;                               // set the removed song = head.song
            if (currentNode == head){                                       // if the current node is head
                currentNode = head.next;                                        // we need to update current node to head.next
            }                                                               // else if the current node is not head, we do not need to change the current node reference
            head = head.next;                                           // update head points to head.next
            size--;                                                     // update the size of the list by decreasing to 1
            if (size == 0){                                             // check if the list is empty after the update
                tail = null;                                                // set tail points to null
                currentNode = null;                                         // set current node points to null
            }
            System.out.println("Removed: " + removedSong);
            return;
        }
        // Case2: removing elsewhere (if removed song is not head)
        Node prev = head;                                           // set prev points to head
        Node curr = head.next;                                      // set curr points to next after head (head.next)
        while (curr != null){                                       // looping until curr reach the end
            if (curr.song.getTitle().equalsIgnoreCase(title.trim())){   // while looping, check if the removed song matches with curr song
                Song removedSong = curr.song;
                if (currentNode == curr){                                   // if current node matches curr
                    if (curr.next != null){                                     // if curr.next is not null
                        currentNode = curr.next;                                    // set current node = curr.next
                    } else {                                                    // if curr.next is null
                        currentNode = head;                                         // set current node = head
                    }
                }
                prev.next = curr.next;                                  // unlink curr, set next from prev points to next node.
                size--;                                                 // update list size
                if (curr == tail){                                      // check if removing curr = tail
                    tail = prev;                                            // update the tail points to previous node
                }
                System.out.println("Removed: " + removedSong);
                return;
            }
            prev = curr;                                                // after removes curr node, set prev = curr
            curr = curr.next;                                           // and curr = curr.next
        }
        System.out.println("Song:  " + title + " not found!");
        return;
    }

    /**
     * Method to "Plays" the current song (prints its details) and advances to the next song.
     * This wraps around to the beginning if the end is reached (like a circular playlist).
     */
    public void playNext() {
        // check if head is empty, then return
        if (head == null){
            System.out.println("Playlist is empty!");
            return;
        }
        // If currentNode is null, start from the head.
        if (currentNode == null){
            currentNode = head;
        }
//        System.out.println("Playing: " + currentNode.song.getTitle());
        System.out.println("Playing: " + currentNode.song);
        currentNode = currentNode.next;                         // set currentNode to next node while playing current song
        // If you reach the end, loop back to the head.
        if (currentNode == null) {
            currentNode = head;
        }
    }

    /**
     * method to prints all the songs currently in the playlist.
     */
    public void displayPlaylist() {
        // check if head is empty, then return
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("Playlist: ");
        Node tmp = head;
        int index = 1;
        // loop through the list and print all songs
        while (tmp != null){                                // as long as the iterator node is not null
            System.out.println(index + ": " + tmp.song);    // display Playlist with index: song
            tmp = tmp.next;
            index++;
        }
    }

}
