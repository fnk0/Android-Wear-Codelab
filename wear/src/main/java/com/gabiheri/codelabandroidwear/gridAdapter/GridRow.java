package com.gabiheri.codelabandroidwear.gridAdapter;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 8/1/14.
 */
public class GridRow  {

    ArrayList<GridPage> mPages = new ArrayList<GridPage>();

    public GridRow() {}

    public GridRow(ArrayList<GridPage> mPages) {
        this.mPages = mPages;
    }

    public GridPage getPage(int index) {
        return mPages.get(index);
    }

    public void addPage(GridPage mPage) {
        mPages.add(mPage);
    }

    public int getSize() {
        return mPages.size();
    }

    public ArrayList<GridPage> getPagesArray() {
        return mPages;
    }

    public void setPages(ArrayList<GridPage> mPages) {
        this.mPages = mPages;
    }
}
