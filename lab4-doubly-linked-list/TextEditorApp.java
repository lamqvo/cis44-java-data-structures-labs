import java.util.Scanner;

public class TextEditorApp {
    public static void main(String[] args){
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        while (true){
            menu();
            String option = scanner.nextLine();
            switch (option) {
                case "1": {
                    System.out.println("Enter your text: ");
                    String newText = scanner.nextLine();
                    textEditor.add(newText);
                    break;
                }
                case "2": {
                    System.out.println("Undo: ");
                    textEditor.undo();
                    break;
                }
                case "3": {
                    System.out.println("Redo: ");
                    textEditor.redo();
                    break;
                }
                case "4": {
                    System.out.println("Print: ");
                    textEditor.printCurrent();
                    break;
                }
                case "5": {
                    System.out.println("Exit!");
                    return;
                }
                default: {
                    System.out.println("Invalid input!");
                    continue;
                }
            }
        }
    }
    private static void menu(){
        System.out.println("Text Editor Menu.  Pick a number:");
        System.out.println("1. Enter Text");
        System.out.println("2. Undo Text");
        System.out.println("3. Redo Text");
        System.out.println("4. Print Text");
        System.out.println("5. Exit");
    }
}
