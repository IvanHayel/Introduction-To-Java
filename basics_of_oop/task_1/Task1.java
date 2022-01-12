package basics_of_oop.task_1;

/**
 * Create an object of the TextFile class using the File, Directory classes.
 * Methods: create, rename, display content to the console, add, delete.
 */

public class Task1 {
    public static void main(String[] args) {
        TextFile file = new TextFile("test");

        System.out.println();
        file.append("Hello, my lovely text file!\n");
        file.append("I'm Ivan :)\n");

        System.out.println();
        file.rename("MyLovelyTextFile");
        file.append("I can rename files. WOW!\n");

        System.out.println();
        file.append(String.format("PI = %f", Math.PI));
        file.display();

        System.out.println();
        file.write("REWRITE THIS");
        file.display();

        System.out.println();
        TextFile fileToDelete = new TextFile("DELETE_ME");
        fileToDelete.append("DELETE ME");
        fileToDelete.display();
        fileToDelete.delete();
        fileToDelete.write("I can't write something or append to deleted file...");
    }
}