package command;

public interface Command {
    Long getId();
    String getDescription();
    void execute();
}
