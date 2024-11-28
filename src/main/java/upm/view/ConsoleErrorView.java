package upm;

import upm.view.ErrorView;

public class ConsoleErrorView extends ErrorView {

    @Override
    public void show(Error error) {
        if (!error.isNull()) {
            System.out.println(ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
