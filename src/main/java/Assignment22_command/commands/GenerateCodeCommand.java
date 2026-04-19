package Assignment22_command.commands;

import Assignment22_command.Command;
import Assignment22_command.Editor;

public class GenerateCodeCommand implements Command {
        Editor editor;

        public GenerateCodeCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute GenerateCodeCommand");
            editor.generateCodeCommand();
        }
    }