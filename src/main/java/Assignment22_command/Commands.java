package Assignment22_command;

public class Commands {


    class MoveCursorUpCommand implements Command {
        Editor editor;

        public MoveCursorUpCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute MoveCursorUpCommand");
            editor.moveCursorUpCommand();
        }
    }

    class MoveCursorDownCommand implements Command {
        Editor editor;

        public MoveCursorDownCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute MoveCursorDownCommand");
            editor.moveCursorDownCommand();
        }
    }

    class MoveCursorLeftCommand implements Command {
        Editor editor;

        public MoveCursorLeftCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute MoveCursorLeftCommand");
            editor.moveCursorLeftCommand();
        }
    }

    class MoveCursorRightCommand implements Command {
        Editor editor;

        public MoveCursorRightCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute MoveCursorRightCommand");
            editor.moveCursorRightCommand();
        }
    }

    class TogglePixelCommand implements Command {
        Editor editor;

        public TogglePixelCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute TogglePixelCommand");
            editor.togglePixelCommand();
        }
    }

    class GenerateCodeCommand implements Command {
        Editor editor;

        public GenerateCodeCommand(Editor editor){
            this.editor = editor;
        }

        public void execute(){
            System.out.println("Execute GenerateCodeCommand");
            editor.generateCodeCommand();
        }
    }


}
