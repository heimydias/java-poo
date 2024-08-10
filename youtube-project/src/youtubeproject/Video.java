package youtubeproject;

public class Video implements VideoActions {

    private String title;
    private int assessment;
    private int views;
    private int likes;
    private boolean reproducing;

    public Video(String title) {
        this.title = title;
        this.assessment = 1;
        this.views = 0;
        this.likes = 0;
        this.reproducing = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        int nova;
        nova = (int) ((this.assessment + assessment)/views);
        this.assessment = nova;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isReproducing() {
        return reproducing;
    }

    public void setReproducing(boolean reproducing) {
        this.reproducing = reproducing;
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void like() {

    }

    @Override
    public String toString() {
        return "Video{" +
                "title=" + title +
                ", assessment=" + assessment +
                ", views=" + views +
                ", likes=" + likes +
                ", reproducing=" + reproducing +
                '}';
    }
}
