package upm.model;

import upm.Category;

public interface Participant {
    String getKey();
    double getRank(Category category);
}
