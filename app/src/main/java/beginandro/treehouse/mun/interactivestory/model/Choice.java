package beginandro.treehouse.mun.interactivestory.model;

/**
 * Created by Mun on 7/13/2016.
 */
public class Choice {
    private String mText;
    private int mPageId;

    public String getText() {
        return mText;
    }

    public Choice(String text, int pageId) {
        mText = text;
        mPageId = pageId;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getPageId() {
        return mPageId;
    }

    public void setPageId(int pageId) {
        mPageId = pageId;
    }
}
