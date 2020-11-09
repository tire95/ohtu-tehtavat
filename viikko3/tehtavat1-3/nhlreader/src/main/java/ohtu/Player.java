
package ohtu;

public class Player implements Comparable{
    private String name;
    private String team;
    private String nationality;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    private int goals;
    private int assists;

    public void setName(String name, String team, int goals, int assists) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        int points = goals + assists;
        return name + "    " + team + "    " + goals + "+" + assists + "=" + points;
    }
    
    @Override
    public int compareTo(Object o) {
        Player p = ((Player) o);
        return (p.getGoals() + p.getAssists()) - (this.goals + this.assists);
    }
      
}
