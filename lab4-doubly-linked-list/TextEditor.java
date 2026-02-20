public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;
        // Node constructor...
        Node (String textState, Node prev, Node next){
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        // Clearing Redo History: When a user types new text, the next pointer of the current node is set to null, effectively deleting the forward (redo) history.
        currentNode.next = null;
        // Create a new node with the updated text.
        String updatedText = currentNode.textState + newText;
        Node newNode = new Node(updatedText, currentNode, null);

        // Set its 'prev' to the current node.
        newNode.prev = currentNode;
        // Set the current node's 'next' to this new node.
        currentNode.next = newNode;
        // Finally, update currentNode to point to the new node.
        currentNode = newNode;
    }

    public String undo() {
        // Check if currentNode.prev is not null.
        if (currentNode.prev != null){
            // If it is, move currentNode back and return the text.
            currentNode = currentNode.prev;
        }
        // Otherwise, you can't undo.
        return currentNode.textState;
    }

    public String redo() {
        // Check if currentNode.next is not null.
        if (currentNode.next != null){
            // If it is, move currentNode forward and return the text.
            currentNode = currentNode.next;
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}