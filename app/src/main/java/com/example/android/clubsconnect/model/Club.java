package com.example.android.clubsconnect.model;

/**
 * <i><b>Club</b></i>
 * <p>
 *     This Model Class is used to represent a single Club in our application.
 * </p>
 *
 */

class Club {
    // MEMBER VARIABLES

    private String mClubTitle;
    private String mCollege;
    private int mId;
    private Author mAdmin;

    // GETTERS
    //Test

    //comment under a comment
//test1

    public void setClubTitle(String clubTitle) { this.mClubTitle = clubTitle; }

    public void setCollege(String college) { this.mCollege = college; }

    public void setID(int id) { this.mId = id; }

    public void setAdmin(Author admin) { this.mAdmin = admin; }

    // CONSTRUCTORS

    /**
     * <b>Default Constructor</b>
     * <p>
     *     Used for debugging and quick testing purposes.
     * </p>
     */
    public Club() {
        this.mClubTitle = "This is not a real club";
        this.mCollege = "Not a real university";
        this.mId = -1;
    }

    // SETTERS

    public String getClubTitle() { return this.mClubTitle; }

    public String getCollege() { return this.mCollege; }

    public int getID() { return this.mId; }

    public Author getAdmin() {return this.mAdmin; }

    /**
     * <b>equals()</b>
     * <p>
     *     This method overrides the default equals method. It is used to verify if a Club
     *     contains identical data compared to a passed object.
     * </p>
     * @param obj
     *          - Object passed to the method will be compared with respect to equivalency
     *          to the Club calling this method.
     * @return
     *          - true if equals, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Club)) {
            return false;
        }

        Club other = (Club) obj;

        return other.getClubTitle().equals(this.mClubTitle) &&
                other.getCollege().equals(this.mCollege)    &&
                other.getID() == this.mId                   &&
                other.getAdmin().equals(this.mAdmin);
    }

    /**
     * <b>toString()</b>
     * <p>
     *     - This toString should not be used to print the Club to the user. It returns a formatted
     *      string calling the toString of each member variable in the Club object.
     * </p>
     * @return
     *     - String dump of all member variables.
     */
    @Override
    public String toString() {
        return "Club Title: "   + mClubTitle  +
                "\nCollege: "   + mCollege    +
                "\nAdmin: "     + mAdmin      +
                "\nID: "        + mId;
    }
}
