package beginandro.treehouse.mun.interactivestory.model;

/**
 * Created by Mun on 7/13/2016.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice choice1;
    private Choice choice2;

    private boolean mIsFinalPage =false;

    //constructor for pages that are not final pages, meaning they have choices for further navigation
    public Page(int imageId,String text, Choice choice1, Choice choice2) {
        mText = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
        mImageId = imageId;
        mIsFinalPage =false;
    }

    //constructor for pages that are final or last and have no choices for further navigation
    public Page(int imageId, String text) {
        mImageId = imageId;
        mText = text;
        choice1=null;
        choice2=null;
        mIsFinalPage =true;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }


    public boolean isFinalPage() {
        return mIsFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        mIsFinalPage = finalPage;
    }


}
