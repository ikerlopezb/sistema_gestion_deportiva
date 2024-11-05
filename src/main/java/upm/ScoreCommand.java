package upm;

public class ScoreCommand extends Command {

    public ScoreCommand(PlayerList playerList){
        super("score");
    }
    public void execute(String input){
        assert isYours(input);
        assert updateScore >= -999999.0;
        if(exist(player)){
            player.setScore(updateScore);
        }
    }
}
