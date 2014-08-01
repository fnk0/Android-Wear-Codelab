package com.gabiheri.codelabandroidwear.gridAdapter;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 8/1/14.
 */
public class GridPage  {

    private String mTitle;
    private String mText;
    private int mIcon;
    private int mBackground;

    /**
     * Constructor for the GridPage
     * @param mTitle
     *          Title for the card
     * @param mText
     *          Text for the card
     * @param mIcon
     *          Icon that will be on the right of the title
     * @param mBackground
     *          The Background image to be used by the fragment. The card will overlay on top of the background.
     */
    public GridPage(String mTitle, String mText, int mIcon, int mBackground) {
        this.mTitle = mTitle;
        this.mText = mText;
        this.mIcon = mIcon;
        this.mBackground = mBackground;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getText() {
        return mText;
    }


    public int getIcon() {
        return mIcon;
    }


    public int getBackground() {
        return mBackground;
    }

}
