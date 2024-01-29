import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class App {
    public static void main(String[] args) throws Exception {

    }

}

class Platform {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Show> shows = new ArrayList<Show>();
    Scanner dn = new Scanner(System.in);

    public Platform() {

    }

    public void signUp() {
        accounts.add(new Account());
    }

    public Account login() {
        String user;
        String pass;
        System.out.println("plz enter name: ");
        user = dn.next();
        int x = 0;
        for (Account e : accounts) {
            if (e.getName().equals(user)) {
                x++;
                break;
            }
        }
        int y = 0;
        if (x == 1) {
            System.out.println("plz enter pass: ");
            pass = dn.next();
            for (Account u : accounts) {
                if (u.getPass().equals(pass)) {
                    y++;
                    break;
                }
            }
        } else {
            System.out.println("no user");
            return null;
        }
        if (y == 0) {
            System.out.println("wrong pass");
            return null;
        }

    }

    public void searchShows() {
        String sorM;
        System.out.println("series or movies: ");
        sorM = dn.next();
        if(sorM == "Series"){
            for(Movie d: ) {
                System.out.println(d);
            }
        }
        else if (sorM == "Movie"){

        }
    }

    public void displayTop10() {
        Collections.sort(shows);
        for (int i = 0; i < 10; i++) {
            System.out.println(shows[i].toString());
        }
    }
}

class Account {
    private String userName;
    private String password;
    Scanner hn = new Scanner(System.in);

    public Account() {
        System.out.println("enter name: ");
        userName = hn.next();
        System.out.println("enter password: ");
        password = hn.next();
    }

    public String getName() {
        return userName;
    }

    public String getPass() {
        return password;
    }
}

interface Ratable {
    int Max = 10;

    void updateRate();
}

abstract class Show implements Ratable, Comparable {
    protected String name;
    protected int timesWatched;
    protected String describtion;
    protected double rate;
    Scanner in = new Scanner(System.in);

    public Show(String name, String describtion) {
        this.name = name;
        this.describtion = describtion;
        timesWatched = 0;
        rate = 0;
    }

    public void updateRate() {
        timesWatched++;
        System.out.println("enter rate: ");
        int x = in.nextInt();
        while (x < 0 || x > Max) {
            System.out.println("plz enter valid number");
            x = in.nextInt();
        }
        rate = (rate + x) / timesWatched;

    }

    @Override
    public String toString() {
        return " Name: " + name + "  rate: " + rate + "\n" + "  Desc: " + describtion;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Show) {
            return name == ((Show) o).name;
        } else {
            return this == o;
        }
    }

    @Override
    public int compareTo(Show s) {
        if (rate > s.rate) {
            return 1;
        } else if (rate == s.rate) {
            return 0;
        } else {
            return -1;
        }
    }

    public abstract int getDuration(){
        
    }

}

class Series extends Show {
    int numOfEpisodes;
    int episodeDuration;

    public Series(String name, String description, int numOfEpisodes, int episodeDuration) {
        super(name, description);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "numofepisodes : " + numOfEpisodes + "  episodeDuration: " + episodeDuration;
    }

    @Override
    public int getDuration() {
        return numOfEpisodes * episodeDuration;
    }

}

class Movie extends Show {
    int duration;
    int productionYear;

    public Movie(String name, String description, int productionYear, int duration) {
        super(name, description);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Duration : " + duration + "  prodYear: " + productionYear;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && ((Movie) o).productionYear == productionYear) {
            return true;
        } else {
            return false;
        }
    }
}

interface Comparable<E> {
    int compareTo(Show s);
}
