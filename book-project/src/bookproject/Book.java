package bookproject;

public class Book implements Publication{

    private String title;

    private String author;

    private int totalPages;
    private int currentPage;
    private boolean open;
    private Person reader;

    public String details() {
        return "bookproject.Book:" +
                "\ntitle= " + title +
                ", author= " + author +
                "\ntotal pages= " + totalPages +
                ", current page= " + currentPage +
                ", open= " + open +
                "\nreader= " + reader.getName() +
                ", age= " + reader.getAge() +
                ", sex= " + reader.getSex();
    }

    public Book(String title, String author, int totalPages, Person reader) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.open = false;
        this.currentPage = 0;
        this.reader = reader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Person getReader() {
        return reader;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    @Override
    public void open() {
        open = true;
    }

    @Override
    public void close() {
        open = false;
    }

    @Override
    public void leafThrough(int p) {
        if (p > totalPages) {
            currentPage = 0;
        } else {
            currentPage = p;
        }
    }

    @Override
    public void pageForward() {
        currentPage++;
    }

    @Override
    public void pageBack() {
        currentPage--;
    }
}
