package Detabes;

import android.provider.BaseColumns;

public final class PlanTriplanka {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private PlanTriplanka() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "planInfo";
        public static final String COLUMN_1 = "Group Name";
        public static final String COLUMN_2 = "Place of Name";
        public static final String COLUMN_3 = "Travel Date";
        public static final String COLUMN_4 = "Travel Time";
    }
}