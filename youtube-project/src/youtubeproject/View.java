package youtubeproject;

public class View {

    private Locust viewer;
    public Video movie;

    public View(Locust viewer, Video movie) {
        this.viewer = viewer;
        this.movie = movie;
        this.viewer.setTotalWatched(viewer.getTotalWatched()+1);
        this.movie.setViews(movie.getViews()+1);
    }

    public void toAssess() {
        movie.setAssessment(5);
    }
    public void toAssess(int grade) {
        movie.setAssessment(grade);
    }
    public void toAssess(float percentage) {
        int total = 0;
        if (percentage <= 20) {
            total = 3;
        } else if (percentage <= 50) {
            total = 5;
        } else if (percentage <= 90) {
            total = 8;
        } else {
            total = 10;
        }
        movie.setAssessment(total);
    }

    public Locust getViewer() {
        return viewer;
    }

    public void setViewer(Locust viewer) {
        this.viewer = viewer;
    }

    public Video getMovie() {
        return movie;
    }

    public void setMovie(Video movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "View{" +
                "viewer=" + viewer +
                ", movie=" + movie +
                '}';
    }
}
