package com.soc.uoc.pqtm.mybooks;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soc.uoc.pqtm.mybooks.model.Books;

import java.text.SimpleDateFormat;

/**
 * A fragment representing a single Book detail screen.
 * This fragment is either contained in a {@link BookListActivity}
 * in two-pane mode (on tablets) or a {@link BookDetailActivity}
 * on handsets.
 */
public class BookDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Books.BookItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Books.ITEM_MAP.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitol());
            }
        }
    }
                // emplena la activitat detail
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.book_detail, container, false);
        SimpleDateFormat dformat = new SimpleDateFormat("dd/mm/yyyy");

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
              Integer identificador = getResources().getIdentifier(mItem.getUrlImatge(),"drawable", BuildConfig.APPLICATION_ID);
            ((ImageView) rootView.findViewById(R.id.detail_imatgeUrl)).setImageResource(identificador);
            ((TextView) rootView.findViewById(R.id.detail_autor)).setText(mItem.getAutor());
            ((TextView) rootView.findViewById(R.id.detail_descripcio)).setText(mItem.getDescripcio());
            ((TextView) rootView.findViewById(R.id.detail_datapublicacio)).setText(dformat.format(mItem.getDataPublicacio()));
        }
        return rootView;
    }
}
