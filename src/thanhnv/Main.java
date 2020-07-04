package thanhnv;

import thanhnv.command.CommandProcesser;

public class Main {

    public static void main(String[] args) {
        CommandProcesser commandProcesser = new CommandProcesser();
        commandProcesser.process();
    }
}
