package upm.commands;

import upm.commands.Command;

public class ScoreCommand extends Command {

    public ScoreCommand(){
        super("score");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
        assert updateScore >= -999999.0;
        if(exist(player)){
            player.setScore(updateScore);
        }
    }
}
