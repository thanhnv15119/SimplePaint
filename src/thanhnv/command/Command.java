package thanhnv.command;

import thanhnv.drawer.DrawerAction;

public interface Command <T extends DrawerAction> {
    void validate(String command);
    T exec(String command);
}
