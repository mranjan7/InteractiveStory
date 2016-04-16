package interactivestory.karroltontech.com.interactivestory.model;

/**
 * Created by mranjan on 03-04-2016.
 */
public class Choice {

    private String text;
    private int nextPage;

    Choice(String text,int nextPage)
    {
        this.text=text;
        this.nextPage=nextPage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
