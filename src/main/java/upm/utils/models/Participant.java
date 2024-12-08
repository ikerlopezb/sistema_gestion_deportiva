package upm.utils.models;

import upm.utils.Category;

public interface Participant {
    String getKey();
    double getRank(Category category);
    Participant isParticipant(String key);
}
